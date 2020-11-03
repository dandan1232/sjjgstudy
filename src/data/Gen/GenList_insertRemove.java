//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年12月29日
//§5.3   广义表
//§5.3.2   广义表的存储结构和实现
//【例5.3】广义表的双链表示及构造算法。
//（1） 构造广义表及对广义表的操作
package data.Gen;
public class GenList_insertRemove
{    
    public static void main(String args[])
    {
    	//（1）构造广义表，正确
/*      //空表，无名表"()"
    	GenList<String> empty = new GenList<String>();
        System.out.println("empty="+empty.toString()+"，size="+empty.size()+"，depth="+empty.depth()); 

        empty.insert(new GenList<String>());      //空表中插入空表
        System.out.println(empty.toString()+"，size="+empty.size()+"，depth="+empty.depth()); 

    	//空表，有名表"E()"
    	empty = new GenList<String>("E");
        System.out.println(empty.toString()+"，size="+empty.size()+"，depth="+empty.depth()); 
*/
        //有名表"L(a,b)"，由表名"L"和原子数组构造广义表
    	String[] atoms={"a","b"};
        GenList<String> list = new GenList<String>("L",atoms);  
//        System.out.println(list.toString()+"，size="+list.size()+"，depth="+list.depth()); 
        
        //（2）插入原子和子表
        //有名表"T(c,L(a,b))"，先构造空表"T()"，再插入原子c和子表"L(a,b)"
        GenList<String> tree = new GenList<String>("T");
        tree.insert("c");                        //空表插入原子
        tree.insert(list);                       //尾插入子表
//        System.out.println(tree.toString()+"，size="+tree.size()+"，depth="+tree.depth()); 
        
        //图5.17 有名表"G(d,L(a,b),T(c,L(a,b))))"，共享子表，插入子表list、tree
        GenList<String> graph = new GenList<String>("G");
        graph.insert(tree);                      //空表插入子表tree
        graph.insert(0,list);                    //头插入子表list，list成为共享子表
        graph.insert(0,"d");                     //头插入原子
        System.out.println("graph="+graph.toString()+"，size="+graph.size()+"，depth="+graph.depth());
        
//        //在共享子表list中插入，插入子表
//        System.out.println("\nlist插入efg，graph头插入L、中间插入T"); 
//        list.insert(0,"e");                      //头插入原子
//        list.insert("g");                        //尾插入原子
//        list.insert(3,"f");                      //中间插入原子
//        graph.insert(0,list);                    //头插入子表
//        graph.insert(3,tree);                    //中间插入子表
//        System.out.println(list.toString()); 
//        System.out.println(tree.toString());
//        System.out.println(graph.toString());
//
//        //（3）删除原子和子表
//        System.out.println("\nlist删除efg，graph删除L、T"); 
//        list.remove(0);                          //头删除原子，正确
//        list.remove(2);                          //中间删除原子
//        list.remove(2);                          //尾删除原子
//        graph.remove(0);                         //头删除子表
//        graph.remove(3);                         //中间删除子表
//        System.out.println(list.toString()); 
//        System.out.println(tree.toString());
//        System.out.println(graph.toString());
        
        //【实验题5，课程设计题】广义表深拷贝，共享子表复制成多条
        //以下执行插入、删除操作，说明是否共享子表
        list = graph.get(1).child;                          //返回子表L(a,b)
        GenNode<String> p = list.remove(0);                 //共享子表list头删除原子 
        System.out.println(list.getName()+"头删除"+(p!=null ? list.toString(p) : "")+"，\tgraph ="+graph.toString());

        GenList<String> graph2 = new GenList<String>(graph);//深拷贝，共享子表复制成多条
        System.out.println("深拷贝，\t\tgraph2="+graph2.toString());
        System.out.println("graph.equals(graph2)="+graph.equals(graph2));
        
        list = graph2.get(1).child;                          //返回子表L(a,b)
        p = list.remove(0);                 //共享子表list头删除原子 
        System.out.println(list.getName()+"头删除"+(p!=null ? list.toString(p) : "")+"，\tgraph2="+graph2.toString());
        System.out.println("graph.equals(graph2)="+graph.equals(graph2));
    }
}
/*
程序运行结果如下：
empty=()，size=0，depth=1
(())，size=1，depth=2

L(a,b)，size=2，depth=1
T(c,L(a,b))，size=2，depth=2
G(d,L(a,b),T(c,L(a,b)))，size=3，depth=3

list插入efg，graph头插入L、中间插入T
L(e,a,b,f,g)
T(c,L(e,a,b,f,g))
G(L(e,a,b,f,g),d,L(e,a,b,f,g),T(c,L(e,a,b,f,g)),T(c,L(e,a,b,f,g)))

list删除efg，graph删除L、T
L(a,b)
T(c,L(a,b))
G(d,L(a,b),T(c,L(a,b)))                      //头删除，正确


 //【实验题5，课程设计题】广义表深拷贝，共享子表复制成多条
graph=G(d,L(a,b),T(c,L(a,b)))，size=3，depth=3
L头删除a，	graph =G(d,L(b),T(c,L(b)))               //共享子表
深拷贝，		graph2=G(d,L(b),T(c,L(b)))               //共享子表复制成多条
graph.equals(graph2)=true                            //结构不同了
L头删除b，	graph2=G(d,L(),T(c,L(b)))
graph.equals(graph2)=false


*/
//author：Yeheya。2014-10-6，2020年2月5日