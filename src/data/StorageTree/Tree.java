package data.StorageTree;
import data.StorageTree.TreeNode;
//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��7��25��
//��6.2.3   ��/ɭ�ֵĸ�ĸ�����ֵ�����ʵ��
//�Ľ���4�棬�����û�в������

//���࣬���ĸ�ĸ�����ֵ����洢�ṹ��Tָ������Ԫ������
public class Tree<T>  //implements TTree<T>
{
    public TreeNode<T> root;                     //����㣬���ĸ�ĸ�����ֵ�����������

    public Tree()                                //�������
    {
        this.root=null;         
    }
    public boolean isEmpty()                     //�ж��Ƿ����
    {
        return this.root==null;
    }
    
    //3.  ���ı���
    //�����ȸ��ͺ����������㷨
    public void preorder()                       //�ȸ�������������㷨ͬ��������//��5��̲�δ����
    {
        System.out.print("�ȸ����������/ɭ�֣�  ");   
        preorder(root);
        System.out.println();   
    }    
    public void preorder(TreeNode<T> p)         //�ȸ����������pΪ�����������ݹ��㷨
    {
        if(p!=null)
        {
            System.out.print(p.data+" ");
            preorder(p.child);                   //�ȱ��������������ݹ����
            preorder(p.sibling);                 //�ٱ����ֵ��������ݹ����
        }
    }
    
    //��5��̲�д
    //�ȸ�������������㷨�ȸ�����ݹ����������ѭ�������ֵ�����    ////ͼ������������������㷨
    public void preorder2()
    {
        System.out.print("�ȸ����������/ɭ�֣�  ");   
        for(TreeNode<T> p=this.root;  p!=null;  p=p.sibling) //pѭ�����������ֵ�����ɭ��
            preorder2(p);                        //������p���Ϊ����һ����
        System.out.println();   
    }    
    public void preorder2(TreeNode<T> p)         //�ȸ����������pΪ�����������ݹ��㷨
    {
        if(p!=null)
        {
            System.out.print(p.data+" ");
            for(TreeNode<T> q=p.child;  q!=null;  q=q.sibling)//qѭ������p.child���ֵ���
                preorder2(q);                    //�ȸ��������p��һ���������ݹ����
        }
    }
    
    public void postorder()                      //������������
    {
        System.out.print("������������/ɭ�֣�  ");   
        postorder(root);
        System.out.println();   
    }
    public void postorder(TreeNode<T> p)        //������������pΪ�����������ݹ��㷨���㷨ͬ���������и��������
    {
        if(p!=null)
        {
            postorder(p.child);                  //����p����������
            System.out.print(p.data+" ");
            postorder(p.sibling);                //����p���ֵ�����
        }
    }

    public int size()                            //�������Ľ��������㷨ͬ������
    {
        return size(root);
    }
    public int size(TreeNode<T> p)               //������p���Ϊ���������Ľ�����
    {
        if(p==null)
            return 0;
        return 1+size(p.child)+size(p.sibling);
    }
    
    //4. ���ĺ������ʾ��
    //��2�� �ȸ������������������ĺ������ʾ
    public String toString()                     //�������ĺ������ʾ�ַ��������ȸ����������
    {
        return "��/ɭ�ֵĺ������ʾ�� \n "+toString(root, "");
    }
    //�ȸ����������pΪ����������tabָ�������������������ĺ������ʾ�ַ������ݹ��㷨
    public String toString(TreeNode<T> p, String tab)
    {
        if(p==null)
            return "";
        return tab+p.data.toString()+"\n" + toString(p.child, tab+"\t")
                                          + toString(p.sibling, tab);
    }
    //����6.6��   �����ĺ������ʾ����һ�ó�����/ɭ�֡�
}
//@author  Yeheya��2016��1��22�գ�2019��7��27��