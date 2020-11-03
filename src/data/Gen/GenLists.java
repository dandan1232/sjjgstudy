//《数据结构（Java版）（第4版）》，作者：叶核亚，2014年10月6日
//§5.3   广义表
//§5.3.3   广义表双链表示的实现
//【例5.3】 广义表的基本操作。
//（2） 由广义表表示构造广义表
//第5版教材写，//构造的是树，不能创建共享子表。
////创建共享子表算法可行，可做课程设计，程序没完成。
package data.Gen;

public class GenLists                            //广义表操作类
{
    private static int i=0;                      //静态成员变量
    
    //返回以gliststr表示创建的广义表，gliststr语法正确，不是null、空串""
    public static GenList<String> create(String gliststr)
    {
        i=0;
        return createsub(gliststr, null);        //构造树，没有共享子表
    }

    //返回从gliststr[i]开始的子串创建的子广义表，data指定表名；原子和表名都是字符串，递归方法。
    //不能创建共享子表。
    //由于i从0开始线性递增，所有递归方法共用一个i，所以只能声明i是成员变量，不能是局部变量
    private static GenList<String> createsub(String gliststr, String data)
    {
        if(data==null)
        {
            i = gliststr.indexOf('(');                     //返回指定字符在串中位置
            data = gliststr.substring(0,i);                //'('前的字符串是表名
        }
        GenList<String> genlist = new GenList<String>(data);//构造空表，data指定表名
        GenNode<String> p = genlist.head;                  //指向头结点
        i++;                                               //跳过'('
        while(i<gliststr.length())
        {
            switch(gliststr.charAt(i))
            {
                case ',':  i++;  break;
                case ')':  i++;  return genlist;
                default :                                  //字符
                {
                    //以下循环从第i个字符开始寻找原子/表名子串，以"(,)"之一作为分割符
                    int end=i;
                    while(end<gliststr.length()  &&  "(,)".indexOf(gliststr.charAt(end))==-1)
                        end++;
                    data = gliststr.substring(i, end);     //i～end-1的子串是原子/表名
                    i=end;                                 //改变i到下个分割符位置

                    //下句创建原子/子表结点；子表结点有表名，无表名时为空串
                    p.next = new GenNode<String>(data, null, null);
                    p = p.next;
                    if(i<gliststr.length() && gliststr.charAt(i)=='(')
                        p.child = createsub(gliststr, data);//创建子表，递归调用
                }
            }
        }
        return genlist;
    }
    //注意：只能声明i是全局变量。
    //如果声明i是局部变量，递归参数传递子串，问题在于，遇到')'返回，无法带回改变了的i值。
    
    public static void main(String args[])
    {
        String[] gliststrs={
            "()",                                //不带表名的广义表表示
        	"(())",
        	"(a,b)",
            "(c,(a,b))",
            "(d,(a,b),(c,(a,b)))",
            "(and,(begin,end),(my,your,(his,her)))",//广义表元素值是字符串
            "E()",                               //带表名的广义表表示
            "L(a,b)",
            "T(c,L(a,b))",
            "G(d,L(a,b),T(c,L(a,b)))",
            "中国(北京, 上海, 江苏(南京, 苏州), 浙江(杭州))", //树，不能构造森林
            "大学(数学, 物理, 化学, 天文, 地理, 历史, 生物(动物, 植物, 生物化学), 地质, 经济,"+ 
    		     "计算机(计算机科学与技术, 软件工程, 网络工程))"};
    	
        for(int i=0; i<gliststrs.length; i++)
        {
            GenList<String> genlist = GenLists.create(gliststrs[i]);   //构造广义表
            System.out.println(genlist.toString());
        }  

        //【例5.3】 广义表的基本操作，包括构造、遍历、插入、删除。
        String gliststr="G(d,L(a,b),T(c,L(a,b)))";         //带表名的广义表表示
        GenList<String> graph = GenLists.create(gliststr); //构造广义表，没有共享子表
        System.out.println("构造，\t\t"+graph.toString()+"，size="+graph.size()+"，depth="+graph.depth());

        //以下执行插入、删除操作，说明是否共享子表
        GenList<String> list = graph.get(1).child;         //返回子表L(a,b)
        graph.insert(0,list);                              //G头插入子表list，list成为共享子表
        System.out.println(graph.getName()+"头插入"+list.toString()+"，\t"+graph.toString());
        
        GenNode<String> p = list.remove(0);                 //共享子表list头删除原子 
        System.out.println(list.getName()+"头删除"+(p!=null ? list.toString(p) : "")+"，\t"+graph.toString());
        
        p = list.insert(0,"e");                             //头插入原子
        System.out.println(list.getName()+"头插入"+(p!=null ? list.toString(p) : "")+"，\t"+graph.toString());
        
        GenList<String> tree = graph.get(3).child;         //返回子表T
        while(!graph.isEmpty())
        {
            p = graph.remove(0);                            //头删除元素（原子/子表）结点，没有删除子表
            System.out.println(graph.getName()+"头删除"+(p!=null ? graph.toString(p) : "")+"，\t"+graph.toString());
        }
        //删除了元素（原子/子表）结点，没有删除子表
        System.out.println(list.toString());
        System.out.println(tree.toString());
    }
}
/*
程序运行结果如下：
()
(())
(a,b)
(c,(a,b))
(d,(a,b),(c,(a,b)))
(and,(begin,end),(my,your,(his,her)))
E()
L(a,b)
T(c,L(a,b))
G(d,L(a,b),T(c,L(a,b)))
中国(北京, 上海, 江苏(南京, 苏州), 浙江(杭州))
大学(数学, 物理, 化学, 天文, 地理, 历史, 生物(动物, 植物, 生物化学), 地质, 经济,计算机(计算机科学与技术, 软件工程, 网络工程))

//【例5.3】广义表的基本操作。
构造，		G(d,L(a,b),T(c,L(a,b)))，size=3，depth=3
G头插入L(a,b)，	G(L(a,b),d,L(a,b),T(c,L(a,b)))
L头删除a，	G(L(b),d,L(b),T(c,L(a,b)))
L头插入e，	G(L(e,b),d,L(e,b),T(c,L(a,b)))
G头删除L(e,b)，	G(d,L(e,b),T(c,L(a,b)))
G头删除d，	G(L(e,b),T(c,L(a,b)))
G头删除L(e,b)，	G(T(c,L(a,b)))
G头删除T(c,L(a,b))，	G()
L(e,b)
T(c,L(a,b))

*/    
/*
//以下希望构造共享子表，算法可行，未完成
private static int i=0;
public static GenList<String> create(String gliststr)  //返回以gliststr表示创建的广义表
{
    i=0;
    //共享子表，约定表名相同者为同一个表
    SeqList<GenList<String>> seqlist = new SeqList<GenList<String>>();  //创建顺序表，存储已创建的子表
    return createsub2(gliststr, null, seqlist);
}

    //共享子表
    private static GenList<String> createsub2(String gliststr, String data, SeqList<GenList<String>> seqlist)
    {
    	if(data==null)
    	{
    		i = gliststr.indexOf('(');
    		data = gliststr.substring(0,i);    	 //获得表名字符串
    	}
    	GenList<String> genlist = new GenList<String>(data);//构造空表，头结点的data域存储表名
        seqlist.insert(genlist);                 //顺序表尾插入
        GenNode<String> p = genlist.head;        //指向头结点
        i++;                                     //跳过'('
        while(i<gliststr.length())
            switch(gliststr.charAt(i))
            {
                case ',':  i++; break;
                case ')':  i++; return genlist;
                default :                        //用字符串表示原子
                {
                    int end=i;//element()返回元素，以"(,)"之一分割，i
                    while(end<gliststr.length() && "(,)".indexOf(gliststr.charAt(end))==-1)
                        end++;
                    data = gliststr.substring(i, end);  //获得从i～end-1的子串，深拷贝
                    i=end;                                    //改变i到子串的下个字符
                	
                	p.next=new GenNode<String>(data, null, null); //创建原子/子表结点，子表结点有表名，无表名时为空串
                    p = p.next;
                    if(i<gliststr.length() && gliststr.charAt(i)=='(')
                    {
                    	for(int j=0; p.child==null && j<seqlist.size(); j++)//顺序表查找算法，寻找共享子表
                    		if(data.equals(seqlist.get(j).head.data))
                    			p.child = seqlist.get(j);
                    	if(p.child==null) 
                    	{
                    	    p.child = createsub2(gliststr, data, seqlist);    //创建子表，递归调用
                    	}
                    }
                }
        }
        return genlist;
    }
    //未完成，运行结果如下：
    G(d,L(a,b),T(c,L(a,b),(a,b)))
    L(a,b)，头删除a；
    G(d,L(b),T(c,L(b),(a,b)))
*/    
//@author：Yeheya。2014年10月6日，2020年2月3日