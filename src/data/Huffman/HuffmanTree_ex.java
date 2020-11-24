//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年8月9日
//§6.3   二叉树应用
//§6.3.1  Huffman树
//【例6.4】  采用Huffman算法对字符串进行数据压缩和解压缩。

public class HuffmanTree_ex 
{
    public static void main(String[] args)
    {        
        String text="AAAABBBCDDBBAAA";           //【典型案例6.3】 数据
        //…………  统计字符串text的字符集合charset和权值集合weights，见8.5.2节例8.3；

        String charset="ABCD";                   //字符集合
        int[] weight6_29={7,5,1,2};              //图6.33指定权值集合，默认字符集为"ABCD"
//        HuffmanTree huftree = new HuffmanTree(weight6_28); //构造Huffman树

//        String charset="DCBA";                 //字符集合
//        int[] weight6_29={2,1,5,7};            //图6.33指定权值集合，默认字符集为"ABCD"
        HuffmanTree huftree = new HuffmanTree(charset, weight6_29); //构造Huffman树

        System.out.println(huftree.toString());  //输出Huffman树的结点数组和所有字符编码
        String compressed = huftree.encode(text);
        System.out.println("将"+text+"压缩为"+compressed+"，"+compressed.length()+"位");
        System.out.println("将"+compressed+"解码为"+huftree.decode(compressed));

        int[] weight6_34={5,29,7,8,14,23,3,11};  //图6.34指定权值集合，默认字符集为"ABCDEFGH"
        huftree = new HuffmanTree(weight6_34);   //构造Huffman树
        System.out.println(huftree.toString());  //输出Huffman树的结点数组和所有字符编码
    }   
}
/*
程序运行结果如下：
Huffman树的结点数组:(7,6,-1,-1)，(5,5,-1,-1)，(1,4,-1,-1)，(2,4,-1,-1)，(3,5,2,3)，(8,6,4,1)，(15,-1,0,5)，
Huffman编码： A：0，B：11，C：100，D：101，
将AAAABBBCDDBBAAA压缩为00001111111001011011111000，26位
将00001111111001011011111000解码为AAAABBBCDDBBAAA

Huffman树的结点数组:(5,8,-1,-1)，(29,13,-1,-1)，(7,9,-1,-1)，(8,9,-1,-1)，(14,11,-1,-1)，(23,12,-1,-1)，(3,8,-1,-1)，(11,10,-1,-1)，(8,10,6,0)，(15,11,2,3)，(19,12,8,7)，(29,13,4,9)，(42,14,10,5)，(58,14,1,11)，(100,-1,12,13)，
Huffman编码： A：0001，B：10，C：1110，D：1111，E：110，F：01，G：0000，H：001，

*/
//@author  Yeheya。2014年7月22日，2015-9-23，2016年2月2日，2019年9月13日，中秋