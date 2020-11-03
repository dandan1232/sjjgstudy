//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年12月29日
//§5.3   广义表
//§5.3.1   广义表定义及抽象数据类型

//ADT GenLList<T>
//广义表接口，广义表抽象数据类型，T表示数据元素的数据类型，其中方法修饰符默认public abstract
package data.Gen;
public interface GenLList<T>
{
    boolean isEmpty();                           //判断是否空表，若空返回true
    int size();                                  //返回广义表长度
    int depth();                                 //返回广义表深度
    GenNode<T> get(int i);                       //返回第i个元素结点，0≤i<表长度
    GenNode<T> insert(int i, T x);               //插入原子x作为第i个元素，返回插入结点
    GenNode<T> insert(int i, GenList<T> genlist);//插入子表genlist作为第i个元素，返回插入结点
    GenNode<T> remove(int i);                    //删除第i个元素结点，返回被删除结点
    void clear();                                //删除所有元素结点结点，头结点和表名仍在
    GenNode<T> search(T key);                    //查找并返回首个与key相等原子结点
    GenNode<T> remove(T key);                    //查找并删除首个与key相等原子结点，返回被删除结点
}
//
/*
 */
//@author：Yeheya。2014年10月6日，2016-1-22，2019年12月29日，2020年2月3日