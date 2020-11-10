//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年7月25日
//§6.1.3   二叉树的二叉链表实现
//2.  采用二叉链表存储的二叉树类声明
//【思考题6-2】 基于遍历的操作
//【例6.1】  二叉树的构造、遍历及插入。
//【思考题6-3】深拷贝【习题解答】
package data.BinaryTTree;
import data.stackandqueue.LinkedQueue;
import data.stackandqueue.LinkedStack;
import data.stackandqueue.Queue;
import data.stackandqueue.Stack;

//二叉树类，二叉链表存储，T指定结点的元素类型       //一些方法作为实验题，写在ExBinaryTree<T>类中
public class BinaryTree<T>  extends Object  //implements BinaryTTree<T>
{
    public BinaryNode<T> root;                   //根结点，二叉链表结点结构

    public BinaryTree()                          //构造空二叉树
    {
        this.root=null;
    }
    public boolean isEmpty()                     //判断是否空二叉树
    {
        return this.root==null;
    }

    //3. 二叉树的插入结点
    public void insert(T x)            //插入x元素作为根结点，x!=null，原根结点作为x的左孩子
    {
        if(x!=null)
            this.root = new BinaryNode<T>(x, this.root, null);
    }
    //注意：不能声明为insertRoot(T x)，因为，一，集合中没有；二，该方法可被子类（二叉排序树）覆盖。
    //方法结果作用于this.root，不返回结点。
    
    //插入x元素作为p结点的左/右孩子结点，x!=null且p!=null，left指定左/右孩子，取值为true（左）、false（右）；
    //p的原左/右孩子成为x结点的左/右孩子；返回插入的x元素结点。若x==null或p==null，不插入，返回null
    public BinaryNode<T> insert(BinaryNode<T> p, boolean left, T x)
    {
        if(x==null || p==null)
            return null;
        if(left)                                 //插入x为p结点的左/右孩子，返回插入结点
            return p.left = new BinaryNode<T>(x, p.left, null);
        return p.right = new BinaryNode<T>(x, null, p.right);
    }

    //4.  二叉树删除子树
    //删除p结点的左/右子树，left指定左/右子树，取值为true（左）、false（右）
    ////输出删除的子树，第5版教材没写 
    public void remove(BinaryNode<T> p, boolean left)
    {
        if(p!=null)
        {
            if(left)
            {
                System.out.println("删除子树："+toString(p.left));   //先根次序遍历二叉树，输出空子树
                p.left = null;
            }
            else
            {
                System.out.println("删除子树："+toString(p.right));   //先根次序遍历二叉树，输出空子树
                p.right = null;
            }
        }
    }
    ////说明：没有返回元素，因为删除了一棵子树，有很多元素。
    
    public void clear()                          //删除二叉树的所有结点，删除根结点
    {
        this.root = null;
    }

    
    //5. 二叉树孩子优先的遍历算法
    public void preorder()                       //先根次序遍历二叉树
    {
//        System.out.print("先根次序遍历二叉树：  ");
        preorder(this.root);                     //调用先根次序遍历二叉树的递归方法
        System.out.println();
    }    
    public void preorder(BinaryNode<T> p)       //先根次序遍历以p结点为根的子树，递归方法
    {
        if(p!=null)                              //若二叉树不空
        {
            System.out.print(p.data.toString()+" "); //则先访问当前结点元素
            preorder(p.left);                    //按先根次序遍历p的左子树，递归调用，参数为左孩子
            preorder(p.right);                   //按先根次序遍历p的右子树，递归调用，参数为右孩子
        }
    }
    //注意：不能private，子类等用 
    
    public void inorder()                        //中根次序遍历二叉树
    {
//        System.out.print("中根次序遍历二叉树：  ");
        inorder(this.root);
        System.out.println();
    }    
    public void inorder(BinaryNode<T> p)        //中根次序遍历以p结点为根的子树，递归方法
    {
        if(p!=null)
        {
            inorder(p.left);                     //中根次序遍历p的左子树，递归调用
            System.out.print(p.data.toString()+" ");
            inorder(p.right);                    //中根次序遍历p的右子树，递归调用
        }
    }

    public void postorder()                      //后根次序遍历二叉树
    {
//        System.out.print("后根次序遍历二叉树：  ");
        postorder(this.root);
        System.out.println();
    }
    public void postorder(BinaryNode<T> p)      //后根次序遍历以p结点为根的子树，递归方法
    {
        if(p!=null)
        {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data.toString()+" ");  //后访问当前结点元素
        }
    }

    //【思考题6-2】 【第5版习题解答】
    public String toString()           //返回先根次序遍历二叉树所有结点的描述字符串，包含空子树标记
    {
        return "先根次序遍历二叉树："+toString(this.root);
    }
    public String toString(BinaryNode<T> p)     //返回先根次序遍历以p为根子树的描述字符串，递归方法
    {
        if(p==null)
            return "∧";                         //输出空子树标记
        return p.data.toString()+" " + toString(p.left) + toString(p.right);
    }
    
    //【实验题6-1】 【第5版习题解答】改错
    public int size()                            //返回二叉树的结点数
    {
        return size(this.root);
    }
    public int size(BinaryNode<T> p)            //返回以p结点为根的子树的结点数
    {
        if(p==null)
            return 0;
        return 1+size(p.left)+size(p.right);
    }

    //【实验题6-1】课件题，【第5版习题解答】没写
    public int height()                          //返回二叉树的高度
    {
        return height(this.root);
    }
    public int height(BinaryNode<T> p)          //返回以p结点为根的子树高度，后根次序遍历
    {
        if(p==null)
            return 0;
//        int lh = height(p.left);                 //返回左子树的高度
//        int rh = height(p.right);                //返回右子树的高度
//        return (lh>=rh) ? lh+1 : rh+1;           //当前子树高度为较高子树的高度加1
        return Math.max(height(p.left),height(p.right))+1; //当前子树高度为较高子树的高度加1
    }

    //6. 构造二叉树
    //（2） 标明空子树的先根序列表示
    public BinaryTree(T[] prelist)               //以标明空子树的先根次序遍历序列构造二叉树
    {
        this.root = create(prelist);
    }
    //以从i开始的标明空子树的先根序列，创建一棵以prelist[i]为根的子树，返回子树的根结点。
    //递归算法先创建根结点，再创建左子树、右子树
    private int i=0;
    private BinaryNode<T> create(T[] prelist)
    {
        BinaryNode<T> p = null;
        if(i<prelist.length)
        {
            T elem=prelist[i++];
            if(elem!=null)                       //不能elem!="∧"，因为T不一定是String
            {
                p = new BinaryNode<T>(elem);     //创建叶子结点
                p.left = create(prelist);        //创建p的左子树，递归调用，实际参数与形式参数相同
                p.right = create(prelist);       //创建p的右子树，递归调用，实际参数与形式参数相同
            }
        }
        return p;
    }
    //【例6.1】  二叉树的构造、遍历及插入。

    
    //【思考题6-3】深拷贝【习题解答】
    public BinaryTree(BinaryTree<T> bitree)      //拷贝构造方法，深拷贝
    {
        this.root = copy(bitree.root);
    }

    //复制以p根的子二叉树，返回新建子二叉树的根结点。
    //算法先创建根结点，再创建左子树、右子树
    public BinaryNode<T> copy(BinaryNode<T> p)
    {
        BinaryNode<T> q=null;
        if(p!=null)
        {
            q = new BinaryNode<T>(p.data);
            q.left = copy(p.left);               //复制左子树，递归调用
            q.right = copy(p.right);             //复制右子树，递归调用
        }
        return q;                                //返回建立子树的根结点
    }
    
    //7.  二叉树的广义表表示
    //（1） 广义表表示
    //第4版
    public void printGenList()                   //输出二叉树的广义表表示字符串
    {
        System.out.print("二叉树的广义表表示：");
        printGenList(this.root);
        System.out.println();
    }
    //输出以p结点为根的一棵子树的广义表表示字符串，先根次序遍历，递归算法
    public void printGenList(BinaryNode<T> p)
    {
        if(p==null)                              //若二叉树空
            System.out.print("∧");              //输出空子树标记
        else            
        {   System.out.print(p.data.toString()); //访问当前结点
            if(p.left!=null || p.right!=null)    //非叶子结点，有子树
            {
                System.out.print("(");
                printGenList(p.left);            //输出p的左子树，递归调用
                System.out.print(",");
                printGenList(p.right);           //输出p的右子树，递归调用
                System.out.print(")");
            }
        }
    }
    //第5版
    public String toGenListString()              //返回二叉树的广义表表示字符串
    {
        return "二叉树的广义表表示："+toGenListString(this.root);
    }
    //返回以p结点为根的一棵子树的广义表表示字符串，先根次序遍历，递归算法
    public String toGenListString(BinaryNode<T> p)
    {
        if(p==null)
            return "∧";                          //返回空子树标记
        if(p.left==null && p.right==null)         //p是叶子结点(p.isLeaf())
            return p.data.toString();
        return p.data.toString()+"("+toGenListString(p.left)+","+toGenListString(p.right)+")";
    }
    //【例6.2】 二叉树的广义表表示。
    
    
    //8．使用栈遍历二叉树
    public void preorderTraverse()               //先根次序遍历二叉树的非递归算法
    {
        System.out.print("先根次序遍历二叉树（使用栈）：");
        Stack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>(); //创建空栈
        BinaryNode<T> p = this.root;
        while(p!=null || !stack.isEmpty())       //p非空或栈非空时    ////不能用for语句
        {
            if(p!=null)
            {
                System.out.print(p.data+" ");    //访问结点
                stack.push(p);                   //p结点入栈
                p=p.left;                        //进入左子树
            }
            else                                 //p为空且栈非空时
            {
                System.out.print("∧ ");
                p=stack.pop();                   //p指向出栈结点
                p=p.right;                       //进入右子树
            }
        }
        System.out.println("∧");
    }    

    //【思考题6-5】 
    public void inorderTraverse()                //中根次序遍历二叉树的非递归算法
    {
        System.out.print("中根次序遍历二叉树（使用栈）：");
        Stack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();   //创建一个空栈
        BinaryNode<T> p = this.root;
        while(p!=null || !stack.isEmpty())       //p非空或栈非空时
        {
            if(p!=null)
            {
                stack.push(p);                   //p结点入栈
                p=p.left;                        //进入左子树
            }
            else                                 //p为空且栈非空时
            {
                System.out.print("∧ ");
                p=stack.pop();                   //p指向出栈结点
                System.out.print(p.data+" ");    //访问结点
                p=p.right;                       //进入右子树
            }
        }
        System.out.println("∧");
    }
    

    //9. 二叉树的层次遍历
    //第5版教材写，算法同树的层次遍历、图的一次广度优先搜索遍历，根结点入队
    public void levelorder()                    //按层次遍历二叉树
    {
        System.out.print("层次遍历二叉树：  ");
        if(this.root==null)
            return;
        //下句创建空队列，其中队列的元素类型是二叉树结点BinaryNode<T>
//        Queue<BinaryNode<T>> que=new SeqQueue<BinaryNode<T>>();
        Queue<BinaryNode<T>> que=new LinkedQueue<BinaryNode<T>>(); //链式队列
        que.add(this.root);                      //根结点入队
        while(!que.isEmpty())                    //当队列不空时循环////用队列不空作为循环条件，更有道理
        {
            BinaryNode<T> p=que.poll();          //p指向出队结点////若队列空返回null
            System.out.print(p.data+ " ");       //访问出队结点p
            if(p.left!=null)    
                que.add(p.left);                 //p的左孩子结点入队
            if(p.right!=null)
                que.add(p.right);                //p的右孩子结点入队
        }
        System.out.println();
    }   
    //注意：所有二叉树、树、图的层次遍历算法要重画了，根结点入队。
    
    //10．以层次遍历序列构造完全二叉树
    //返回以层次遍历序列levellist构造的完全二叉树
    public static<T> BinaryTree<T> createComplete(T[] levellist)
    {
        BinaryTree<T> bitree = new BinaryTree<T>(); 
        bitree.root = create(levellist, 0);
        return bitree;
    }

    //创建以levellist[i]为根的子树，返回子树的根结点
    private static<T> BinaryNode<T> create(T[] levellist, int i)
    {
        BinaryNode<T> p = null;
        if(i<levellist.length)
        {
            p = new BinaryNode<T>(levellist[i]);           //创建叶子结点
            p.left = create(levellist, 2*i+1);             //创建p的左子树
            p.right = create(levellist, 2*i+2);            //创建p的右子树
        }
        return p;
    }    
}
//@author：Yeheya。2016-1-22，2019年10月13日，2020年2月16日