package data.singly;

/**
 * @author Flobby
 * @version :1.0
 * @date :2020/10/13
 * @ClassName :
 */

public class Main {
    public static void main(String[] args) {
//        write your code here
        Node<String> p,q,a,b,c;
        Node<String> head;
        p = new Node<String>("A",null);
        q = new Node<String>("B",null);
        a = new Node<String>("c",null);
        b = new Node<String>("d",null);
        c = new Node<String>("e",null);
        p.next=q;
        q.next=a;
        a.next=b;
        b.next=c;
        head = p;
        while(null!=head){
            System.out.println(head.toString());
            head = head.next;
        }
    }
}
