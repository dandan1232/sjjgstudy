//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��7��25��
//��5.1   ����
//����5.1��  �����ࡣ                                              //7.2.1 ͼ���ڽӾ����ʾ��ʵ��  ��

public class Matrix                              //������
{
	protected int rows, columns;                 //��������������
    protected int[][] element;                   //��ά���飬�洢����Ԫ��
    private static final int MIN_CAPACITY=5;     //������ָ��element������������Сֵ
    
    //����m��n����Ԫ��Ϊ0����m<0��n<0���������׳���Ч�����쳣
    public Matrix(int m, int n)
    {
        if(m>=0 && n>=0)
        {
            this.rows = m;
            this.columns = n;
            if(m<MIN_CAPACITY)                   //��0��m,n<MIN_CAPACITY��element��������ȡ��Сֵ
                m=MIN_CAPACITY;
            if(n<MIN_CAPACITY)
                n=MIN_CAPACITY;
            this.element = new int[m][n];        //����Ԫ�س�ֵΪ0
        }
        else
            throw new IllegalArgumentException("��������������<0��m="+m+"��n="+n);
    }       ////˵����m=0��n=0����ͼ�������׳��쳣����Ϊ��ͼҲҪ�����ռ䡣
    
    public Matrix(int n)                         //����n��n����Ԫ��Ϊ0
    {
        this(n, n); 
    }
    public Matrix()                              //����0��0���󣻴洢����Ϊ��Сֵ��//˵������ͼ��
    {
        this(0, 0); 
    }
    
    public Matrix(int m, int n, int[][] values)   //����m��n������values[][]�ṩԪ��
    {
        this(m, n);
        for(int i=0;  i<values.length && i<m;  i++)//valuesԪ�ز���ʱ��0�����Զ���Ԫ��
            for(int j=0;  j<values[i].length && j<n;  j++)
               this.element[i][j] = values[i][j];
    }

    public int getRows()                         //���ؾ�������
    {
        return this.rows;
    }
    public int getColumns()                      //���ؾ�������
    {
        return this.columns;
    }
    public int get(int i, int j)                 //���ص�i�е�j��Ԫ�ء���i��j���Խ�磬�׳����Խ���쳣
    {
        if(i>=0 && i<this.rows && j>=0 && j<this.columns) 
            return this.element[i][j];
        throw new IndexOutOfBoundsException("i="+i+"��j="+j);
    }
    public void set(int i, int j, int x)         //���õ�i�е�j��Ԫ��Ϊx����i��j���Խ�磬�׳����Խ���쳣
    {
        if(i>=0 && i<this.rows && j>=0 && j<this.columns) 
            this.element[i][j]=x;
        else
            throw new IndexOutOfBoundsException("i="+i+"��j="+j);
    }
    
    public String toString()                     //���ؾ�������Ԫ�ص������ַ��������������
    {
        String str=" ����"+this.getClass().getName()+"��"+this.rows+"��"+this.columns+"����\n";
        for(int i=0;  i<this.rows;  i++)
        {
            for(int j=0;  j<this.columns;  j++)
                str+=String.format("%6d", this.element[i][j]); //"%6d"��ʽ��ʾʮ��������ռ6��
            str += "\n";
        }
        return str;
    }
    
    //���þ���Ϊm��n�С�������ָ���������ϴ��򽫾������ݣ�������ԭ����Ԫ�ء�
    //����7.2.1��ͼ���ڽӾ���洢�ṹ
    public void setRowsColumns(int m, int n)
    {
        if(m>=0 && n>=0)
        {
            ////˵����element��������<MIN_CAPACITY�����ԣ�����Ҫ�Ƚ�m,n<MIN_CAPACITY�ȣ�ֻ��Ƚ�m��n�Ƿ����
        	//����ָ���������������ϴ�ʱ�������ά��������
            if(m>this.element.length || n>this.element[0].length)
            {
                int[][] source = this.element;
                this.element = new int[m*2][n*2];          //���������ά����ռ䣬Ԫ�س�ֵΪ0
                for(int i=0;  i<this.rows;  i++)           //����ԭ��ά����Ԫ��
                    for(int j=0;  j<this.columns;  j++)
                        this.element[i][j] = source[i][j];
            }
            ////˵�����������䲻��д��if�У�ͼɾ�����������������С��
            ////˵��������д�������ΪҪ��ԭֵ�����㷨�빹�췽����ͬ�����ԣ����빹�췽���ϲ���
            ////˵����m=0��n=0������Ϊ��ͼ�����׳��쳣��
            this.rows = m;
            this.columns = n;
        }
        else
            throw new IllegalArgumentException("��������������<0��m="+m+"��n="+n);
    }
}
/*
�������˵�����£�
��1����ͼ�����¹��췽���е���setRowsColumns(int m, int n)������δ�ɹ����㷨��ͬ�����˰ɣ������ص㲻ͬ��
    public Matrix(int m, int n)
*/
//��ʵ����5-1����ExerciseMatrix��
//author��Yeheya��2014��7��11�գ�2019��7��25��