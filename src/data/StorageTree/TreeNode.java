//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��7��27��
//��6.3.3   ��/ɭ�ֵĸ�ĸ�����ֵ�����ʵ��
//1. ���ĸ�ĸ�����ֵ���������
//�Ľ���4�棬û�в������
package data.StorageTree;
public class TreeNode<T>                         //���ĸ�ĸ�����ֵ��������࣬Tָ������Ԫ������
{
    public T data;                               //������
    public TreeNode<T> parent, child, sibling;   //��ĸ����������ӽ�������ֵܽ����
    
    //�����㣬�����ֱ�ָ��Ԫ�ء���ĸ��㡢���ӽ����ֵܽ��
    public TreeNode(T data, TreeNode<T> parent, TreeNode<T> child, TreeNode<T> sibling)
    {
        this.data = data;
        this.parent = parent;
        this.child = child;
        this.sibling = sibling;
    }
    public TreeNode(T data, TreeNode<T> parent)  //����Ҷ�ӽ�㣬parentָ���丸ĸ���
    {
        this(data, parent, null, null);
    }
    public TreeNode(T data)                      //����Ҷ�ӽ��
    {
        this(data, null, null, null);
    }
    public String toString()                     //���ؽ��������������ַ���
    {
        return this.data.toString();
    }    
    
    public boolean isLeaf()                      //�ж��Ƿ�Ҷ�ӽ��
    {
        return this.child==null;
    }    
}
/*
    //���������·���
    public TreeNode()
    {
        this(null, 0, null, null, null);
    }
    public boolean equals(Object obj)            //�Ƚ��������ֵ�Ƿ���ȣ�����Object���equals(obj)����
    {
        return obj==this || obj instanceof TreeNode<?> && this.data.equals(((TreeNode<T>)obj).data);
    }   
*/
//@author  Yeheya��2015��11��7�գ�2019��7��27��