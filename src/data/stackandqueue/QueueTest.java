package data.stackandqueue;

/**
 * @author Flobby
 * @version :1.0
 * @date :2020/10/27
 * @ClassName :
 */

public class QueueTest {
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
        while(!que.isEmpty()) {
            System.out.print(que.poll().toString()+"  ");
        }
        System.out.println();
    }
}
