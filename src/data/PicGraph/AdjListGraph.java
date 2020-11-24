//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��8��12��
//��7.2.3   ͼ���ڽӱ�洢�ṹ��ʵ��
package data.PicGraph;

import data.Matrix.LinkedMatrix;
import data.Matrix.Triple;
import data.singly.Node;
import data.singly.SortedSinglyList;

//�ڽӱ�洢�Ĵ�Ȩͼ�࣬T��ʾ����Ԫ�����ͣ��̳г���ͼ��
public class AdjListGraph<T> extends AbstractGraph<T>
{
    protected LinkedMatrix linkmat;              //ͼ���ڽӱ������еĵ�����
    
    public AdjListGraph()                        //�����ͼ��������Ϊ0������Ϊ0
    {
        super();                                 //����ն���˳���Ĭ������
        this.linkmat = new LinkedMatrix(0,0);    //����0��0����Ĭ������
    }
    public AdjListGraph(T[] vertexes)            //��vertexes���㼯�Ϲ���ͼ���߼���Ϊ��
    {
        this();
        for(int i=0;  i<vertexes.length;  i++)
            this.insert(vertexes[i]);            //���붥�㣬�Ժ�˵���㷨
    } 
    public AdjListGraph(T[] vertexes, Triple[] edges)//��vertexes���㼯�Ϻ�edges�߼��Ϲ���ͼ
    {
        this(vertexes);                          //��vertexes���㼯�Ϲ���ͼ��û�б�
        for(int j=0;  j<edges.length;  j++)
            this.insert(edges[j]);               //����ߣ��Ժ�˵���㷨
    }
    
    //��vertexes���㼯�Ϻ�edges�߼��Ϲ���ͼ��edges�ַ���ָ���߼��ϣ���,���ָ���û�пո�
    public AdjListGraph(T[] vertexes, String edges)
    {
        this(vertexes);                          //��vertexes���㼯�Ϲ���ͼ��û�б�
        this.linkmat = new LinkedMatrix(vertexes.length, vertexes.length, edges);//����n��n����
    }

    public String toString()                     //����ͼ�Ķ��㼯�Ϻ��ڽӱ������ַ���
    {
        return super.toString()+"���߱�\n"+this.linkmat.toString();
    }
    
    //��2�����붥��
    public int insert(T x)                       //����Ԫ��Ϊx�Ķ��㣬����x�������
    {
        this.vertexlist.insert(x);               //����˳���β����x���Զ�����
        int i = this.vertexlist.size()-1;        //��ò��붥��x�����
        if(i >= this.linkmat.getRows())          //���ڽӱ���������
            this.linkmat.setRowsColumns(i+1, i+1);//�����ݣ������ڽӱ�����ͬͼ�Ķ�����
        return i;                                //���ز��붥�����
    }

    //��3�������
    public void insert(int i, int j, int w)      //����ߡ�vi,vj����ȨֵΪw
    {
        if(i!=j)                                 //���ܱ�ʾ����
        {
            if(w<0 || w>=MAX_WEIGHT)             //�ߵ�Ȩֵ�ݴ���Ϊ�ޱߣ�ȡֵ0
                w=0;
            this.linkmat.set(i, j, w);           //���õ�i���ߵ������С�vi,vj���ߵ�ȨֵΪw��
            //��0<w<�ޣ�����߻��滻�ߵ�Ȩֵ����w==0��ɾ���ñߡ���i��jԽ�磬�׳����Խ���쳣
        }
        else
            throw new IllegalArgumentException("���ܲ���������i="+i+"��j="+j);
    }
    public void insert(Triple edge)              //����һ���ߡ�������ͬͼ���ڽӾ���ʡ��
    {
        this.insert(edge.row, edge.column, edge.value);
    }
    
    //��4��ɾ����
    public void remove(int i, int j)             //ɾ��һ���ߡ�vi,vj��������Ȩֵ
    {
        if(i!=j)
            this.linkmat.set(new Triple(i,j,0)); //���ñߵ�ȨֵΪ0�����ڵ�i���ߵ�������ɾ���߽��
    }
    public void remove(Triple edge)              //ɾ��һ���ߡ�������ͬͼ���ڽӾ���ʡ��
    {
        this.remove(edge.row, edge.column);
    }

    //��5��ɾ������
    public T remove(int i)          //ɾ������vi�������й����ıߣ����ض���viԪ�ء������һ�������滻����vi
    {
        int n=this.vertexCount();                //ͼ�Ķ�����
        if(i>=0 && i<n)
        {
            //�� ����˳���ɾ����i�����㣬�����һ�������滻����vi
            T x = this.vertexlist.get(n-1);
            this.vertexlist.set(i, x);  
            x = this.vertexlist.remove(n-1);
            
            //�� ɾ�������붥��vi������ıߡ�
            //<I> ɾ�����i���ߵ�������ÿ���߶ԳƵı߽��
            SortedSinglyList<Triple> link = (SortedSinglyList<Triple>) this.linkmat.rowlist.get(i);
            for(Node<Triple> p = link.head.next; p!=null; p=p.next)  //������i���ߵ�����
                this.remove(p.data.toSymmetry());//ɾ����p�߽��ԳƵı�

            //<II> �����һ���ߵ�������ÿ���߼���ԳƱߵĶ������n-1��Ϊi
            link = (SortedSinglyList<Triple>) this.linkmat.rowlist.get(n-1);
            for(Node<Triple> p=link.head.next;  p!=null;  p=p.next)
            {
                Triple edge = p.data.toSymmetry();    //��p�߽��ԳƵı�
                this.remove(edge);               //ɾ����
                edge.column = i;                 //�ߵ��յ���Ÿ�Ϊi
                this.insert(edge);               //�ٲ���ߣ�Ϊ������
                p.data.row = i;                  //p�߽�㣬�ߵ������Ÿ�Ϊi
            }

            //<III> ����ָ��˳����У�����i���ߵ������滻Ϊ���һ����n-1������ɾ�����һ����
            this.linkmat.rowlist.set(i, this.linkmat.rowlist.get(n-1));
            this.linkmat.rowlist.remove(n-1);
            this.linkmat.setRowsColumns(n-1, n-1);//���þ�������������һ��
            return x;
        }
        else
            throw new IndexOutOfBoundsException("i="+i);  //�׳����Խ���쳣
    }
    //@author��Yeheya��2016-2-7����Ϧ
    
    //��5�� ����ڽӶ���ͱߵ�Ȩֵ����
    public int weight(int i, int j)              //����<vi,vj>�ߵ�Ȩֵ������ͼ����С�����������·�����㷨
    {     
        if(i==j)
            return 0;
        int w = this.linkmat.get(i,j);           //���ؾ���Ԫ��[i,j]ֵ����i��jԽ�磬�׳����Խ���쳣
        return w!=0 ? w : MAX_WEIGHT;            //������0��ʾû�бߣ���ߵ�Ȩֵ���ء�
    }
    
    //���ض���vi��vj��ĺ���ڽӶ�����ţ���j=-1������vi�ĵ�һ���ڽӶ�����ţ��������ں���ڽӶ��㣬����-1������7.3��ͼ�ı����㷨
    protected int next(int i, int j)
    {
        int n=this.vertexCount();
        if(i>=0 && i<n && j>=-1 && j<n && i!=j)
        {
            SortedSinglyList<Triple> link = (SortedSinglyList<Triple>) this.linkmat.rowlist.get(i);//��i����������
            Node<Triple> find=link.head.next;              //�������0��Ԫ��
            if(j==-1)
                return find!=null ? find.data.column : -1; //���ص�һ���ڽӶ�������
            find = link.search(new Triple(i,j,0));         //˳�����<vi,vj>�ߵĽ��
            if(find!=null && (find=find.next)!=null)       //find����<vi,vj>�ߵĺ�̽��
                return find.data.column;                   //���غ���ڽӶ������
        }
        return -1;
    }
}
/*
    //��10�£�10.2 ʵ�ֵ�����
    //10.2.2   ���ڵ������Ĳ���
    //��˼����10-4��
    public void removeVertex(int i)              //ɾ������vi��������ıߡ�ʹ�õ����������������û���õ�ɾ��
    {
        int n=this.vertexCount();                          //ɾ��֮ǰ�Ķ�����
        if (i>=0 && i<n)
        {
            //ɾ�����i���ߵ����������н��ԳƵıߣ����ڵ�i������ıߵ������У�ɾ��������iΪ�յ�ı�
            SortedSinglyList<Triple> link = this.linkmat.rowlist.get(i);//��õ�i����������
            java.util.Iterator<Triple> it = link.iterator();//��õ��������������
            while (it.hasNext())                           //������i���ߵ�����
                this.removeEdge(it.next().toSymmetry());   //ɾ����p���ԳƵı�

            n--;                                           //��������1
            this.linkmat.rowlist.remove(i);                //ɾ����ָ��˳���ĵ�i���ߵ����������������
            this.linkmat.setRowsColumns(n, n);             //���þ�������������һ��

            for (int j=0; j<n; j++)                        //����ÿ���ߵ�������>i�Ķ�����ż�1
            {
                link = this.linkmat.rowlist.get(j);
//                for (Node<Triple> p=link.head.next; p!=null; p=p.next)//������j���ߵ�����
                it = link.iterator();                      //��õ�i�������������������
                while (it.hasNext())                       //������i���ߵ�����
                {
                    Triple tri= it.next();
                    if (tri.row > i)
                        tri.row--; 
                    if (tri.column > i)
                        tri.column--;
                }
            }
            this.vertexlist.remove(i);                     //ɾ������vi��i�󶥵���ż�1��ͼ��������1
        }
        else throw new IndexOutOfBoundsException("i="+i);  //�׳����Խ���쳣
    }
}*/
//@author��Yeheya��2014��7��31�գ�2015-3-15��2019��8��15��