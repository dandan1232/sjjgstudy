//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��7��23��
//��4.1.2   ջ�Ĵ洢��ʵ��
//2.  ��ʽջ

//��ʽջ�࣬�����࣬ʵ��ջ�ӿڣ�T��ʾ����Ԫ�ص���������
public final class LinkedStack<T> implements Stack<T> {
    private SinglyList<T> list;                  //ʹ�õ�����2.3.2�ڣ��洢ջԪ��

    public LinkedStack()                         //�����ջ
    {
        this.list = new SinglyList<T>();         //����յ�����
    }

    public boolean isEmpty()                     //�ж�ջ�Ƿ�գ���Ϊ�գ��򷵻�true
    {
        return this.list.isEmpty();
    }

    public void push(T x)                        //Ԫ��x��ջ���ն�������ջ
    {
        this.list.insert(0, x);                  //������ͷ����Ԫ��x
    }

    public T peek()                              //����ջ��Ԫ�أ�δ��ջ������ջΪ�գ��򷵻�null
    {
        return this.list.get(0);
    }

    public T pop()                               //��ջ������ջ��Ԫ�أ���ջΪ�գ��򷵻�null
    {
        return this.list.remove(0);              //��ջ���գ�������ͷɾ��������ɾ��Ԫ��
    }

    public String toString()                     //����ջ����Ԫ�ص������ַ�������ʽΪ��(,)��
    {
//        return this.list.toString();
        return this.getClass().getName() + " " + this.list.toString();
    }

    //����������ֱ�������õ�
    public LinkedStack(LinkedStack<T> stack)     //���  
    {
        this.list = new SinglyList<T>(stack.list);//ִ�е������������췽��
    }

    public void copy(LinkedStack<T> stack)       //ջ���
    {
        this.list = new SinglyList<T>(stack.list);//ִ�е������������췽��
    }

    public void clear()                          //���ջ
    {
        this.list.clear();
    }
}
//@author��Yeheya��2014��7��1�գ�2019��10��5�գ�2020��7��23��