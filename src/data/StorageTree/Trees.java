//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��7��27��
//��6.3.3   ��/ɭ�ֵĸ�ĸ�����ֵ�����ʵ��
//3.  ���ĺ������ʾ��
//�Ľ���4�棬�����û�в������
package data.StorageTree;
//�������࣬�����ض����������ľ�̬����
public class Trees
{
    //�Ժ������ʾ��������prelist����洢����ɭ�֣��ĺ������ʾ�ַ�������
    //�ǵݹ��㷨����������ӷ�ʽ��û�е��÷��ء������㷽��
    public static Tree<String> create(String[] prelist)
    {
        Tree<String> tree = new Tree<String>();            //��������
        if(prelist.length==0)
            return tree;                                   //���ؿ���
        tree.root = new TreeNode<String>(prelist[0]);      //���������
        TreeNode<String> p = tree.root;
        int len=0;                                         //len��p����'\t'����
        for(int i=1; i<prelist.length; i++)                //��prelist[i]������Ϊɭ�������һ�����������һ������
        {
            int n=0;
            while(n<prelist[i].length() && prelist[i].charAt(n)=='\t')
                n++;                                       //ͳ��prelist[i]����'\t'ǰ׺����
            
            String str = prelist[i].substring(n);          //���Ԫ�أ�ȥ��prelist[i]��������'\t'ǰ׺
            if(n==len+1)                                   //prelist[i]��p��һ��'\t'ǰ׺��������Ϊp�ĺ���
            {
                p.child = new TreeNode<String>(str, p);    //����p�ĺ��ӽ�㣨Ҷ�ӣ�
                p = p.child;
            }
            else
            {
                while(n<len)                               //prelist[i]��p��'\t'�٣�p����Ѱ�Ҳ���λ��
                {
                    p = p.parent;
                    len--;
                }
                p.sibling = new TreeNode<String>(str, p.parent);//ͬ�㣬����str��Ϊp�����¸��ֵ�
                p = p.sibling;
            }
            len=n;
        }
        return tree;
    }   
}
//@author  Yeheya��2015��11��7�գ�2019��7��27��