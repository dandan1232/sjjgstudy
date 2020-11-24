//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��8��11��
//��7.1.2   ͼ������������
//ͼ�ӿ�
package data.PicGraph;
public interface Graph<T>                        //ͼ�ӿڣ���ʾͼ�����������ͣ�Tָ������Ԫ������
{
    int vertexCount();                           //���ض�����
    T get(int i);                                //���ض���viԪ��
    void set(int i, T x);                        //���ö���viԪ��Ϊx
    int insert(T x);                             //����Ԫ��ֵΪx�Ķ��㣬���ض������
    void insert(int i, int j, int w);            //����ߡ�vi,vj����ȨֵΪw
    T remove(int i);                             //ɾ������vi��������ı�
    void remove(int i, int j);                   //ɾ���ߡ�vi,vj��
    int search(T key);                           //���Ҳ������׸���key���Ԫ�صĶ������
    T remove(T key);                             //���Ҳ�ɾ���׸���key���Ԫ�ض��㼰������ı�
    int weight(int i, int j);                    //���ء�vi,vj���ߵ�Ȩֵ

    void DFSTraverse(int i);                     //ͼ��������ȱ������Ӷ���vi����
    void BFSTraverse(int i);                     //ͼ�Ĺ�����ȱ������Ӷ���vi����
    void minSpanTree();                          //�����Ȩ����ͼ����С��������Prim�㷨
    void shortestPath(int i);                    //���Ȩͼ����vi�ĵ�Դ���·����Dijkstra�㷨
    void shortestPath();                         //���Ȩͼÿ�Զ��������·�������ȣ�Floyd�㷨
}
//@author��Yeheya��2015��11��15�գ�2019��8��11��