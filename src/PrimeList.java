//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��7��22��
//��2.3.2  ������
//����2.2�� �������Ա�ʹ�õ�����洢��
//��2.3.4  ѭ��˫����
//ʹ�õ�����Ҳ��ʹ��˳���ѭ��˫����洢��������
//4.2 ���С���4.3��������������⡣��

//�������Ա����򣩣�ʹ�õ�����洢��Ҫ��β�����ʱ�临�Ӷ���O(1)
public class PrimeList 
{
    private int range;                           //������Χ����
    private SinglyList<Integer> list;            //�������洢������ѭ��˫����Ҳ��
    
    public PrimeList(int range)                  //���췽�����洢2��range����������
    {
        if(range<=1)
            throw new java.lang.IllegalArgumentException("range="+range);//��Ч�����쳣
        this.range = range;
        this.list = new SinglyList<Integer>();   //����յ�����
        this.list.insert(2);                     //�����֪����С����
        Node<Integer> rear=this.list.head.next;  //βָ��
        for(int key=3;  key<=range;  key+=2)     //���������������������ż��
        {
            if(this.isPrime(key))                //��key����������β���룬O(1)
            {
                rear.next = new Node<Integer>(key, null);
                rear = rear.next;
            }
//            System.out.println("������"+this.list.toString());
        }
    }
    
    public boolean isPrime(int key)              //�ж�key�Ƿ�������������this.list������
    {
        if(key<=1)
            throw new java.lang.IllegalArgumentException("key="+key);//��Ч�����쳣
//        System.out.print("����"+key+"��");
        int sqrt = (int)Math.sqrt(key);          //Math.sqrt(key)����key��ƽ����ֵ���ٽ�doubleǿ��ת����int��С�����ֽ�β
        //��list�е���֪��������key����������list�����Է�Χ��sqrt(key)
        for(Node<Integer> p=list.head.next;  p!=null && p.data<=sqrt;  p=p.next)
        {
//            System.out.print("%"+p.data+"��");
            if(key % p.data==0)
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
        return "2��"+range+"������"+this.list.toString()+"��"+this.list.size()+"��Ԫ��";
    }
    
    public static void main(String args[])
    {
        System.out.println(new PrimeList(100).toString());
    }
}
/*
�������н�����£�
����3��true
����5��%2��true
����7��%2��true
����9��%2��%3��false
����11��%2��%3��true
����13��%2��%3��true
����15��%2��%3��false
����17��%2��%3��true
����19��%2��%3��true
2��20�������ϣ�CirDoublyList(2,3,5,7,11,13,17,19)��8��Ԫ��

����3��true
����5��% 2��true
����7��% 2��true
����9��% 2��% 3��false
����11��% 2��% 3��true
����13��% 2��% 3��true
����15��% 2��% 3��false
����17��% 2��% 3��true
����19��% 2��% 3��true
����21��% 2��% 3��false
����23��% 2��% 3��true
����25��% 2��% 3��% 5��false
����27��% 2��% 3��false
����29��% 2��% 3��% 5��true
����31��% 2��% 3��% 5��true
����33��% 2��% 3��false
����35��% 2��% 3��% 5��false
����37��% 2��% 3��% 5��true
����39��% 2��% 3��false
����41��% 2��% 3��% 5��true
����43��% 2��% 3��% 5��true
����45��% 2��% 3��false
����47��% 2��% 3��% 5��true
����49��% 2��% 3��% 5��% 7��false
����51��% 2��% 3��false
����53��% 2��% 3��% 5��% 7��true
����55��% 2��% 3��% 5��false
����57��% 2��% 3��false
����59��% 2��% 3��% 5��% 7��true
����61��% 2��% 3��% 5��% 7��true
����63��% 2��% 3��false
����65��% 2��% 3��% 5��false
����67��% 2��% 3��% 5��% 7��true
����69��% 2��% 3��false
����71��% 2��% 3��% 5��% 7��true
����73��% 2��% 3��% 5��% 7��true
����75��% 2��% 3��false
����77��% 2��% 3��% 5��% 7��false
����79��% 2��% 3��% 5��% 7��true
����81��% 2��% 3��false
����83��% 2��% 3��% 5��% 7��true
����85��% 2��% 3��% 5��false
����87��% 2��% 3��false
����89��% 2��% 3��% 5��% 7��true
����91��% 2��% 3��% 5��% 7��false
����93��% 2��% 3��false
����95��% 2��% 3��% 5��false
����97��% 2��% 3��% 5��% 7��true
����99��% 2��% 3��false
2��100������CirDoublyList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97)��25��Ԫ��

*/
//@author��Yeheya��2015��10��1�գ�2019��7��22��