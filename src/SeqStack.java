import data.singly.SeqList;

/**
 * @author Flobby
 * @version :1.0
 * @date :2020/10/27
 * @ClassName :
 */

public final class SeqStack<T> implements Stack<T>
{
    private SeqList<T> list;                     //使用顺序表（2.2.2节）存储栈元素

    public SeqStack(int length)                  //构造容量为length的空栈
    {
        this.list = new SeqList<T>(length);      //执行顺序表构造方法
    }
    public SeqStack()                            //构造默认容量的空栈
    {
        this(64);
    }

    @Override
    public boolean isEmpty()                     //判断栈是否空，若为空，则返回true
    {
        return this.list.isEmpty();
    }

    @Override
    public void push(T x)                        //元素x入栈，空对象不能入栈
    {
        this.list.insert(x);                     //顺序表尾插入元素x，自动扩充容量
    }

    @Override
    public T peek()                              //返回栈顶元素（未出栈），若栈为空，则返回null
    {
        return this.list.get(list.size()-1);     //若栈为空，则get(i)返回null
//        return this.isEmpty() ? null : this.list.get(list.size()-1);
    }

    @Override
    public T pop()                               //出栈，返回栈顶元素；若栈为空，则返回null
    {
        return this.list.remove(list.size()-1);  //若栈不空，顺序表尾删除，返回删除元素
    }

    //以下教材没写
    @Override
    public String toString()                     //返回栈所有元素的描述字符串，形式为“(,)”
    {
        return //this.getClass().getName()+
                this.list.toString();//输出顺序表
    }
    public String toPreviousString()             //反序输出顺序栈
    {
        return //this.getClass().getName()+" "+
                this.list.toPreviousString();//反序输出顺序表
    }

    //以下求所有直径程序用到
    public SeqStack(SeqStack<T> stack)           //栈深拷贝构造方法
    {
        this.list = new SeqList<T>(stack.list);  //执行顺序表的深拷贝构造方法
    }
    public void copy(SeqStack<T> stack)          //栈深拷贝
    {
        this.list = new SeqList<T>(stack.list);  //执行顺序表的深拷贝构造方法
    }
    @Override
    public void clear()                          //清空栈
    {
        this.list.clear();
    }
    public int size()                            //返回元素个数。O(1)
    {
        return this.list.size();
    }
}
