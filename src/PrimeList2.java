/*
//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��7��22��
//��2.3.2  ������
//����2.2�� �������Ա�ʹ�õ�����洢��
//��2.3.4  ѭ��˫����
//ʹ��˳���ѭ��˫����洢��������
//4.2 ���С���4.3�� ������������⡣��

//�������Ա����򣩣�ʹ��˳����ѭ��˫����洢��Ҫ��β�����ʱ�临�Ӷ���O(1)��
public class PrimeList2 
{
    private int range;                           //������Χ����
//    private SeqList<Integer> list;             //˳����洢�������Ա�ѭ��˫����Ҳ��
    private CirDoublyList<Integer> list;         //ѭ��˫����
    
    public PrimeList2(int range)                 //���췽�����洢2��range����������
    {
        if(range<=1)
            throw new java.lang.IllegalArgumentException("range="+range);//��Ч�����쳣
        this.range = range;
//        this.list = new SeqList<Integer>();    //�����˳���
        this.list = new CirDoublyList<Integer>();//�����ѭ��˫����
        this.list.insert(2);                     //�����֪����С����
        for(int key=3; key<=range; key+=2)       //���������������������ż��
            if(this.isPrime(key))                //��key����������β���룬O(1)
            	this.list.insert(key);           //β�������ֵ��O(1)
    }
    
    public boolean isPrime(int key)              //�ж�key�Ƿ�������������this.list������
    {
        if(key<=1)
            throw new java.lang.IllegalArgumentException("key="+key);//��Ч�����쳣
//        System.out.print("����"+key+"��");
        int sqrt = (int)Math.sqrt(key);          //Math.sqrt(key)����key��ƽ����ֵ���ٽ�doubleǿ��ת����int��С�����ֽ�β
        //��list�е���֪��������key����������list�����Է�Χ��sqrt(key)
        for(int i=0;  i<list.size() && list.get(i)<=sqrt;  i++)
//        for(DoubleNode<Integer> p=list.head.next;  p!=list.head && p.data<=sqrt;  p=p.next)
        {
//            System.out.print("%"+p.data+"��");
            if(key % list.get(i)==0)
//            if(key % p.data==0)
            {
//                System.out.println("false");
                return false;
            }                
        }
//        System.out.println("true");
        return true;
    }

    public String toString()                     //��������Ԫ�ص������ַ���
    {
        return "2��"+range+"�������ϣ�"+list.toString()+"��"+list.size()+"��Ԫ��";
    }
    
    public static void main(String args[])
    {
        System.out.println(new PrimeList2(100).toString());
    }
}
*/
/*
�������н�����£�
2��100�������ϣ�SeqList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97) ��25��Ԫ��

2��100�������ϣ�CirDoublyList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97)��25��Ԫ��

*//*

//@author��Yeheya��2015��10��1�գ�2019��7��22��*/
