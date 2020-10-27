//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年7月23日
//§2.3.2  单链表
//7.  单链表的集合并运算
//图2.20  单链表的集合并运算

public class SinglyList_concat 
{
	public static void main(String args[])
    {
		//(1) 合并连接与添加子表（深拷贝）
		String[] valuea={"a","b","c"}, valueb={"x","y"};
	    SinglyList<String> lista = new SinglyList<String>(valuea);
	    SinglyList<String> listb = new SinglyList<String>(valueb);
        System.out.println("\t\t\tlista="+lista.toString()+"，\t\tlistb="+listb.toString());
/*
        lista.concat(listb);                      //在lista之后链接listb
        System.out.println("lista.concat(listb)，\tlista="+lista.toString()+"，\tlistb="+listb.toString());
        listb.insert("z");
        System.out.println("listb.insert(\"z\")，\tlista="+lista.toString()+"，\tlistb="+listb.toString());
        
        lista.addAll(listb);
        System.out.println("lista.addAll(listb)，\tlista="+lista.toString()+"，\tlistb="+listb.toString());
*/
        //(3) 添加子表返回（深拷贝）
        System.out.println("lista.union(listb)="+lista.union(listb).toString());
        System.out.println("\t\t\tlista="+lista.toString()+"，\t\tlistb="+listb.toString());
	}
}
/*
程序运行结果如下：    
        //（1）concat(list)没有设置list为空
                      lista=(a,b,c)，                                listb=(x,y)
lista.concat(listb)，    lista=(a,b,c,x,y)，                      listb=(x,y)
listb.insert("z")，         lista=(a,b,c,x,y,z)，                 listb=(x,y,z)            //作用于两条单链表，lista逻辑错
lista.addAll(listb)，    lista=(a,b,c,x,y,z,x,y,z)，  listb=(x,y,z,x,y,z)      //listb逻辑错


        //（2）concat(list)设置list为空，两条单链表无关
                      lista=(a,b,c)，                   listb=(x,y)
lista.concat(listb)，    lista=(a,b,c,x,y)，         listb=()
listb.insert("z")，         lista=(a,b,c,x,y)，         listb=(z)                      //仅作用于listb
lista.addAll(listb)，    lista=(a,b,c,x,y,z)，    listb=(z)

        //(3) 添加子表返回（深拷贝）
            lista=SinglyList(a,b,c)，        listb=SinglyList(x,y)
lista.union(listb)=SinglyList(a,b,c,x,y)
            lista=SinglyList(a,b,c)，        listb=SinglyList(x,y)

*/
//@author：Yeheya。2015-9-19，2019年7月23日