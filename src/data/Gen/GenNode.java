//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��12��29��
//��5.3   �����
//��5.3.2   �����Ĵ洢�ṹ��ʵ��
//2. ���������
package data.Gen;

public class GenNode<T>                          //��������࣬Tָ������Ԫ������
{
    public T data;                               //������
    public GenList<T> child;                     //��ַ��ָ���ӱ�
    public GenNode<T> next;                      //��ַ��ָ���̽��

    //�����㣬dataָ��Ԫ�أ�childָ���ӱ�nextָ���̽��
    public GenNode(T data, GenList<T> child, GenNode<T> next) 
    {
        this.data = data;
        this.child = child;
        this.next = next;
    }
    
    public GenNode()
    {
        this(null, null, null);
    }
    
    //û��ֱ�ӵ��á�Ϊ�˵���ʱ�õġ�
    public String toString()                     //���ؽ��������������ַ���
    {
        return this.data.toString();
    }
}
/*  //���µ�5��ûд
    public GenNode(T data)
    {
        this(data, null, null);
    }
*/
//@author��Yeheya��2014��10��6�գ�2019��12��29�գ�2020��1��31��