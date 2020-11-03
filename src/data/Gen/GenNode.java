//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年12月29日
//§5.3   广义表
//§5.3.2   广义表的存储结构和实现
//2. 广义表结点类
package data.Gen;

public class GenNode<T>                          //广义表结点类，T指定结点的元素类型
{
    public T data;                               //数据域
    public GenList<T> child;                     //地址域，指向子表
    public GenNode<T> next;                      //地址域，指向后继结点

    //构造结点，data指定元素，child指向子表，next指向后继结点
    public GenNode(T data, GenList<T> child, GenNode<T> next) 
    {
        this.data = data;
        this.child = child;
        this.next = next;
    }
    
    public GenNode()
    {
        this(null, null, null);
    }
    
    //没有直接调用。为了调试时用的。
    public String toString()                     //返回结点数据域的描述字符串
    {
        return this.data.toString();
    }
}
/*  //以下第5版没写
    public GenNode(T data)
    {
        this(data, null, null);
    }
*/
//@author：Yeheya。2014年10月6日，2019年12月29日，2020年1月31日