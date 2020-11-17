//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��7��25��
//��6.2.1  ���Ķ��弰������������
//ADT ���ӿ�
package data.StorageTree;
//ADT TTree<T>                                   //�������������ͣ�T��ʾ���Ԫ������
public interface TTree<T>                        //���ӿڣ�����ADT Tree�﷨
{ 
    boolean isEmpty();                           //�ж��Ƿ����
    int childCount(TreeNode<T> p);               //����p���ĺ��ӽ�����
    TreeNode<T> child(TreeNode<T> p, int i);     //����p���ĵ�i��i��0�������ӽ��
    void insert(T x);                            //����x��Ϊ�����
    TreeNode<T> insert(TreeNode<T> p, int i, T x);//����x��Ϊp���ĵ�i����0�������ӣ����ز�����
    T remove(TreeNode<T> p, int i);              //ɾ��p���ĵ�i����0�������������ر�ɾ��Ԫ��
    void clear();                                //ɾ���������н��

    void preorder();                             //�ȸ����������
    void postorder();                            //������������
    void levelorder();                           //��α�����
    int size();                                  //�������Ľ����
    int height();                                //�������ĸ߶�
    TreeNode<T> search(T key);                   //���Ҳ������׸���key���Ԫ�ؽ��
    int level(T key);                            //�����׸���key���Ԫ�ؽ�����ڵĲ��
    void remove(T key);                          //���Ҳ�ɾ���׸�����key���Ԫ��Ϊ��������
}
/*  //����ûд
    boolean contains(T key);                     //�ж��Ƿ������key���Ԫ��
 */
//@author  Yeheya��2015��11��7�գ�2019��7��26��