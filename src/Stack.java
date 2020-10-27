//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年7月23日
//§4.1.1   栈抽象数据类型

//栈接口，描述栈抽象数据类型；T是泛型参数，表示数据元素的数据类型
public interface Stack<T> {
    public abstract boolean isEmpty();           //判断栈是否空

    public abstract void push(T x);              //元素x入栈

    public abstract T peek();                    //返回栈顶元素，未出栈

    public abstract T pop();                     //出栈，返回栈顶元素

    //以下求所有直径程序用到
    public abstract void clear();                //清空栈
}
//@author：Yeheya，2014年10月23日，2019年7月23日，020年7月23日