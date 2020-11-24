//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年8月9日
//§6.3   二叉树应用
//§6.3.1  Huffman树
package data.Huffman;
public class TriElement                          //二叉树的静态三叉链表结点类
{
    int data;                                    //数据域
    int parent,left,right;                       //父母结点和左、右孩子结点下标
	
    //构造结点，各参数依次指定元素、父母结点下标、左/右孩子结点下标
	public TriElement(int data, int parent, int left, int right)
	{					
	    this.data = data;
	    this.parent = parent;
	    this.left = left;
	    this.right = right;
	}
	public TriElement(int data)                  //构造元素值为data、无父母的叶子结点
	{					
	    this(data, -1, -1, -1);
	}
    public String toString()                     //返回结点的描述字符串，形式为“(,)”
    {
        return "("+this.data+","+this.parent+","+this.left+","+this.right+")";
    }
    public boolean isLeaf()                      //判断是否叶子结点
    {
        return this.left==-1 && this.right==-1;
    }
}
/*
 * 说明：
 * （1）成员变量声明为private，不行。 
 * （2）以下没有用到
	public TriElement()
	{					
	    this(0, -1, -1, -1);
	}
    public boolean equals(Object obj)                      //比较是否相等 ，覆盖Object类的equals(obj)方法
    {                                                      //仅比较元素值
        return obj==this || obj instanceof TriElement && this.data==((TriElement)obj).data;
    }
}
*/
//@author  Yeheya。2014-7-21，2016年2月1日，2019年9月13日，中秋