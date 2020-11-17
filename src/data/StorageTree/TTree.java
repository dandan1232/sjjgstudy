//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年7月25日
//§6.2.1  树的定义及抽象数据类型
//ADT 树接口
package data.StorageTree;
//ADT TTree<T>                                   //树抽象数据类型，T表示结点元素类型
public interface TTree<T>                        //树接口；测试ADT Tree语法
{ 
    boolean isEmpty();                           //判断是否空树
    int childCount(TreeNode<T> p);               //返回p结点的孩子结点个数
    TreeNode<T> child(TreeNode<T> p, int i);     //返回p结点的第i（i≥0）个孩子结点
    void insert(T x);                            //插入x作为根结点
    TreeNode<T> insert(TreeNode<T> p, int i, T x);//插入x作为p结点的第i（≥0）个孩子，返回插入结点
    T remove(TreeNode<T> p, int i);              //删除p结点的第i（≥0）棵子树，返回被删除元素
    void clear();                                //删除树的所有结点

    void preorder();                             //先根次序遍历树
    void postorder();                            //后根次序遍历树
    void levelorder();                           //层次遍历树
    int size();                                  //返回树的结点数
    int height();                                //返回树的高度
    TreeNode<T> search(T key);                   //查找并返回首个与key相等元素结点
    int level(T key);                            //返回首个与key相等元素结点所在的层次
    void remove(T key);                          //查找并删除首个以与key相等元素为根的子树
}
/*  //以下没写
    boolean contains(T key);                     //判断是否包含与key相等元素
 */
//@author  Yeheya。2015年11月7日，2019年7月26日