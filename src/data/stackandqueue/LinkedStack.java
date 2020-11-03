package data.stackandqueue;

import data.singly.SinglyList;

/**
 * @author Flobby
 * @version :1.0
 * @date :2020/10/27
 * @ClassName :
 */

public final class LinkedStack<T> implements Stack<T>
{
    private SinglyList<T> list;                  //使用单链表（2.3.2节）存储栈元素

    public LinkedStack()                         //构造空栈
    {
        this.list = new SinglyList<T>();         //构造空单链表
    }

    @Override
    public boolean isEmpty()                     //判断栈是否空，若为空，则返回true
    {
        return this.list.isEmpty();
    }
    @Override
    public void push(T x)                        //元素x入栈，空对象不能入栈
    {
        this.list.insert(0, x);                  //单链表头插入元素x
    }

    @Override
    public T peek()                              //返回栈顶元素（未出栈）；若栈为空，则返回null
    {
        return this.list.get(0);
    }
    @Override
    public T pop()                               //出栈，返回栈顶元素；若栈为空，则返回null
    {
        return this.list.remove(0);              //若栈不空，则单链表头删除，返回删除元素
    }

    @Override
    public String toString()                     //返回栈所有元素的描述字符串，形式为“(,)”
    {
//        return this.list.toString();
        return this.getClass().getName()+" "+this.list.toString();
    }

    //以下求所有直径程序用到
    public LinkedStack(LinkedStack<T> stack)     //深拷贝
    {
        this.list = new SinglyList<T>(stack.list);//执行单链表的深拷贝构造方法
    }
    public void copy(LinkedStack<T> stack)       //栈深拷贝
    {
        this.list = new SinglyList<T>(stack.list);//执行单链表的深拷贝构造方法
    }
    @Override
    public void clear()                          //清空栈
    {
        this.list.clear();
    }
}
