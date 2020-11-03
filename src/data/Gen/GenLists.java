//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��6��
//��5.3   �����
//��5.3.3   �����˫����ʾ��ʵ��
//����5.3�� �����Ļ���������
//��2�� �ɹ�����ʾ��������
//��5��̲�д��//��������������ܴ��������ӱ�
////���������ӱ��㷨���У������γ���ƣ�����û��ɡ�
package data.Gen;

public class GenLists                            //����������
{
    private static int i=0;                      //��̬��Ա����
    
    //������gliststr��ʾ�����Ĺ����gliststr�﷨��ȷ������null���մ�""
    public static GenList<String> create(String gliststr)
    {
        i=0;
        return createsub(gliststr, null);        //��������û�й����ӱ�
    }

    //���ش�gliststr[i]��ʼ���Ӵ��������ӹ����dataָ��������ԭ�Ӻͱ��������ַ������ݹ鷽����
    //���ܴ��������ӱ�
    //����i��0��ʼ���Ե��������еݹ鷽������һ��i������ֻ������i�ǳ�Ա�����������Ǿֲ�����
    private static GenList<String> createsub(String gliststr, String data)
    {
        if(data==null)
        {
            i = gliststr.indexOf('(');                     //����ָ���ַ��ڴ���λ��
            data = gliststr.substring(0,i);                //'('ǰ���ַ����Ǳ���
        }
        GenList<String> genlist = new GenList<String>(data);//����ձ�dataָ������
        GenNode<String> p = genlist.head;                  //ָ��ͷ���
        i++;                                               //����'('
        while(i<gliststr.length())
        {
            switch(gliststr.charAt(i))
            {
                case ',':  i++;  break;
                case ')':  i++;  return genlist;
                default :                                  //�ַ�
                {
                    //����ѭ���ӵ�i���ַ���ʼѰ��ԭ��/�����Ӵ�����"(,)"֮һ��Ϊ�ָ��
                    int end=i;
                    while(end<gliststr.length()  &&  "(,)".indexOf(gliststr.charAt(end))==-1)
                        end++;
                    data = gliststr.substring(i, end);     //i��end-1���Ӵ���ԭ��/����
                    i=end;                                 //�ı�i���¸��ָ��λ��

                    //�¾䴴��ԭ��/�ӱ��㣻�ӱ����б������ޱ���ʱΪ�մ�
                    p.next = new GenNode<String>(data, null, null);
                    p = p.next;
                    if(i<gliststr.length() && gliststr.charAt(i)=='(')
                        p.child = createsub(gliststr, data);//�����ӱ��ݹ����
                }
            }
        }
        return genlist;
    }
    //ע�⣺ֻ������i��ȫ�ֱ�����
    //�������i�Ǿֲ��������ݹ���������Ӵ����������ڣ�����')'���أ��޷����ظı��˵�iֵ��
    
    public static void main(String args[])
    {
        String[] gliststrs={
            "()",                                //���������Ĺ�����ʾ
        	"(())",
        	"(a,b)",
            "(c,(a,b))",
            "(d,(a,b),(c,(a,b)))",
            "(and,(begin,end),(my,your,(his,her)))",//�����Ԫ��ֵ���ַ���
            "E()",                               //�������Ĺ�����ʾ
            "L(a,b)",
            "T(c,L(a,b))",
            "G(d,L(a,b),T(c,L(a,b)))",
            "�й�(����, �Ϻ�, ����(�Ͼ�, ����), �㽭(����))", //�������ܹ���ɭ��
            "��ѧ(��ѧ, ����, ��ѧ, ����, ����, ��ʷ, ����(����, ֲ��, ���ﻯѧ), ����, ����,"+ 
    		     "�����(�������ѧ�뼼��, �������, ���繤��))"};
    	
        for(int i=0; i<gliststrs.length; i++)
        {
            GenList<String> genlist = GenLists.create(gliststrs[i]);   //��������
            System.out.println(genlist.toString());
        }  

        //����5.3�� �����Ļ����������������졢���������롢ɾ����
        String gliststr="G(d,L(a,b),T(c,L(a,b)))";         //�������Ĺ�����ʾ
        GenList<String> graph = GenLists.create(gliststr); //��������û�й����ӱ�
        System.out.println("���죬\t\t"+graph.toString()+"��size="+graph.size()+"��depth="+graph.depth());

        //����ִ�в��롢ɾ��������˵���Ƿ����ӱ�
        GenList<String> list = graph.get(1).child;         //�����ӱ�L(a,b)
        graph.insert(0,list);                              //Gͷ�����ӱ�list��list��Ϊ�����ӱ�
        System.out.println(graph.getName()+"ͷ����"+list.toString()+"��\t"+graph.toString());
        
        GenNode<String> p = list.remove(0);                 //�����ӱ�listͷɾ��ԭ�� 
        System.out.println(list.getName()+"ͷɾ��"+(p!=null ? list.toString(p) : "")+"��\t"+graph.toString());
        
        p = list.insert(0,"e");                             //ͷ����ԭ��
        System.out.println(list.getName()+"ͷ����"+(p!=null ? list.toString(p) : "")+"��\t"+graph.toString());
        
        GenList<String> tree = graph.get(3).child;         //�����ӱ�T
        while(!graph.isEmpty())
        {
            p = graph.remove(0);                            //ͷɾ��Ԫ�أ�ԭ��/�ӱ���㣬û��ɾ���ӱ�
            System.out.println(graph.getName()+"ͷɾ��"+(p!=null ? graph.toString(p) : "")+"��\t"+graph.toString());
        }
        //ɾ����Ԫ�أ�ԭ��/�ӱ���㣬û��ɾ���ӱ�
        System.out.println(list.toString());
        System.out.println(tree.toString());
    }
}
/*
�������н�����£�
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
�й�(����, �Ϻ�, ����(�Ͼ�, ����), �㽭(����))
��ѧ(��ѧ, ����, ��ѧ, ����, ����, ��ʷ, ����(����, ֲ��, ���ﻯѧ), ����, ����,�����(�������ѧ�뼼��, �������, ���繤��))

//����5.3�������Ļ���������
���죬		G(d,L(a,b),T(c,L(a,b)))��size=3��depth=3
Gͷ����L(a,b)��	G(L(a,b),d,L(a,b),T(c,L(a,b)))
Lͷɾ��a��	G(L(b),d,L(b),T(c,L(a,b)))
Lͷ����e��	G(L(e,b),d,L(e,b),T(c,L(a,b)))
Gͷɾ��L(e,b)��	G(d,L(e,b),T(c,L(a,b)))
Gͷɾ��d��	G(L(e,b),T(c,L(a,b)))
Gͷɾ��L(e,b)��	G(T(c,L(a,b)))
Gͷɾ��T(c,L(a,b))��	G()
L(e,b)
T(c,L(a,b))

*/    
/*
//����ϣ�����칲���ӱ��㷨���У�δ���
private static int i=0;
public static GenList<String> create(String gliststr)  //������gliststr��ʾ�����Ĺ����
{
    i=0;
    //�����ӱ�Լ��������ͬ��Ϊͬһ����
    SeqList<GenList<String>> seqlist = new SeqList<GenList<String>>();  //����˳����洢�Ѵ������ӱ�
    return createsub2(gliststr, null, seqlist);
}

    //�����ӱ�
    private static GenList<String> createsub2(String gliststr, String data, SeqList<GenList<String>> seqlist)
    {
    	if(data==null)
    	{
    		i = gliststr.indexOf('(');
    		data = gliststr.substring(0,i);    	 //��ñ����ַ���
    	}
    	GenList<String> genlist = new GenList<String>(data);//����ձ�ͷ����data��洢����
        seqlist.insert(genlist);                 //˳���β����
        GenNode<String> p = genlist.head;        //ָ��ͷ���
        i++;                                     //����'('
        while(i<gliststr.length())
            switch(gliststr.charAt(i))
            {
                case ',':  i++; break;
                case ')':  i++; return genlist;
                default :                        //���ַ�����ʾԭ��
                {
                    int end=i;//element()����Ԫ�أ���"(,)"֮һ�ָi
                    while(end<gliststr.length() && "(,)".indexOf(gliststr.charAt(end))==-1)
                        end++;
                    data = gliststr.substring(i, end);  //��ô�i��end-1���Ӵ������
                    i=end;                                    //�ı�i���Ӵ����¸��ַ�
                	
                	p.next=new GenNode<String>(data, null, null); //����ԭ��/�ӱ��㣬�ӱ����б������ޱ���ʱΪ�մ�
                    p = p.next;
                    if(i<gliststr.length() && gliststr.charAt(i)=='(')
                    {
                    	for(int j=0; p.child==null && j<seqlist.size(); j++)//˳�������㷨��Ѱ�ҹ����ӱ�
                    		if(data.equals(seqlist.get(j).head.data))
                    			p.child = seqlist.get(j);
                    	if(p.child==null) 
                    	{
                    	    p.child = createsub2(gliststr, data, seqlist);    //�����ӱ��ݹ����
                    	}
                    }
                }
        }
        return genlist;
    }
    //δ��ɣ����н�����£�
    G(d,L(a,b),T(c,L(a,b),(a,b)))
    L(a,b)��ͷɾ��a��
    G(d,L(b),T(c,L(b),(a,b)))
*/    
//@author��Yeheya��2014��10��6�գ�2020��2��3��