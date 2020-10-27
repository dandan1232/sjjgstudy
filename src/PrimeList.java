//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年7月22日
//§2.3.2  单链表
//【例2.2】 素数线性表，使用单链表存储。
//§2.3.4  循环双链表
//使用单链表，也可使用顺序表、循环双链表存储素数环。
//4.2 队列【例4.3】求解素数环问题。用

//素数线性表（升序），使用单链表存储，要求尾插入的时间复杂度是O(1)
public class PrimeList 
{
    private int range;                           //素数范围上限
    private SinglyList<Integer> list;            //单链表，存储素数表，循环双链表也可
    
    public PrimeList(int range)                  //构造方法，存储2～range中所有素数
    {
        if(range<=1)
            throw new java.lang.IllegalArgumentException("range="+range);//无效参数异常
        this.range = range;
        this.list = new SinglyList<Integer>();   //构造空单链表
        this.list.insert(2);                     //添加已知的最小素数
        Node<Integer> rear=this.list.head.next;  //尾指针
        for(int key=3;  key<=range;  key+=2)     //测试奇数，不需测试其他偶数
        {
            if(this.isPrime(key))                //若key是素数，则尾插入，O(1)
            {
                rear.next = new Node<Integer>(key, null);
                rear = rear.next;
            }
//            System.out.println("素数表："+this.list.toString());
        }
    }
    
    public boolean isPrime(int key)              //判断key是否是素数，遍历this.list单链表
    {
        if(key<=1)
            throw new java.lang.IllegalArgumentException("key="+key);//无效参数异常
//        System.out.print("测试"+key+"，");
        int sqrt = (int)Math.sqrt(key);          //Math.sqrt(key)返回key的平方根值，再将double强制转换成int，小数部分截尾
        //用list中的已知素数测试key，遍历部分list，测试范围到sqrt(key)
        for(Node<Integer> p=list.head.next;  p!=null && p.data<=sqrt;  p=p.next)
        {
//            System.out.print("%"+p.data+"？");
            if(key % p.data==0)
            {
//                System.out.println("false");
                return false;
            }                
        }
//        System.out.println("true");
        return true;
    }

    public String toString()                     //返回所有元素的描述字符串
    {
        return "2～"+range+"素数表："+this.list.toString()+"，"+this.list.size()+"个元素";
    }
    
    public static void main(String args[])
    {
        System.out.println(new PrimeList(100).toString());
    }
}
/*
程序运行结果如下：
测试3，true
测试5，%2？true
测试7，%2？true
测试9，%2？%3？false
测试11，%2？%3？true
测试13，%2？%3？true
测试15，%2？%3？false
测试17，%2？%3？true
测试19，%2？%3？true
2～20素数集合：CirDoublyList(2,3,5,7,11,13,17,19)，8个元素

测试3，true
测试5，% 2？true
测试7，% 2？true
测试9，% 2？% 3？false
测试11，% 2？% 3？true
测试13，% 2？% 3？true
测试15，% 2？% 3？false
测试17，% 2？% 3？true
测试19，% 2？% 3？true
测试21，% 2？% 3？false
测试23，% 2？% 3？true
测试25，% 2？% 3？% 5？false
测试27，% 2？% 3？false
测试29，% 2？% 3？% 5？true
测试31，% 2？% 3？% 5？true
测试33，% 2？% 3？false
测试35，% 2？% 3？% 5？false
测试37，% 2？% 3？% 5？true
测试39，% 2？% 3？false
测试41，% 2？% 3？% 5？true
测试43，% 2？% 3？% 5？true
测试45，% 2？% 3？false
测试47，% 2？% 3？% 5？true
测试49，% 2？% 3？% 5？% 7？false
测试51，% 2？% 3？false
测试53，% 2？% 3？% 5？% 7？true
测试55，% 2？% 3？% 5？false
测试57，% 2？% 3？false
测试59，% 2？% 3？% 5？% 7？true
测试61，% 2？% 3？% 5？% 7？true
测试63，% 2？% 3？false
测试65，% 2？% 3？% 5？false
测试67，% 2？% 3？% 5？% 7？true
测试69，% 2？% 3？false
测试71，% 2？% 3？% 5？% 7？true
测试73，% 2？% 3？% 5？% 7？true
测试75，% 2？% 3？false
测试77，% 2？% 3？% 5？% 7？false
测试79，% 2？% 3？% 5？% 7？true
测试81，% 2？% 3？false
测试83，% 2？% 3？% 5？% 7？true
测试85，% 2？% 3？% 5？false
测试87，% 2？% 3？false
测试89，% 2？% 3？% 5？% 7？true
测试91，% 2？% 3？% 5？% 7？false
测试93，% 2？% 3？false
测试95，% 2？% 3？% 5？false
测试97，% 2？% 3？% 5？% 7？true
测试99，% 2？% 3？false
2～100素数表：CirDoublyList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97)，25个元素

*/
//@author：Yeheya，2015年10月1日，2019年7月22日