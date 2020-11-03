package data.singly;


public class SortedSinglyList<T extends Comparable<? super T>> extends SinglyList<T>
{
    protected boolean asc;                       //排序次序，取值为true（升序）或false（降序）

    public SortedSinglyList(boolean asc)         //构造空排序单链表，asc指定升/降序
    {
        super();                                 //构造空单链表，默认调用父类构造方法SinglyList()
        this.asc = asc;
    }
    public SortedSinglyList()                    //构造空排序单链表，默认升序
    {
        this(true);
    }

    //构造方法，按值插入values数组元素，asc指定升/降序。直接插入排序算法
    public SortedSinglyList(T[] values, boolean asc)
    {
        this(asc);                               //构造空排序单链表
        for(int i=0; i<values.length; i++)       //直接插入排序，每趟插入1个元素
            this.insert(values[i]);              //排序单链表按值插入，覆盖，O(n)
    }
    public SortedSinglyList(T[] values)          //构造方法，按值插入values数组元素，默认升序
    {
        this(values, true);
    }
    //1.  排序单链表类声明


    //3.  排序单链表类覆盖父类成员方法
    //3.（1）  不需要从父类继承来的方法，覆盖并抛出异常
    //不支持父类的以下成员方法，将其覆盖并抛出异常。
    public void set(int i, T x)
    {
        throw new java.lang.UnsupportedOperationException("set(int i, T x)");
    }
    public Node<T> insert(int i, T x)
    {
        throw new java.lang.UnsupportedOperationException("insert(int i, T x)");
    }

    //3.（2） 排序单链表的插入操作，覆盖父类方法
    //插入x，x!=null，根据x对象大小顺序查找确定插入位置，插入在等值结点之后；返回插入结点。O(n)
    //由T类的compareTo()方法比较对象大小。覆盖父类insert(x)方法，参数列表和返回值相同。
    ////插入在等值结点之后。优先队列用
    public Node<T> insert(T x)
    {
        if(x==null)
            return null;
        //以下循环寻找插入位置，插入在等值结点之后
        Node<T> front=this.head,  p=front.next;            //front指向p的前驱结点
        while(p!=null && (this.asc ? x.compareTo(p.data)>=0 : x.compareTo(p.data)<=0))
        {
            front = p;
            p = p.next;
        }
        front.next = new Node<T>(x, p);                    //在front之后、p之前插入值为x结点
        return front.next;                                 //返回插入的x结点
    }
}