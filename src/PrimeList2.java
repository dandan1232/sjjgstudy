/*
//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年7月22日
//§2.3.2  单链表
//【例2.2】 素数线性表，使用单链表存储。
//§2.3.4  循环双链表
//使用顺序表、循环双链表存储素数环。
//4.2 队列【例4.3】 求解素数环问题。用

//素数线性表（升序），使用顺序表或循环双链表存储，要求尾插入的时间复杂度是O(1)。
public class PrimeList2 
{
    private int range;                           //素数范围上限
//    private SeqList<Integer> list;             //顺序表，存储素数线性表，循环双链表也可
    private CirDoublyList<Integer> list;         //循环双链表
    
    public PrimeList2(int range)                 //构造方法，存储2～range中所有素数
    {
        if(range<=1)
            throw new java.lang.IllegalArgumentException("range="+range);//无效参数异常
        this.range = range;
//        this.list = new SeqList<Integer>();    //构造空顺序表
        this.list = new CirDoublyList<Integer>();//构造空循环双链表
        this.list.insert(2);                     //添加已知的最小素数
        for(int key=3; key<=range; key+=2)       //测试奇数，不需测试其他偶数
            if(this.isPrime(key))                //若key是素数，则尾插入，O(1)
            	this.list.insert(key);           //尾插入最大值，O(1)
    }
    
    public boolean isPrime(int key)              //判断key是否是素数，遍历this.list单链表
    {
        if(key<=1)
            throw new java.lang.IllegalArgumentException("key="+key);//无效参数异常
//        System.out.print("测试"+key+"，");
        int sqrt = (int)Math.sqrt(key);          //Math.sqrt(key)返回key的平方根值，再将double强制转换成int，小数部分截尾
        //用list中的已知素数测试key，遍历部分list，测试范围到sqrt(key)
        for(int i=0;  i<list.size() && list.get(i)<=sqrt;  i++)
//        for(DoubleNode<Integer> p=list.head.next;  p!=list.head && p.data<=sqrt;  p=p.next)
        {
//            System.out.print("%"+p.data+"？");
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

    public String toString()                     //返回所有元素的描述字符串
    {
        return "2～"+range+"素数集合："+list.toString()+"，"+list.size()+"个元素";
    }
    
    public static void main(String args[])
    {
        System.out.println(new PrimeList2(100).toString());
    }
}
*/
/*
程序运行结果如下：
2～100素数集合：SeqList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97) ，25个元素

2～100素数集合：CirDoublyList(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97)，25个元素

*//*

//@author：Yeheya，2015年10月1日，2019年7月22日*/
