//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��7��23��
//��2.3.2  ������
//7.  ������ļ��ϲ�����
//ͼ2.20  ������ļ��ϲ�����

public class SinglyList_concat 
{
	public static void main(String args[])
    {
		//(1) �ϲ�����������ӱ������
		String[] valuea={"a","b","c"}, valueb={"x","y"};
	    SinglyList<String> lista = new SinglyList<String>(valuea);
	    SinglyList<String> listb = new SinglyList<String>(valueb);
        System.out.println("\t\t\tlista="+lista.toString()+"��\t\tlistb="+listb.toString());
/*
        lista.concat(listb);                      //��lista֮������listb
        System.out.println("lista.concat(listb)��\tlista="+lista.toString()+"��\tlistb="+listb.toString());
        listb.insert("z");
        System.out.println("listb.insert(\"z\")��\tlista="+lista.toString()+"��\tlistb="+listb.toString());
        
        lista.addAll(listb);
        System.out.println("lista.addAll(listb)��\tlista="+lista.toString()+"��\tlistb="+listb.toString());
*/
        //(3) ����ӱ��أ������
        System.out.println("lista.union(listb)="+lista.union(listb).toString());
        System.out.println("\t\t\tlista="+lista.toString()+"��\t\tlistb="+listb.toString());
	}
}
/*
�������н�����£�    
        //��1��concat(list)û������listΪ��
                      lista=(a,b,c)��                                listb=(x,y)
lista.concat(listb)��    lista=(a,b,c,x,y)��                      listb=(x,y)
listb.insert("z")��         lista=(a,b,c,x,y,z)��                 listb=(x,y,z)            //����������������lista�߼���
lista.addAll(listb)��    lista=(a,b,c,x,y,z,x,y,z)��  listb=(x,y,z,x,y,z)      //listb�߼���


        //��2��concat(list)����listΪ�գ������������޹�
                      lista=(a,b,c)��                   listb=(x,y)
lista.concat(listb)��    lista=(a,b,c,x,y)��         listb=()
listb.insert("z")��         lista=(a,b,c,x,y)��         listb=(z)                      //��������listb
lista.addAll(listb)��    lista=(a,b,c,x,y,z)��    listb=(z)

        //(3) ����ӱ��أ������
            lista=SinglyList(a,b,c)��        listb=SinglyList(x,y)
lista.union(listb)=SinglyList(a,b,c,x,y)
            lista=SinglyList(a,b,c)��        listb=SinglyList(x,y)

*/
//@author��Yeheya��2015-9-19��2019��7��23��