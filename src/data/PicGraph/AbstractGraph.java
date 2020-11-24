//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��8��11��
//��7.2  ͼ�Ĵ洢�ṹ��ʵ��
//��7.2.1  ����ͼ��
//��7.3  ͼ�ı���
//��7.4.2   ��С�������Ĺ����㷨
//��7.5   ���·��
//��10.3.4   ���ݷ�
package data.PicGraph;
import data.Matrix.Triple;
import data.singly.SeqList;
import data.singly.SinglyList;
import data.stackandqueue.Queue;
import data.stackandqueue.SeqQueue;

//����ͼ�࣬ʵ��ͼ�ӿڣ�����˳���洢ͼ�Ķ��㼯�ϣ�T��ʾ����Ԫ������
public abstract class AbstractGraph<T> implements Graph<T> 
{
    protected static final int MAX_WEIGHT=0x00ffffff; //���Ȩֵ����ʾ�����ޣ�
                             ////ע�⣺������Integer.MAX_VALUE����Ϊ���·��Ҫ�ӣ�������ɸ���
    //public 
    protected SeqList<T> vertexlist;             //����˳����洢ͼ�Ķ��㼯��
    
    public AbstractGraph()                       //�����ͼ��������Ϊ0
    {
        this.vertexlist = new SeqList<T>();      //�����˳���Ĭ������
    }
    
    public int vertexCount()                     //����ͼ�Ķ�����
    {
        return this.vertexlist.size();           //���ض���˳����Ԫ�ظ���
    }

    public String toString()                     //����ͼ�Ķ��㼯�������ַ���
    {
        return "���㼯�ϣ�"+this.vertexlist.toString()+"\n";
    }

    public T get(int i)                          //���ض���viԪ�أ���iԽ�磬�򷵻�null
    {
        return this.vertexlist.get(i);
    }////������

    public void set(int i, T x)                  //���ö���viԪ��Ϊx
    {
        this.vertexlist.set(i,x);                //��iԽ�磬���׳��쳣
    }
   
    //���³��󷽷�û�з����壬�������ṩʵ��
//    public abstract int insert(T x);           //β����Ԫ��Ϊx�Ķ��㣬����x�������
//    public abstract T remove(int i);           //ɾ������vi�������й����ı�
//    public abstract int weight(int i, int j);    //����<vi,vj>�ߵ�Ȩֵ

    public int search(T key)                     //���Ҳ������׸���key���Ԫ�صĶ������
    {
    	return this.vertexlist.search(key);
    }
    
    public T remove(T key)                       //���Ҳ�ɾ���׸���key���Ԫ�ض��㼰������ı�
    {
        return this.remove(this.search(key));    //ɾ������vi��������ıߣ����󷽷���������ʵ��
    } 
    
    //����vi��vj��ĺ���ڽӶ�����ţ���j=-1������vi�ĵ�0���ڽӶ�����ţ��������ں���ڽӶ��㣬����-1
    protected abstract int next(int i, int j);

    //��7.3   ͼ�ı���    
    //��7.3.1   ͼ��������ȱ���
    public void DFSTraverse(int i)               //ͼ�Ӷ���vi������һ��������ȱ�������������ͨͼ
    {
        if(i<0 || i>=this.vertexCount())
           return;
        boolean[] visited = new boolean[this.vertexCount()]; //���ʱ�����飬Ԫ�س�ֵΪfalse����ʾδ������
        int j=i;
        do
        {
            if(!visited[j])                     //������vjδ������
            ////��j���Խ�磬��Java�׳�ArrayIndexOutOfBoundsException�����±����Խ���쳣
            {
                System.out.print("{ ");
                this.depthfs(j, visited);        //�Ӷ���vj������һ�������������
                System.out.print("} ");
            }
            j = (j+1) % this.vertexCount();      //��������ͨ������Ѱ��δ�����ʶ���
        } while(j!=i);
        System.out.println();
    }
    //��5�棬��Ϊ���£����У�ѭ������Ϊ0��ͬ�����ܸ�Ϊwhile()
//      for(int j=i;  j!=i;  j=(j+1) % this.vertexCount())  //��������ͨ������Ѱ��δ�����ʶ���
//          if(!visited[j])                      //������vjδ�����ʡ���iԽ�磬Java���׳������±����Խ���쳣

    //�Ӷ���vi������һ�������������������һ����ͨ������visited[]ָ�����ʱ�ǣ��������͡��ݹ��㷨
    private void depthfs(int i, boolean[] visited)
    {
//        System.out.print(this.get(i)+" ");       //���ʶ���vi
        System.out.print("->"+this.get(i)+" ");  //���ʶ���vi////��ʾ·�����൱����ջ
        visited[i] = true;                       //���÷��ʱ��
        //����ѭ��j���λ��vi�������ڽӶ�����š�
        //next(i,j)����vi��vj��ĺ���ڽӶ�����ţ���j=-1������vi�ĵ�0���ڽӶ�����ţ��������ں���ڽӶ��㣬����-1
        for(int j=next(i,-1); j!=-1; j=next(i,j))
            if(!visited[j])                      //������vjδ������
            {
                depthfs(j, visited);             //��vj��������������������ݹ����
                System.out.print(this.get(i)+"<- ");       //���ʶ���vi���൱�ڳ�ջ
            }
    }
    //�㷨�ṹͬ�����ȸ���������������ݹ飬�ֵ���ѭ������
    
    
    //��7.3.2   ͼ�Ĺ�����ȱ���
    public void BFSTraverse(int i)               //ͼ�Ӷ���vi������һ�ι�����ȱ�������������ͨͼ
    {
        if(i<0 || i>=this.vertexCount())
            return;
        boolean[] visited = new boolean[this.vertexCount()]; //���ʱ������
        //�¾�˳��ѭ�����С�Ϊ����ʾ˳��ѭ�����У�����Ϊ������-1���޲���ʱ��Ĭ������
        Queue<Integer> que = new SeqQueue<Integer>(this.vertexCount()-1);
//        Queue<Integer> que = new LinkedQueue<Integer>();   //��ʽ����
        int j=i;
        do
        {   if(!visited[j])                      //������vjδ������
            ////��j���Խ�磬��Java�׳�ArrayIndexOutOfBoundsException�����±����Խ���쳣
            {
                System.out.print("{ ");
                breadthfs(j, visited, que);      //��vj������һ�ι����������
                System.out.print("} ");
            }
            j = (j+1) % this.vertexCount();      //��������ͨ������Ѱ��δ�����ʶ���
        } while(j!=i);
        System.out.println();
    }
        
    //�Ӷ���vi������һ�ι����������������һ����ͨ����������visited[]��que����
    private void breadthfs(int i, boolean[] visited, Queue<Integer> que)
    {
        System.out.print(this.get(i)+" ");       //���ʶ���vi
        visited[i] = true;                       //���÷��ʱ��
        que.add(i);                              //���ʹ��Ķ���vi�����ӣ��Զ�ת����Integer(i))
        ////˵��������vi����Ӿͳ��ӣ�������ʹ����ѭ�������������������Ĳ�α����㷨������Ԫ���ǽ�㣬ѭ��������p!=null
        while(!que.isEmpty())                    //�����в���ʱѭ��
        {
            System.out.println("������У�"+que.toString());                    
            i = que.poll();                      //���ӣ��Զ�ת����int;
            for(int j=next(i,-1);  j!=-1;  j=next(i,j))    //j���λ��vi�������ڽӶ������
            {
                if(!visited[j])                  //������vjδ���ʹ�������ʣ����j���
                {
                    System.out.print(this.get(j)+" ");
                    visited[j] = true;
                    ////˵������ͼ��������д��forѭ���⣬����ʶ���vi����ϲ����㷨���С�
                    ////��Ϊ����һ�˴�����Ҫ�ȷ��ʣ�����ӣ����ı�visited[]�ж�������
                    ////�������forѭ�������ʵ���vi�������ڽӶ��㣬������vi��
                    que.add(j);
                }
            }
        }
    }
    //˵���������㷨��������Ĳ�α����㷨��ͬ��
    //��1���������Ĳ�α����㷨���������ӣ������ٷ��ʡ�
    //    ��Ϊ��������û�л�·���������ཻ����ӽ��û���ظ��ģ����ԣ��������ʱ����Ҫ�ж��Ƿ���ʹ���
    //��2��ͼ�Ĺ�����ȱ����㷨�������ȷ��ʣ�����ӡ�
    //    ��Ϊ��ͼ���ڻ�·��Ϊ�˱�֤��ӽ��û���ظ��ģ����ԣ��������������δ���ʶ��㡣

    
    //��7.4   ��С������
    //Prim�㷨�������Ȩ����ͼ����С�������������С�������ĸ��߼�����
    public void minSpanTree()
    {
        Triple[] mst = new Triple[vertexCount()-1];        //��С�������ı߼��ϣ�����Ϊ������n-1
        for(int i=0;  i<mst.length;  i++)                  //�߼��ϳ�ʼ�����Ӷ���v0��������
            mst[i]=new Triple(0, i+1, this.weight(0,i+1)); //�����v0������������ı�

//        TripleComparator comp = new TripleComparator();    //��Ԫ��ıȽ�������ֵ�Ƚ�Triple�����С����5.2.2��
        for(int i=0;  i<mst.length;  i++)        //ѡ��n-1���ߣ�ÿ��ȷ��һ��Ȩֵ��С�ıߡ�һ��ѡ�������㷨
        {
            System.out.print("mst�߼��ϣ�");
            for(int j=0;  j<mst.length;  j++)
                System.out.print(mst[j].toString()+",");            
            System.out.println();            
            
            int min=i;                           //��СȨֵ�ߵ��±�
            for(int j=i+1;  j<mst.length;  j++)  //��i��n-1��Χ�ڣ�Ѱ��Ȩֵ��С�ı�
                if(mst[j].value < mst[min].value)//�����ڸ�СȨֵ�ıߣ������min����
//                if(comp.compare(mst[j], mst[min])<0)//�����ڸ�СȨֵ�ıߣ������min����
                    min = j;                     //���浱ǰȨֵ��С�ߵ����
            
            //���½�Ȩֵ��С�ıߣ���min�ǵã���������i��Ԫ�أ���ʾ�ñ߼���TE����
            Triple edge = mst[min];
            if(min!=i)
            {
                mst[min] = mst[i];
                mst[i] = edge;
            }
        
            //��i+1��n-1����������Ȩֵ��С�ı��滻
            int tv = edge.column;                //�ղ���TV�Ķ���
            for(int j=i+1;  j<mst.length;  j++)
            {
                int v = mst[j].column, w;        //v��ԭ����V-TV�е��յ�
                if((w=weight(tv,v)) < mst[j].value) //��(tv,v)�ߵ�Ȩֵw��С�����滻
                    mst[j] = new Triple(tv,v,w);
            }
        }
        
        System.out.print("\n��С�������ı߼��ϣ�");
        int mincost=0;
        for(int i=0;  i<mst.length;  i++)        //�����С�������ı߼��Ϻʹ���
        {
            System.out.print(mst[i]+" ");
            mincost += mst[i].value;
        }
        System.out.println("����С����Ϊ"+mincost);
    }
    ////˵������1��Prim�㷨����Ȩֵֻ�Ƚϴ�С��û����ӣ����ԣ�MAX_WEIGHT=Integer.MAX_VALUE
    ////��2��������mst[]���ɣ�����Ҫ��˳�����Ϊ�����㷨����һ�£����������û���������⡣

    
    //��7.5   ���·��
    //��7.5.1   �Ǹ�Ȩֵ�ĵ�Դ���·����Dijkstra�㷨��
    public void shortestPath(int i)              //���Ȩͼ�ж���vi�ĵ�Դ���·����Dijkstra�㷨
    {
        int n = this.vertexCount();              //ͼ�Ķ�����
        boolean[] S = new boolean[n];            //��������·���Ķ��㼯�ϣ�Ԫ��Ϊfalse
        S[i] = true;                             //���Դ��vi�ڼ���S�С���iԽ�磬Java�׳����Խ���쳣
        int[] path=new int[n], dist=new int[n];  //���·�����������飬Ԫ��Ϊ0
        for(int j=0; j<n; j++)                   //��ʼ��dist��path����
        {
            dist[j] = this.weight(i,j);                     //dist���·������
            path[j] = (j!=i && dist[j]<MAX_WEIGHT) ? i : -1;//path���·�����յ��ǰһ������
        }
//        System.out.print("\nvset����"+toString(vset));
//        System.out.print("\tpath����"+toString(path));
//        System.out.print("\tdist����"+toString(dist));
        
        for(int j=(i+1)%n; j!=i; j=(j+1)%n)      //Ѱ�Ҵ�vi��vj�����·����vj��V-S������
        {
            int min=0, mindist=MAX_WEIGHT, w;    //��·��������Сֵ�����±�
            for(int k=0; k<n; k++)
            {
                if(!S[k] && dist[k]<mindist)
                {
                    mindist = dist[k];           //·��������Сֵ
                    min = k;                     //·��������Сֵ�±�
                }
            }
            if(mindist==MAX_WEIGHT)              //��û���������·�����㷨������ �����Է���ͨͼ����
                break;
            S[min] = true;                       //ȷ��һ�����·�����յ�min���뼯��S
            for(int k=0; k<n; k++)               //������vi��V-S��������������·��������
            {
                if(!S[k] && (w=weight(min,k))<MAX_WEIGHT && dist[min]+w<dist[k])
                {
                    dist[k] = dist[min] + w;     //�ø���·���滻
                    path[k] = min;               //���·������min����
                }    
            }
//            System.out.print("\nvset����"+toString(vset));
//            System.out.print("\tpath����"+toString(path));
//            System.out.print("\tdist����"+toString(dist));
        }

        System.out.print(this.get(i)+"�ĵ�Դ���·����");
        for(int j=0; j<n; j++)                   //�������vi�ĵ�Դ���·��
            if(j!=i)
                System.out.print(toPath(path,i,j)+"����"+(dist[j]==MAX_WEIGHT ? "��" : dist[j])+"��");
        System.out.println();
    }
    ////˵������1��Dijkstra�㷨����Ȩֵ�����Ƚϴ�С����Ҫ��ӣ����MAX_WEIGHT=Integer.MAX_VALUE����Ӻ�Ϊ��ֵ�����ԣ����ܡ�
    ////��2��������S[]��path[]��dist[]���ɣ�����Ҫ��˳�����Ϊ�����㷨����һ�£����������û���������⡣
    
    private String toPath(int[] path, int i, int j) //����path·�������дӶ���vi��vj��һ��·���ַ���
    {
        SinglyList<T> link = new SinglyList<T>();//��������¼���·���ĸ�����
        link.insert(this.get(j));                //������������·���յ�vj
        for(int k=path[j]; k!=i && k!=j && k!=-1; k=path[k])
            link.insert(0, this.get(k));         //������ͷ���뾭���Ķ��㣬����
        link.insert(0, this.get(i));             //���·�������vi
        return link.toString();
    }
    
    private static String toString(int[] value)  //�������ֵ����ʾ�м���
    {
        if(value!=null && value.length>0)
        {
            String str="{";
            int i=0;
            for(i=0; i<value.length-1; i++)
                str += (value[i]==MAX_WEIGHT ? "��" : value[i])+",";
            return str+(value[i]==MAX_WEIGHT ? "��" : value[i])+"}";
        }
        return null;        
    }

   
    //��7.5.2   ÿ�Զ��������·����Floyd�㷨��
    //��5�棬�õ�3�����ʹ��int[][]��ʾD��P���󣬸������û�иı������������
    //��Dijkstra�㷨��toPath(path[],i,j)����
    public void shortestPath()              //���Ȩͼÿ�Զ��������·�������ȣ�Floyd�㷨
    {
        int n=this.vertexCount();                //nΪͼ�Ķ�����
        int[][] path=new int[n][n], dist=new int[n][n];    //���·�������Ⱦ���Ԫ��Ϊ0
        for(int i=0; i<n; i++)                   //��ʼ��dist��path����
        {
            for(int j=0; j<n; j++)
            {
                dist[i][j] = this.weight(i,j);   //dist��ֵ��ͼ���ڽӾ���//dist�洢ÿ�Զ��������·������
                path[i][j] = (i!=j && dist[i][j]<MAX_WEIGHT) ? i : -1; //�յ��ǰһ���������
            }
        }
        System.out.println("dist��\n"+toString(dist)+"path��\n"+toString(path)+"·������");
        printPathAll(path);

        for(int k=0; k<n; k++)                   //��vk��Ϊ����·�����м䶥��
        {
            System.out.println("\n��"+this.get(k)+"��Ϊ�м䶥�㣬�滻·�����£�");
            for(int i=0; i<n; i++)               //����ÿ�Դ�vi��vj·�������Ƿ����
                if(i!=k)
                    for(int j=0; j<n; j++)
                        if(j!=k && j!=i)
                        {
                            System.out.print(toPath(path[i],i,j)+"·������"+dist[i][j]+"���滻Ϊ"+
                            toPath(path[i],i,k)+","+toPath(path[k],k,j)+"·������"+(dist[i][k]+dist[k][j])+"��");
                            if(j!=k && j!=i && dist[i][j]>dist[i][k]+dist[k][j])//�����̣����滻
                            {
                                dist[i][j] = dist[i][k]+dist[k][j];
                                path[i][j] = path[k][j];
                                System.out.println("�ǣ�d"+i+j+"="+dist[i][j]+"��p"+i+j+"="+path[i][j]);
                            }
                            else
                                System.out.println("��");
                        }
            System.out.println("dist��\n"+toString(dist)+"path��\n"+toString(path)+"·������");
//            System.out.println("dist"+dist.toString()+"path"+path.toString()+"·������");
            printPathAll(path);
        }
    
        System.out.println("\nÿ�Զ��������·�����£�");
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
                if(i!=j)
                    //�¾���toPath(path[i],i,j)����path·�������д�vi��vj��·���ַ�������Dijkstra�㷨
                    System.out.print(toPath(path[i],i,j)+"����"+(dist[i][j]==MAX_WEIGHT ? "��" : dist[i][j])+"��");
            System.out.println();
        }
    }
    ////˵������1��Floyd�㷨����Ȩֵ�����Ƚϴ�С����Ҫ��ӣ����MAX_WEIGHT=Integer.MAX_VALUE����Ӻ�Ϊ��ֵ�����ԣ����ܡ�
    ////��2��������path[][]��dist[][]���ɣ�����Ҫ�þ�����Ϊ�����㷨����һ�£����������û���������⡣
    ////  ��Dijkstra�㷨����toPath()������
    
    private void printPathAll(int[][] path)      //���path·��������ÿ�Զ�����·���ַ���
    {
        for(int i=0; i<path.length; i++)
        {
            for(int j=0; j<path[i].length; j++)                
                System.out.print(toPath(path[i],i,j)+" ");
            System.out.println();
        }
    }
    public static String toString(int[][] value) 
    {
        String str="";
        for(int i=0; i<value.length; i++) 
        {
            for(int j=0; j<value[i].length; j++) 
                str += value[i][j]==MAX_WEIGHT ? "     ��" : String.format("%6d",value[i][j]);
            str+="\n";
        }
        return str;
    }    
}
/*
�������˵�����¡�
��1�����಻��Ҫ���¹��췽����ֻҪ�յĹ��췽�����ɣ��ɲ��붥�㷽����ɡ� 
    public AbstractGraph(int length)             //�����ͼ��������Ϊ0��lengthָ������˳�������
    {
        this.vertexlist = new SeqList<T>(length);//��������Ϊlength�Ŀ�˳���
    }
    public AbstractGraph(T[] vertexes)           //����ͼ��vertexes����ָ�����㼯��
    {
        this.vertexlist = new SeqList<T>(vertexes);//���춥��˳���
    }
//@author��Yeheya��2016-2-13

��2�� ��Ҫ��
    //Ҳ�ɣ���5��̲�ûд����Ϊ���ڳ�������û��˵�����
    //ɾ������vi�������й����ıߣ������һ�������滻����vi��
    //�Ƚ���i�������滻Ϊ���һ����n-1������ɾ�����һ�����㡣
    public void removeVertex(int i)
    {
        int n=this.vertexCount();                //ԭ������
        if (i>=0 && i<n)
        {
            T x = this.vertexlist.get(n-1);      //���һ������Ԫ��
            this.vertexlist.set(i, x);           //����i������Ԫ���滻Ϊ���һ��  
            this.vertexlist.removeAt(n-1);       //ɾ�����һ�����㣨��������1����  //˳���ɾ������iԽ�磬����null
        }
    }
    

    //7.5.2   ÿ�Զ��������·����Floyd�㷨��
    //��4��ʹ��Matrix���ʾD��P����
    public void shortestPath()                   //���Ȩͼÿ�Զ��������·�������ȣ�Floyd�㷨
    {
        int n=this.vertexCount();                          //ͼ�Ķ�����
        Matrix path=new Matrix(n), dist=new Matrix(n);     //���·�������Ⱦ��󣬳�ֵΪ0
        for (int i=0; i<n; i++)                            //��ʼ��dist��path����
            for (int j=0; j<n; j++)
            {   int w=this.weight(i,j);
                dist.set(i,j,w);                           //dist��ֵ��ͼ���ڽӾ���
                path.set(i,j, (i!=j && w<MAX_WEIGHT ? i : -1));
            }
        System.out.println("dist"+dist.toString()+"path"+path.toString()+"·������");
        printPathAll(path);

        for (int k=0; k<n; k++)                            //��vk��Ϊ����·�����м䶥��
        {
            System.out.println("\n��"+this.getVertex(k)+"��Ϊ�м䶥�㣬�滻·�����£�");
            for (int i=0; i<n; i++)                        //����ÿ�Դ�vi��vj·�������Ƿ����
                if (i!=k)
                    for (int j=0; j<n; j++)
                        if (j!=k && j!=i)
                        {
                            System.out.print(toPath(path,i,j)+"·������"+dist.get(i,j)+"���滻Ϊ"+
                            toPath(path,i,k)+","+toPath(path,k,j)+"·������"+(dist.get(i,k)+dist.get(k,j))+"��");
                            if (j!=k && j!=i && dist.get(i,j) > dist.get(i,k)+dist.get(k,j))//�����̣����滻
                            {
                                dist.set(i, j, dist.get(i,k)+dist.get(k,j));
                                path.set(i, j, path.get(k,j));
                                System.out.println("�ǣ�d"+i+j+"="+dist.get(i,j)+"��p"+i+j+"="+path.get(i,j));
                            }
                            else
                                System.out.println("��");
                        }
            System.out.println("dist"+dist.toString()+"path"+path.toString()+"·������");
            printPathAll(path);
        }
    
        System.out.println("\nÿ�Զ��������·�����£�");
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
                if (i!=j)
                    System.out.print(toPath(path,i,j)+"����"+(dist.get(i,j)==MAX_WEIGHT ? "��" : dist.get(i,j))+"��");
            System.out.println();
        }
    }
//    System.out.print(pathlink.toString()+"����"+(dist[j]==MAX_WEIGHT ? "��" : dist[j])+"��");
    
    private String toPath(Matrix path, int i, int j)       //����path·�������дӶ���vi��vj��һ��·���ַ���
    {
        SinglyList<T> link = new SinglyList<T>();          //��������¼���·���ĸ�����
        link.add(this.getVertex(j));                       //������������·���յ�vj
        for (int k=path.get(i,j); k!=i && k!=j && k!=-1;  k=path.get(i,k))
            link.add(0, this.getVertex(k));                //������ͷ���뾭���Ķ��㣬����
        link.add(0, this.getVertex(i));                    //���·�������vi
        return link.toString();
    }
    private void printPathAll(Matrix path)                 //���path·��������ÿ�Զ�����·���ַ���
    {
        for (int i=0; i<path.getRows(); i++)
        {
            for (int j=0; j<path.getRows(); j++)                
                System.out.print(toPath(path,i,j)+" ");
            System.out.println();
        }
    }


*/
//@author��Yeheya��2015��11��15�գ�2019��8��15��