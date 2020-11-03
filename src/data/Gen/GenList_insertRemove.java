//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��12��29��
//��5.3   �����
//��5.3.2   �����Ĵ洢�ṹ��ʵ��
//����5.3��������˫����ʾ�������㷨��
//��1�� ���������Թ����Ĳ���
package data.Gen;
public class GenList_insertRemove
{    
    public static void main(String args[])
    {
    	//��1������������ȷ
/*      //�ձ�������"()"
    	GenList<String> empty = new GenList<String>();
        System.out.println("empty="+empty.toString()+"��size="+empty.size()+"��depth="+empty.depth()); 

        empty.insert(new GenList<String>());      //�ձ��в���ձ�
        System.out.println(empty.toString()+"��size="+empty.size()+"��depth="+empty.depth()); 

    	//�ձ�������"E()"
    	empty = new GenList<String>("E");
        System.out.println(empty.toString()+"��size="+empty.size()+"��depth="+empty.depth()); 
*/
        //������"L(a,b)"���ɱ���"L"��ԭ�����鹹������
    	String[] atoms={"a","b"};
        GenList<String> list = new GenList<String>("L",atoms);  
//        System.out.println(list.toString()+"��size="+list.size()+"��depth="+list.depth()); 
        
        //��2������ԭ�Ӻ��ӱ�
        //������"T(c,L(a,b))"���ȹ���ձ�"T()"���ٲ���ԭ��c���ӱ�"L(a,b)"
        GenList<String> tree = new GenList<String>("T");
        tree.insert("c");                        //�ձ����ԭ��
        tree.insert(list);                       //β�����ӱ�
//        System.out.println(tree.toString()+"��size="+tree.size()+"��depth="+tree.depth()); 
        
        //ͼ5.17 ������"G(d,L(a,b),T(c,L(a,b))))"�������ӱ������ӱ�list��tree
        GenList<String> graph = new GenList<String>("G");
        graph.insert(tree);                      //�ձ�����ӱ�tree
        graph.insert(0,list);                    //ͷ�����ӱ�list��list��Ϊ�����ӱ�
        graph.insert(0,"d");                     //ͷ����ԭ��
        System.out.println("graph="+graph.toString()+"��size="+graph.size()+"��depth="+graph.depth());
        
//        //�ڹ����ӱ�list�в��룬�����ӱ�
//        System.out.println("\nlist����efg��graphͷ����L���м����T"); 
//        list.insert(0,"e");                      //ͷ����ԭ��
//        list.insert("g");                        //β����ԭ��
//        list.insert(3,"f");                      //�м����ԭ��
//        graph.insert(0,list);                    //ͷ�����ӱ�
//        graph.insert(3,tree);                    //�м�����ӱ�
//        System.out.println(list.toString()); 
//        System.out.println(tree.toString());
//        System.out.println(graph.toString());
//
//        //��3��ɾ��ԭ�Ӻ��ӱ�
//        System.out.println("\nlistɾ��efg��graphɾ��L��T"); 
//        list.remove(0);                          //ͷɾ��ԭ�ӣ���ȷ
//        list.remove(2);                          //�м�ɾ��ԭ��
//        list.remove(2);                          //βɾ��ԭ��
//        graph.remove(0);                         //ͷɾ���ӱ�
//        graph.remove(3);                         //�м�ɾ���ӱ�
//        System.out.println(list.toString()); 
//        System.out.println(tree.toString());
//        System.out.println(graph.toString());
        
        //��ʵ����5���γ�����⡿���������������ӱ��Ƴɶ���
        //����ִ�в��롢ɾ��������˵���Ƿ����ӱ�
        list = graph.get(1).child;                          //�����ӱ�L(a,b)
        GenNode<String> p = list.remove(0);                 //�����ӱ�listͷɾ��ԭ�� 
        System.out.println(list.getName()+"ͷɾ��"+(p!=null ? list.toString(p) : "")+"��\tgraph ="+graph.toString());

        GenList<String> graph2 = new GenList<String>(graph);//����������ӱ��Ƴɶ���
        System.out.println("�����\t\tgraph2="+graph2.toString());
        System.out.println("graph.equals(graph2)="+graph.equals(graph2));
        
        list = graph2.get(1).child;                          //�����ӱ�L(a,b)
        p = list.remove(0);                 //�����ӱ�listͷɾ��ԭ�� 
        System.out.println(list.getName()+"ͷɾ��"+(p!=null ? list.toString(p) : "")+"��\tgraph2="+graph2.toString());
        System.out.println("graph.equals(graph2)="+graph.equals(graph2));
    }
}
/*
�������н�����£�
empty=()��size=0��depth=1
(())��size=1��depth=2

L(a,b)��size=2��depth=1
T(c,L(a,b))��size=2��depth=2
G(d,L(a,b),T(c,L(a,b)))��size=3��depth=3

list����efg��graphͷ����L���м����T
L(e,a,b,f,g)
T(c,L(e,a,b,f,g))
G(L(e,a,b,f,g),d,L(e,a,b,f,g),T(c,L(e,a,b,f,g)),T(c,L(e,a,b,f,g)))

listɾ��efg��graphɾ��L��T
L(a,b)
T(c,L(a,b))
G(d,L(a,b),T(c,L(a,b)))                      //ͷɾ������ȷ


 //��ʵ����5���γ�����⡿���������������ӱ��Ƴɶ���
graph=G(d,L(a,b),T(c,L(a,b)))��size=3��depth=3
Lͷɾ��a��	graph =G(d,L(b),T(c,L(b)))               //�����ӱ�
�����		graph2=G(d,L(b),T(c,L(b)))               //�����ӱ��Ƴɶ���
graph.equals(graph2)=true                            //�ṹ��ͬ��
Lͷɾ��b��	graph2=G(d,L(),T(c,L(b)))
graph.equals(graph2)=false


*/
//author��Yeheya��2014-10-6��2020��2��5��