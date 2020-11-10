//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��7��25��
//��6.1.3   �������Ķ�������ʵ��
//2.  ���ö��������洢�Ķ�����������
//��˼����6-2�� ���ڱ����Ĳ���
//����6.1��  �������Ĺ��졢���������롣
//��˼����6-3�������ϰ����
package data.BinaryTTree;
import data.stackandqueue.LinkedQueue;
import data.stackandqueue.LinkedStack;
import data.stackandqueue.Queue;
import data.stackandqueue.Stack;

//�������࣬���������洢��Tָ������Ԫ������       //һЩ������Ϊʵ���⣬д��ExBinaryTree<T>����
public class BinaryTree<T>  extends Object  //implements BinaryTTree<T>
{
    public BinaryNode<T> root;                   //����㣬�����������ṹ

    public BinaryTree()                          //����ն�����
    {
        this.root=null;
    }
    public boolean isEmpty()                     //�ж��Ƿ�ն�����
    {
        return this.root==null;
    }

    //3. �������Ĳ�����
    public void insert(T x)            //����xԪ����Ϊ����㣬x!=null��ԭ�������Ϊx������
    {
        if(x!=null)
            this.root = new BinaryNode<T>(x, this.root, null);
    }
    //ע�⣺��������ΪinsertRoot(T x)����Ϊ��һ��������û�У������÷����ɱ����ࣨ���������������ǡ�
    //�������������this.root�������ؽ�㡣
    
    //����xԪ����Ϊp������/�Һ��ӽ�㣬x!=null��p!=null��leftָ����/�Һ��ӣ�ȡֵΪtrue���󣩡�false���ң���
    //p��ԭ��/�Һ��ӳ�Ϊx������/�Һ��ӣ����ز����xԪ�ؽ�㡣��x==null��p==null�������룬����null
    public BinaryNode<T> insert(BinaryNode<T> p, boolean left, T x)
    {
        if(x==null || p==null)
            return null;
        if(left)                                 //����xΪp������/�Һ��ӣ����ز�����
            return p.left = new BinaryNode<T>(x, p.left, null);
        return p.right = new BinaryNode<T>(x, null, p.right);
    }

    //4.  ������ɾ������
    //ɾ��p������/��������leftָ����/��������ȡֵΪtrue���󣩡�false���ң�
    ////���ɾ������������5��̲�ûд 
    public void remove(BinaryNode<T> p, boolean left)
    {
        if(p!=null)
        {
            if(left)
            {
                System.out.println("ɾ��������"+toString(p.left));   //�ȸ�������������������������
                p.left = null;
            }
            else
            {
                System.out.println("ɾ��������"+toString(p.right));   //�ȸ�������������������������
                p.right = null;
            }
        }
    }
    ////˵����û�з���Ԫ�أ���Ϊɾ����һ���������кܶ�Ԫ�ء�
    
    public void clear()                          //ɾ�������������н�㣬ɾ�������
    {
        this.root = null;
    }

    
    //5. �������������ȵı����㷨
    public void preorder()                       //�ȸ��������������
    {
//        System.out.print("�ȸ����������������  ");
        preorder(this.root);                     //�����ȸ���������������ĵݹ鷽��
        System.out.println();
    }    
    public void preorder(BinaryNode<T> p)       //�ȸ����������p���Ϊ�����������ݹ鷽��
    {
        if(p!=null)                              //������������
        {
            System.out.print(p.data.toString()+" "); //���ȷ��ʵ�ǰ���Ԫ��
            preorder(p.left);                    //���ȸ��������p�����������ݹ���ã�����Ϊ����
            preorder(p.right);                   //���ȸ��������p�����������ݹ���ã�����Ϊ�Һ���
        }
    }
    //ע�⣺����private��������� 
    
    public void inorder()                        //�и��������������
    {
//        System.out.print("�и����������������  ");
        inorder(this.root);
        System.out.println();
    }    
    public void inorder(BinaryNode<T> p)        //�и����������p���Ϊ�����������ݹ鷽��
    {
        if(p!=null)
        {
            inorder(p.left);                     //�и��������p�����������ݹ����
            System.out.print(p.data.toString()+" ");
            inorder(p.right);                    //�и��������p�����������ݹ����
        }
    }

    public void postorder()                      //����������������
    {
//        System.out.print("������������������  ");
        postorder(this.root);
        System.out.println();
    }
    public void postorder(BinaryNode<T> p)      //������������p���Ϊ�����������ݹ鷽��
    {
        if(p!=null)
        {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data.toString()+" ");  //����ʵ�ǰ���Ԫ��
        }
    }

    //��˼����6-2�� ����5��ϰ����
    public String toString()           //�����ȸ�����������������н��������ַ������������������
    {
        return "�ȸ����������������"+toString(this.root);
    }
    public String toString(BinaryNode<T> p)     //�����ȸ����������pΪ�������������ַ������ݹ鷽��
    {
        if(p==null)
            return "��";                         //������������
        return p.data.toString()+" " + toString(p.left) + toString(p.right);
    }
    
    //��ʵ����6-1�� ����5��ϰ���𡿸Ĵ�
    public int size()                            //���ض������Ľ����
    {
        return size(this.root);
    }
    public int size(BinaryNode<T> p)            //������p���Ϊ���������Ľ����
    {
        if(p==null)
            return 0;
        return 1+size(p.left)+size(p.right);
    }

    //��ʵ����6-1���μ��⣬����5��ϰ����ûд
    public int height()                          //���ض������ĸ߶�
    {
        return height(this.root);
    }
    public int height(BinaryNode<T> p)          //������p���Ϊ���������߶ȣ�����������
    {
        if(p==null)
            return 0;
//        int lh = height(p.left);                 //�����������ĸ߶�
//        int rh = height(p.right);                //�����������ĸ߶�
//        return (lh>=rh) ? lh+1 : rh+1;           //��ǰ�����߶�Ϊ�ϸ������ĸ߶ȼ�1
        return Math.max(height(p.left),height(p.right))+1; //��ǰ�����߶�Ϊ�ϸ������ĸ߶ȼ�1
    }

    //6. ���������
    //��2�� �������������ȸ����б�ʾ
    public BinaryTree(T[] prelist)               //�Ա������������ȸ�����������й��������
    {
        this.root = create(prelist);
    }
    //�Դ�i��ʼ�ı������������ȸ����У�����һ����prelist[i]Ϊ�������������������ĸ���㡣
    //�ݹ��㷨�ȴ�������㣬�ٴ�����������������
    private int i=0;
    private BinaryNode<T> create(T[] prelist)
    {
        BinaryNode<T> p = null;
        if(i<prelist.length)
        {
            T elem=prelist[i++];
            if(elem!=null)                       //����elem!="��"����ΪT��һ����String
            {
                p = new BinaryNode<T>(elem);     //����Ҷ�ӽ��
                p.left = create(prelist);        //����p�����������ݹ���ã�ʵ�ʲ�������ʽ������ͬ
                p.right = create(prelist);       //����p�����������ݹ���ã�ʵ�ʲ�������ʽ������ͬ
            }
        }
        return p;
    }
    //����6.1��  �������Ĺ��졢���������롣

    
    //��˼����6-3�������ϰ����
    public BinaryTree(BinaryTree<T> bitree)      //�������췽�������
    {
        this.root = copy(bitree.root);
    }

    //������p�����Ӷ������������½��Ӷ������ĸ���㡣
    //�㷨�ȴ�������㣬�ٴ�����������������
    public BinaryNode<T> copy(BinaryNode<T> p)
    {
        BinaryNode<T> q=null;
        if(p!=null)
        {
            q = new BinaryNode<T>(p.data);
            q.left = copy(p.left);               //�������������ݹ����
            q.right = copy(p.right);             //�������������ݹ����
        }
        return q;                                //���ؽ��������ĸ����
    }
    
    //7.  �������Ĺ������ʾ
    //��1�� �������ʾ
    //��4��
    public void printGenList()                   //����������Ĺ������ʾ�ַ���
    {
        System.out.print("�������Ĺ������ʾ��");
        printGenList(this.root);
        System.out.println();
    }
    //�����p���Ϊ����һ�������Ĺ������ʾ�ַ������ȸ�����������ݹ��㷨
    public void printGenList(BinaryNode<T> p)
    {
        if(p==null)                              //����������
            System.out.print("��");              //������������
        else            
        {   System.out.print(p.data.toString()); //���ʵ�ǰ���
            if(p.left!=null || p.right!=null)    //��Ҷ�ӽ�㣬������
            {
                System.out.print("(");
                printGenList(p.left);            //���p�����������ݹ����
                System.out.print(",");
                printGenList(p.right);           //���p�����������ݹ����
                System.out.print(")");
            }
        }
    }
    //��5��
    public String toGenListString()              //���ض������Ĺ������ʾ�ַ���
    {
        return "�������Ĺ������ʾ��"+toGenListString(this.root);
    }
    //������p���Ϊ����һ�������Ĺ������ʾ�ַ������ȸ�����������ݹ��㷨
    public String toGenListString(BinaryNode<T> p)
    {
        if(p==null)
            return "��";                          //���ؿ��������
        if(p.left==null && p.right==null)         //p��Ҷ�ӽ��(p.isLeaf())
            return p.data.toString();
        return p.data.toString()+"("+toGenListString(p.left)+","+toGenListString(p.right)+")";
    }
    //����6.2�� �������Ĺ������ʾ��
    
    
    //8��ʹ��ջ����������
    public void preorderTraverse()               //�ȸ���������������ķǵݹ��㷨
    {
        System.out.print("�ȸ����������������ʹ��ջ����");
        Stack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>(); //������ջ
        BinaryNode<T> p = this.root;
        while(p!=null || !stack.isEmpty())       //p�ǿջ�ջ�ǿ�ʱ    ////������for���
        {
            if(p!=null)
            {
                System.out.print(p.data+" ");    //���ʽ��
                stack.push(p);                   //p�����ջ
                p=p.left;                        //����������
            }
            else                                 //pΪ����ջ�ǿ�ʱ
            {
                System.out.print("�� ");
                p=stack.pop();                   //pָ���ջ���
                p=p.right;                       //����������
            }
        }
        System.out.println("��");
    }    

    //��˼����6-5�� 
    public void inorderTraverse()                //�и���������������ķǵݹ��㷨
    {
        System.out.print("�и����������������ʹ��ջ����");
        Stack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();   //����һ����ջ
        BinaryNode<T> p = this.root;
        while(p!=null || !stack.isEmpty())       //p�ǿջ�ջ�ǿ�ʱ
        {
            if(p!=null)
            {
                stack.push(p);                   //p�����ջ
                p=p.left;                        //����������
            }
            else                                 //pΪ����ջ�ǿ�ʱ
            {
                System.out.print("�� ");
                p=stack.pop();                   //pָ���ջ���
                System.out.print(p.data+" ");    //���ʽ��
                p=p.right;                       //����������
            }
        }
        System.out.println("��");
    }
    

    //9. �������Ĳ�α���
    //��5��̲�д���㷨ͬ���Ĳ�α�����ͼ��һ�ι������������������������
    public void levelorder()                    //����α���������
    {
        System.out.print("��α�����������  ");
        if(this.root==null)
            return;
        //�¾䴴���ն��У����ж��е�Ԫ�������Ƕ��������BinaryNode<T>
//        Queue<BinaryNode<T>> que=new SeqQueue<BinaryNode<T>>();
        Queue<BinaryNode<T>> que=new LinkedQueue<BinaryNode<T>>(); //��ʽ����
        que.add(this.root);                      //��������
        while(!que.isEmpty())                    //�����в���ʱѭ��////�ö��в�����Ϊѭ�����������е���
        {
            BinaryNode<T> p=que.poll();          //pָ����ӽ��////�����пշ���null
            System.out.print(p.data+ " ");       //���ʳ��ӽ��p
            if(p.left!=null)    
                que.add(p.left);                 //p�����ӽ�����
            if(p.right!=null)
                que.add(p.right);                //p���Һ��ӽ�����
        }
        System.out.println();
    }   
    //ע�⣺���ж�����������ͼ�Ĳ�α����㷨Ҫ�ػ��ˣ��������ӡ�
    
    //10���Բ�α������й�����ȫ������
    //�����Բ�α�������levellist�������ȫ������
    public static<T> BinaryTree<T> createComplete(T[] levellist)
    {
        BinaryTree<T> bitree = new BinaryTree<T>(); 
        bitree.root = create(levellist, 0);
        return bitree;
    }

    //������levellist[i]Ϊ�������������������ĸ����
    private static<T> BinaryNode<T> create(T[] levellist, int i)
    {
        BinaryNode<T> p = null;
        if(i<levellist.length)
        {
            p = new BinaryNode<T>(levellist[i]);           //����Ҷ�ӽ��
            p.left = create(levellist, 2*i+1);             //����p��������
            p.right = create(levellist, 2*i+2);            //����p��������
        }
        return p;
    }    
}
//@author��Yeheya��2016-1-22��2019��10��13�գ�2020��2��16��