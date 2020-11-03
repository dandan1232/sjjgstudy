//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��12��29��
//��5.3   �����
//��5.3.1   ������弰������������

//ADT GenLList<T>
//�����ӿڣ����������������ͣ�T��ʾ����Ԫ�ص��������ͣ����з������η�Ĭ��public abstract
package data.Gen;
public interface GenLList<T>
{
    boolean isEmpty();                           //�ж��Ƿ�ձ����շ���true
    int size();                                  //���ع������
    int depth();                                 //���ع�������
    GenNode<T> get(int i);                       //���ص�i��Ԫ�ؽ�㣬0��i<����
    GenNode<T> insert(int i, T x);               //����ԭ��x��Ϊ��i��Ԫ�أ����ز�����
    GenNode<T> insert(int i, GenList<T> genlist);//�����ӱ�genlist��Ϊ��i��Ԫ�أ����ز�����
    GenNode<T> remove(int i);                    //ɾ����i��Ԫ�ؽ�㣬���ر�ɾ�����
    void clear();                                //ɾ������Ԫ�ؽ���㣬ͷ���ͱ�������
    GenNode<T> search(T key);                    //���Ҳ������׸���key���ԭ�ӽ��
    GenNode<T> remove(T key);                    //���Ҳ�ɾ���׸���key���ԭ�ӽ�㣬���ر�ɾ�����
}
//
/*
 */
//@author��Yeheya��2014��10��6�գ�2016-1-22��2019��12��29�գ�2020��2��3��