package data.Gen;
import data.Gen.GenLList;
//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年12月29日
//§5.3   广义表
//§5.3.2   广义表的存储结构和实现
//3. 广义表类

//广义表类，带表名，使用头结点的data域存储表名；可插入共享子表，不能构造共享子表；不是递归表
public class GenList<T> implements GenLList<T>
{
    public GenNode<T> head;                      //头指针，指向头结点

    public GenList()                             //构造空广义表，表名为null
    {
        this.head = new GenNode<T>(null, null, null);      //创建头结点
        ////this(null);   //语法错，不能声明，不能与之后深拷贝相区别
    }
    public GenList(T data)                       //构造空广义表，data指定表名
    {
        this.head = new GenNode<T>(data, null, null);      //头结点的data域存储表名
    }
    
    //构造广义表，data指定表名，atoms[]指定原子初值，构造的是线性表，算法同单链表。
    ////结点次序与数组元素次序相同，采用尾插入构造
    public GenList(T data, T[] atoms)
    {
        this(data);                              //创建空广义表，只有头结点
        GenNode<T> rear=this.head;
        for(int i=0; i<atoms.length; i++)
        {
            rear.next=new GenNode<T>(atoms[i], null, null);  //尾插入
            rear = rear.next; 
        }
    }

    public boolean isEmpty()                     //判断是否空表，若空返回true
    {
        return this.head.child==null && this.head.next==null;
    }
    
    public T getName()                           //返回表名
    {
    	return this.head.data;
    }
    
    //返回第i个元素结点，0≤i<表长度。若i越界，返回null。O(n)。////算法同单链表
    public GenNode<T> get(int i)
    {
        GenNode<T> p=this.head.next;
        for(int j=0;  p!=null && j<i;  j++)      //遍历，寻找第i个结点（p指向）
            p = p.next;
        return (i>=0 && p!=null) ? p : null;     //返回第i个结点
    }

    public String toString()                     //返回this广义表的描述字符串
    {
        return this.toString(this);
    }
    public String toString(GenList<T> genlist)   //返回genlist广义表的描述字符串，遍历算法，间接递归方法
    {
        String str=(genlist.head.data==null?"":genlist.head.data.toString())+"("; //无/有名表
        for(GenNode<T> p=genlist.head.next;  p!=null;  p=p.next)//遍历genlist广义表，不能是递归表
            str += toString(p)+(p.next!=null?",":""); //调用访问p结点
        return str+")";                          //空表返回()
    }
    public String toString(GenNode<T> p)         //返回p结点的广义表字符串，间接递归方法
    {
        if(p==null) 
            return null;
        return  p.child==null ? p.data.toString() : toString(p.child);//若有子表，递归调用p.child子表
    }

	public int size()                            //返回广义表长度，////算法同单链表
    {
        int i=0; 
        for(GenNode<T> p=this.head.next;  p!=null;  p=p.next)
            i++;
        return i;
    }
    
    public int depth()                           //返回广义表深度，递归方法
    {
        int max=1;
        for(GenNode<T> p=this.head.next;  p!=null;  p=p.next)
            if(p.child!=null)
            {
                int d=p.child.depth();           //递归调用，返回子表深度
                if(max<=d)                       //记住最大子表深度
                    max=d+1;                     //当前广义表深度为子表深度加1
            }
        return max;
    }
    
    //插入原子x作为第i个元素，x!=null，返回插入的原子结点。
    //对i容错，若i<0，头插入；若i>长度，尾插入。算法同单链表，O(n)
    public GenNode<T> insert(int i, T x)
    {
        if(x==null)
            return null;               ////没有插入结点。返回一种执行结果，不是错误，不抛出异常
        GenNode<T> front=this.head;                        //front指向头结点
        for(int j=0;  front.next!=null && j<i;  j++)       //寻找第i-1个或最后一个结点（front指向）
            front = front.next; 
        front.next = new GenNode<T>(x, null, front.next);  //在front之后插入值为x结点
        return front.next;                                 //返回插入的原子结点
    }
    public GenNode<T> insert(T x)                          //尾插入原子x结点，////算法同单链表
    {
        return insert(Integer.MAX_VALUE, x);
    }

    //插入子表glist作为第i个元素，genlist!=null，返回插入的子表结点。
    //在插入的子表结点中，datad存储genlist子表表名，child引用genlist子表对象，
    //若genlist是this中的子表，则genlist成为共享子表。genlist!=this，不使this成为递归表。
    ////算法同单链表，插入的是子表结点
    public GenNode<T> insert(int i, GenList<T> genlist)
    {
        if(genlist==null || this==genlist)                 //不插入结点
            return null;
        GenNode<T> front=this.head;                        //front指向头结点
        for(int j=0;  front.next!=null && j<i;  j++)       //寻找第i-1个或最后一个结点（front指向）
            front = front.next; 
        //下句在front之后插入子表结点，有表名，child指向（引用）genlist子表，可共享
        front.next = new GenNode<T>(genlist.head.data, genlist, front.next);
        return front.next;                                 //返回插入的子表结点
    }
    public GenNode<T> insert(GenList<T> genlist)           //尾插入genlist子表
    {
        return insert(Integer.MAX_VALUE, genlist);
    }
    
    //删除并返回第i个元素结点，0≤i<长度；若i无效，不删除，返回null。算法同单链表O(n)
    public GenNode<T> remove(int i)
    {
    	GenNode<T> front = this.head, p=null;    //front指向头结点
        for(int j=0;  front.next!=null && j<i;  j++)//遍历寻找第i-1结点（front指向）
            front = front.next;
        if(i>=0 && front.next!=null)             //若front的后继结点存在，则删除之
        {
            p = front.next;
            front.next = front.next.next;        //删除front的后继结点，包括头删除、中间/尾删除
        }
        return p;
    }
    ////不能返回被删除元素T，做不到，可能是子表
    
    public void clear()                          //删除所有元素，没有删除头结点和表名
    {
        this.head.child=null;
        this.head.next=null;
    }
    
    //以下ADT写，查找原子元素算法，递归遍历算法
    public GenNode<T> search(T key)              //查找并返回首个与key相等元素结点
    {
        return null;
    }
    public GenNode<T> remove(T key)              //查找、删除并返回首个与key相等元素结点
    {
        return null;
    }
    //以下ADT没写，
    void removeAll(T key){}               	 //??查找并删除所有与key相等原子结点

    //以下【实验题5-3，课程设计题】
    //算法正确，将共享子表复制成多条
    public GenList(GenList<T> genlist)           //拷贝构造方法，深拷贝，复制广义表
    {
        this(genlist.head.data);    	         //构造空表，头结点的data域存储表名
        GenNode<T> rear = this.head;
        for(GenNode<T> p=genlist.head.next;  p!=null; p=p.next)//遍历genlist广义表
        {
            rear.next = new GenNode<T>(p.data, null, null); //创建原子/子表结点，子表结点p.data==null
            rear = rear.next; 
            if(p.child!=null)
            	rear.child = new GenList<T>(p.child);      //创建子表，递归调用，不共享
        }
    }
    
    public boolean equals(Object obj)  //比较两条广义表是否相等，覆盖Object类的equals(obj)方法
    {
        if(obj == this)
            return true;
        if(obj instanceof GenList<?>)
            return equals(this, (GenList<T>)obj);
        return false;
    }    
    public boolean equals(GenList<T> genlist1, GenList<T> genlist2)
    {
    	if(genlist1==null && genlist2==null)
            return true;
        if(genlist1!=null && genlist2!=null)
        {
            GenNode<T> p = genlist1.head.next;
            GenNode<T> q = genlist2.head.next;
            while(p!=null && q!=null && p.data.equals(q.data) && equals(p.child, q.child))//递归调用，
            {
                p=p.next;
                q=q.next;
            }
            return p==null && q==null;
    	}
        return false;
    }
    
    //以下查找子表算法，递归遍历算法
    //查找首个与pattern相等的子表，返回子表结点
    public GenNode<T> search(GenList<T> pattern)
    {
        return null;
    }
    //查找并删除首个与pattern相等的子表，返回被删除的子表结点
    public GenNode<T> remove(GenList<T> pattern)
    {
        return null;
    }
    
    public void removeAll(GenList<T> pattern)    //查找并删除所有与pattern相等的子表
    {}

    //查找所有与pattern相等的子表，将它们替换（引用）为genlist子表
    public void replaceAll(GenList<T> pattern, GenList<T> genlist)
    {}
}
/*
//程序设计说明如下。
（1）以下没法声明：
    void set(int i, T x);                        //设置第i个结点元素为x，0≤i<表长度
      因为第i个结点元素可能是原子或子表，可以改原子值，前提是要区别原子弹和子表；
不能改子表的表名，因为子表的一个表名写在多处，必须一致。

*/
//@author：Yeheya。2014年10月6日，2016-1-22，2019年12月29日，2020年2月5日