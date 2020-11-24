//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��8��12��
//��7.2.2  ͼ���ڽӾ���洢�ṹ��ʵ��
//2. �ڽӾ���洢�Ĵ�Ȩͼ��
package data.PicGraph;
import data.Matrix.Matrix;
import data.Matrix.Triple;
import data.PicGraph.*;
//�ڽӾ���洢�Ĵ�Ȩͼ�࣬T��ʾ����Ԫ�����ͣ��̳г���ͼ��
public class MatrixGraph<T> extends AbstractGraph<T>
{
    protected Matrix matrix;                     //������󣬴洢ͼ���ڽӾ���
    
    public MatrixGraph()                         //�����ͼ��������Ϊ0������Ϊ0
    {
        super();                                 //����ն���˳���Ĭ������
        this.matrix = new Matrix(0,0);           //����0��0����Ĭ������
    }
    public MatrixGraph(T[] vertexes)             //��vertexes���㼯�Ϲ���ͼ���߼���Ϊ��
    {
        this();
        for(int i=0; i<vertexes.length; i++)
            this.insert(vertexes[i]);            //���붥�㣬�Ժ�˵���㷨
    } 
    public MatrixGraph(T[] vertexes, Triple[] edges)  //��vertexes���㼯�Ϻ�edges�߼��Ϲ���ͼ
    {
        this(vertexes);                          //��vertexes���㼯�Ϲ���ͼ��û�б�
        for(int j=0; j<edges.length; j++)
            this.insert(edges[j]);               //����ߣ��Ժ�˵���㷨
    }

    public String toString()                     //����ͼ�Ķ��㼯�Ϻ��ڽӾ��������ַ���
    {
        String str = super.toString()+"�ڽӾ���:  \n";
//        str+=this.matrix.toString();
        int n = this.vertexCount();              //������
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(this.matrix.get(i,j)==MAX_WEIGHT)
                    str += "     ��";
                else
                    str += String.format("%6d", this.matrix.get(i,j));
            }
            str+="\n";
        }
        return str;
//        return super.toString()+"�ڽӾ���:  \n"+AbstractGraph.toString(this.matrix.element);
    }
    //����7.1��  �����Ȩͼ��

    //��2�����붥��
    public int insert(T x)                       //����Ԫ��Ϊx�Ķ��㣬����x�������
    {
        this.vertexlist.insert(x);               //����˳���β����x���Զ�����
        int i = this.vertexlist.size()-1;        //��ò��붥��x�����
        if(i >= this.matrix.getRows())           //���ڽӾ�����������
            this.matrix.setRowsColumns(i+1, i+1); //��������ݡ������ڽӾ���������ͬͼ�Ķ�����
        for(int j=0; j<i; j++)                   //��ʼ����i�С���Ԫ��ֵΪ�ޡ�i==jֵ��Ϊ0
        {
            this.matrix.set(i, j, MAX_WEIGHT);
            this.matrix.set(j, i, MAX_WEIGHT);  
        }
        return i;                                //���ز��붥�����
    }
    
    //��3�������
    public void insert(int i, int j, int w)      //����ߡ�vi,vj����ȨֵΪw
    {
        if(i!=j)                                 //���ܱ�ʾ����
        {
            if(w<=0 || w>MAX_WEIGHT)             //�ߵ�Ȩֵ�ݴ���Ϊ�ޱߣ�ȡֵ��
                w=MAX_WEIGHT;
            this.matrix.set(i,j,w);              //���þ���Ԫ��[i,j]ֵΪw����i��jԽ�磬�׳����Խ���쳣
        }
        else
            throw new IllegalArgumentException("���ܲ���������i="+i+"��j="+j);
    }
    public void insert(Triple edge)              //����һ����
    {
        this.insert(edge.row, edge.column, edge.value);
    }

    //��4��ɾ����
    public void remove(int i, int j)             //ɾ���ߡ�vi,vj��������Ȩֵ
    {
        if(i!=j)
            this.matrix.set(i, j, MAX_WEIGHT);   //���ñߵ�ȨֵΪ�ޡ���i��jԽ�磬���׳����Խ���쳣
    }
    public void remove(Triple edge)              //ɾ���ߣ�����Ȩֵ
    {
        this.remove(edge.row, edge.column);
    }    
    
    //��5��ɾ������
    public T remove(int i)   //ɾ������vi�������й����ıߣ����ض���viԪ�ء������һ�������滻����vi
    {
        //super.remove(i);       ////Ҳ�ɣ���5��̲�ûд��
        int n=this.vertexCount();                //ԭ������
        if(i>=0 && i<n)
        {
            T x = this.vertexlist.get(n-1);      //���һ������Ԫ��
            this.vertexlist.set(i, x);           //����i������Ԫ���滻Ϊ���һ��  
            x = this.vertexlist.remove(n-1);     //ɾ�����һ�����㣨��������1����  //˳���ɾ������iԽ�磬����null
            
            for(int j=0;  j<n;  j++)             //����i��Ԫ���滻Ϊ��n-1��
                this.matrix.set(i, j, this.matrix.get(n-1,j));
            for(int j=0;  j<n;  j++)             //����i��Ԫ���滻Ϊ��n-1��
                this.matrix.set(j, i, this.matrix.get(j, n-1));
            this.matrix.setRowsColumns(n-1, n-1);//�ڽӾ�����һ��һ��
            return x;
        }
        else
            throw new IndexOutOfBoundsException("i="+i);  //�׳����Խ���쳣
    }
    
    //��5�� ����ڽӶ���ͱߵ�Ȩֵ���� 
    public int weight(int i, int j)              //����<vi,vj>�ߵ�Ȩֵ������ͼ����С�����������·�����㷨
    {
        return this.matrix.get(i,j);             //���ؾ���Ԫ��[i,j]ֵ����i��jԽ�磬�׳����Խ���쳣
    }
    
    //���ض���vi��vj��ĺ���ڽӶ������ ����j=-1������vi�ĵ�һ���ڽӶ�����ţ��������ں���ڽӶ��㣬����-1������7.3��ͼ�ı����㷨
    protected int next(int i, int j)
    {
        int n=this.vertexCount();
        if(i>=0 && i<n && j>=-1 && j<n && i!=j) 
            for(int k=j+1;  k<n;  k++)           //��j=-1ʱ��k��0��ʼѰ�Һ���ڽӶ���
                if(this.matrix.get(i,k)>0 && this.matrix.get(i,k)<MAX_WEIGHT)//Ȩֵ��ʾ�б�
                    return k;
        return -1;         
    }  
}
//@author��Yeheya��2014��7��24�գ�2015-3-15��2016-2-6��2019��10��14��