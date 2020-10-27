//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��7��24��
//��4.2.2   ���еĴ洢��ʵ��

public class Queue_ex 
{
	public static void main(String args[])
	{
	    Queue<Integer> que = new SeqQueue<Integer>(-5);
	    que.add(new Integer(10)); 
	    que.add(new Integer(20)); 
	    System.out.println("poll : "+que.poll().toString()+"  "+que.poll().toString()+"  ");
	    System.out.println(que.toString());
	    que.add(new Integer(30)); 
	    que.add(new Integer(40)); 
	    que.add(new Integer(50)); 
	    que.add(new Integer(60)); 
	    System.out.println(que.toString());
	    que.add(new Integer(70)); 
	    System.out.println(que.toString());
	    
        que = new LinkedQueue<Integer>();
        System.out.print("add: ");
        for(int i=1; i<=5; i++)
        {
            Integer intobj = new Integer(i);
            que.add(intobj);
            System.out.print(intobj+"  ");
        }    
        System.out.println("\n"+que.toString());

        System.out.print("poll : ");
        while(!que.isEmpty())
            System.out.print(que.poll().toString()+"  ");
        System.out.println();
	}
}
/*
�������н�����£�
poll : 10  20  
SeqQueue()��front=2��rear=2
SeqQueue(30,40,50,60)��front=2��rear=1
SeqQueue(30,40,50,60,70)��front=0��rear=5
add: 1  2  3  4  5  
LinkedQueue(1,2,3,4,5)
poll : 1  2  3  4  5  

*/
//@author��Yeheya��2014��7��3�գ�2019��7��24��