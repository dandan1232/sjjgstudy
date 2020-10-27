
public class Main {
    public static void main(String[] args){
    //write your code here
     Node<String>p,q;
     Node<String>head;
     p=new Node<String>("A",null);
     q=new Node<String>("B",null);
     p.next=q;
     head=p;
     while (null!=head){
         System.out.println(head.toString());
         head=head.next;
     }
    }
}
