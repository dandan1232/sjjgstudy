package data.stackandqueue;

public class StackTest {
    public static void main(String[] args)
    {
        SeqStack<String> stack1 = new SeqStack<String>(20); //构造空栈
        System.out.print("Push: ");
        char ch='a';
        for(int i=0;i<5;i++)
        {
            String str = (char)(ch+i)+"";
            stack1.push(str);
            System.out.print(str+"  ");
        }

        LinkedStack<Integer> stack2 = new LinkedStack<Integer>();
        System.out.print("\nPush: ");
        for (int i=1; i<=5; i++)
        {
            Integer intobj = new Integer(i);
            stack2.push(intobj);
            System.out.print(intobj+"  ");
        }

        System.out.println("\nStack: "+stack2.toString());
        System.out.print("Pop : ");
        while(!stack2.isEmpty())                  //全部出栈
        {
            System.out.print(stack2.pop().toString()+"  ");
        }
        System.out.println();
    }
}