//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年7月27日
//§6.2.3   树/森林的父母孩子兄弟链表实现
//改进第4版，树结点没有层次属性
//【例6.3】 以树/森林的横向凹入表示构造树。
package data.StorageTree;
public class Tree_city
{
    static String[][] prelists={
        {"A","\tB","\t\tE","\t\tF","\tC","\tD","\t\tG","H","\tI","\t\tJ"},      //0,图6.21，森林
        {"A","\tB","\t\tE","\t\tF","\t\t\tK", "\tC","\t\tG","\t\t\tL","\t\t\tM", 
             "\tD","\t\tH","\t\t\tN","\t\tI","\t\tJ"},                          //1,第5版图6.36？？，树
        {"中国","\t北京","\t江苏","\t\t南京","\t\t苏州","\t浙江","\t\t杭州","韩国","\t首尔"}, //2,【例6.3】 图6.26，城市树/森林
        {"中国","\t北京","\t上海","\t江苏","\t\t南京","\t\t\t江宁","\t\t苏州",     //3
          "\t\t无锡","\t\t\t锡山","\t浙江","\t\t杭州","\t\t宁波","\t\t温州","\t广东","\t\t广州",
          "韩国","\t首尔","\t釜山",
          "法国", 
          "意大利", 
          "西班牙",
          "美国","\t华盛顿州","\t\t西雅图","\t纽约州"}};

    public static void main(String[] args)
    {
        Tree<String> tree1 = Trees.create(prelists[0]);    //以树的横向凹入表示法构造树/森林
//        Tree<String> tree2 = new Tree<String>(tree1);      //深拷贝
        tree1.preorder();                                  //输出树的先根次序遍历序列
        tree1.preorder2();                                 //输出树的先根次序遍历序列
        tree1.postorder();                                 //输出树的后根次序遍历序列
        System.out.print(tree1.toString());                //先根次序遍历树并输出树的横向凹入表示字符串
    }
}
/*
程序运行结果如下：
                                                 //第5版图6.21，森林
先根次序遍历树/森林：  A B E F C D G H I J 
先根次序遍历树/森林：  A B E F C D G H I J 
后根次序遍历树/森林：  E F B C G D A J I H 
树/森林的横向凹入表示： 
 A
    B
        E
        F
    C
    D
        G
H
    I
        J
树的广义表表示：A(B(E,F),C,D(G)),H(I(J))
树中所有从叶子结点到根的路径为： (E,B,A)，(F,B,A)，(C,A)，(G,D,A)，(J,I,H)，
层次遍历树/森林：  A B C D E F G H I J 

                                                 //【例6.3】 图6.26
先根次序遍历树：
 中国
    北京
    江苏
        南京
        苏州
    浙江
韩国
    首尔
树的广义表表示：中国(北京,江苏(南京,苏州),浙江),韩国(首尔)
树中所有从叶子结点到根的路径为： (北京,中国)，(南京,江苏,中国)，(苏州,江苏,中国)，(浙江,中国)，(首尔,韩国)，

 *                                                  //第5版图6.34??，树
树的先根次序遍历序列：  A B E F K C G L M D H N I J 
树的后根次序遍历序列：  E K F B L M G C N H I J D A 
树的横向凹入表示： 
 A
    B
        E
        F
            K
    C
        G
            L
            M
    D
        H
            N
        I
        J       

*/
//@author  Yeheya。2015年11月7日，2019年7月27日，2020年1月22日