package data.Gen;
import data.Gen.GenLList;
//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��12��29��
//��5.3   �����
//��5.3.2   �����Ĵ洢�ṹ��ʵ��
//3. �������

//������࣬��������ʹ��ͷ����data��洢�������ɲ��빲���ӱ����ܹ��칲���ӱ����ǵݹ��
public class GenList<T> implements GenLList<T>
{
    public GenNode<T> head;                      //ͷָ�룬ָ��ͷ���

    public GenList()                             //����չ��������Ϊnull
    {
        this.head = new GenNode<T>(null, null, null);      //����ͷ���
        ////this(null);   //�﷨������������������֮�����������
    }
    public GenList(T data)                       //����չ����dataָ������
    {
        this.head = new GenNode<T>(data, null, null);      //ͷ����data��洢����
    }
    
    //��������dataָ��������atoms[]ָ��ԭ�ӳ�ֵ������������Ա��㷨ͬ������
    ////������������Ԫ�ش�����ͬ������β���빹��
    public GenList(T data, T[] atoms)
    {
        this(data);                              //�����չ����ֻ��ͷ���
        GenNode<T> rear=this.head;
        for(int i=0; i<atoms.length; i++)
        {
            rear.next=new GenNode<T>(atoms[i], null, null);  //β����
            rear = rear.next; 
        }
    }

    public boolean isEmpty()                     //�ж��Ƿ�ձ����շ���true
    {
        return this.head.child==null && this.head.next==null;
    }
    
    public T getName()                           //���ر���
    {
    	return this.head.data;
    }
    
    //���ص�i��Ԫ�ؽ�㣬0��i<���ȡ���iԽ�磬����null��O(n)��////�㷨ͬ������
    public GenNode<T> get(int i)
    {
        GenNode<T> p=this.head.next;
        for(int j=0;  p!=null && j<i;  j++)      //������Ѱ�ҵ�i����㣨pָ��
            p = p.next;
        return (i>=0 && p!=null) ? p : null;     //���ص�i�����
    }

    public String toString()                     //����this�����������ַ���
    {
        return this.toString(this);
    }
    public String toString(GenList<T> genlist)   //����genlist�����������ַ����������㷨����ӵݹ鷽��
    {
        String str=(genlist.head.data==null?"":genlist.head.data.toString())+"("; //��/������
        for(GenNode<T> p=genlist.head.next;  p!=null;  p=p.next)//����genlist����������ǵݹ��
            str += toString(p)+(p.next!=null?",":""); //���÷���p���
        return str+")";                          //�ձ���()
    }
    public String toString(GenNode<T> p)         //����p���Ĺ�����ַ�������ӵݹ鷽��
    {
        if(p==null) 
            return null;
        return  p.child==null ? p.data.toString() : toString(p.child);//�����ӱ��ݹ����p.child�ӱ�
    }

	public int size()                            //���ع�����ȣ�////�㷨ͬ������
    {
        int i=0; 
        for(GenNode<T> p=this.head.next;  p!=null;  p=p.next)
            i++;
        return i;
    }
    
    public int depth()                           //���ع������ȣ��ݹ鷽��
    {
        int max=1;
        for(GenNode<T> p=this.head.next;  p!=null;  p=p.next)
            if(p.child!=null)
            {
                int d=p.child.depth();           //�ݹ���ã������ӱ����
                if(max<=d)                       //��ס����ӱ����
                    max=d+1;                     //��ǰ��������Ϊ�ӱ���ȼ�1
            }
        return max;
    }
    
    //����ԭ��x��Ϊ��i��Ԫ�أ�x!=null�����ز����ԭ�ӽ�㡣
    //��i�ݴ���i<0��ͷ���룻��i>���ȣ�β���롣�㷨ͬ������O(n)
    public GenNode<T> insert(int i, T x)
    {
        if(x==null)
            return null;               ////û�в����㡣����һ��ִ�н�������Ǵ��󣬲��׳��쳣
        GenNode<T> front=this.head;                        //frontָ��ͷ���
        for(int j=0;  front.next!=null && j<i;  j++)       //Ѱ�ҵ�i-1�������һ����㣨frontָ��
            front = front.next; 
        front.next = new GenNode<T>(x, null, front.next);  //��front֮�����ֵΪx���
        return front.next;                                 //���ز����ԭ�ӽ��
    }
    public GenNode<T> insert(T x)                          //β����ԭ��x��㣬////�㷨ͬ������
    {
        return insert(Integer.MAX_VALUE, x);
    }

    //�����ӱ�glist��Ϊ��i��Ԫ�أ�genlist!=null�����ز�����ӱ��㡣
    //�ڲ�����ӱ����У�datad�洢genlist�ӱ������child����genlist�ӱ����
    //��genlist��this�е��ӱ���genlist��Ϊ�����ӱ�genlist!=this����ʹthis��Ϊ�ݹ��
    ////�㷨ͬ��������������ӱ���
    public GenNode<T> insert(int i, GenList<T> genlist)
    {
        if(genlist==null || this==genlist)                 //��������
            return null;
        GenNode<T> front=this.head;                        //frontָ��ͷ���
        for(int j=0;  front.next!=null && j<i;  j++)       //Ѱ�ҵ�i-1�������һ����㣨frontָ��
            front = front.next; 
        //�¾���front֮������ӱ��㣬�б�����childָ�����ã�genlist�ӱ��ɹ���
        front.next = new GenNode<T>(genlist.head.data, genlist, front.next);
        return front.next;                                 //���ز�����ӱ���
    }
    public GenNode<T> insert(GenList<T> genlist)           //β����genlist�ӱ�
    {
        return insert(Integer.MAX_VALUE, genlist);
    }
    
    //ɾ�������ص�i��Ԫ�ؽ�㣬0��i<���ȣ���i��Ч����ɾ��������null���㷨ͬ������O(n)
    public GenNode<T> remove(int i)
    {
    	GenNode<T> front = this.head, p=null;    //frontָ��ͷ���
        for(int j=0;  front.next!=null && j<i;  j++)//����Ѱ�ҵ�i-1��㣨frontָ��
            front = front.next;
        if(i>=0 && front.next!=null)             //��front�ĺ�̽����ڣ���ɾ��֮
        {
            p = front.next;
            front.next = front.next.next;        //ɾ��front�ĺ�̽�㣬����ͷɾ�����м�/βɾ��
        }
        return p;
    }
    ////���ܷ��ر�ɾ��Ԫ��T�����������������ӱ�
    
    public void clear()                          //ɾ������Ԫ�أ�û��ɾ��ͷ���ͱ���
    {
        this.head.child=null;
        this.head.next=null;
    }
    
    //����ADTд������ԭ��Ԫ���㷨���ݹ�����㷨
    public GenNode<T> search(T key)              //���Ҳ������׸���key���Ԫ�ؽ��
    {
        return null;
    }
    public GenNode<T> remove(T key)              //���ҡ�ɾ���������׸���key���Ԫ�ؽ��
    {
        return null;
    }
    //����ADTûд��
    void removeAll(T key){}               	 //??���Ҳ�ɾ��������key���ԭ�ӽ��

    //���¡�ʵ����5-3���γ�����⡿
    //�㷨��ȷ���������ӱ��Ƴɶ���
    public GenList(GenList<T> genlist)           //�������췽������������ƹ����
    {
        this(genlist.head.data);    	         //����ձ�ͷ����data��洢����
        GenNode<T> rear = this.head;
        for(GenNode<T> p=genlist.head.next;  p!=null; p=p.next)//����genlist�����
        {
            rear.next = new GenNode<T>(p.data, null, null); //����ԭ��/�ӱ��㣬�ӱ���p.data==null
            rear = rear.next; 
            if(p.child!=null)
            	rear.child = new GenList<T>(p.child);      //�����ӱ��ݹ���ã�������
        }
    }
    
    public boolean equals(Object obj)  //�Ƚ�����������Ƿ���ȣ�����Object���equals(obj)����
    {
        if(obj == this)
            return true;
        if(obj instanceof GenList<?>)
            return equals(this, (GenList<T>)obj);
        return false;
    }    
    public boolean equals(GenList<T> genlist1, GenList<T> genlist2)
    {
    	if(genlist1==null && genlist2==null)
            return true;
        if(genlist1!=null && genlist2!=null)
        {
            GenNode<T> p = genlist1.head.next;
            GenNode<T> q = genlist2.head.next;
            while(p!=null && q!=null && p.data.equals(q.data) && equals(p.child, q.child))//�ݹ���ã�
            {
                p=p.next;
                q=q.next;
            }
            return p==null && q==null;
    	}
        return false;
    }
    
    //���²����ӱ��㷨���ݹ�����㷨
    //�����׸���pattern��ȵ��ӱ������ӱ���
    public GenNode<T> search(GenList<T> pattern)
    {
        return null;
    }
    //���Ҳ�ɾ���׸���pattern��ȵ��ӱ����ر�ɾ�����ӱ���
    public GenNode<T> remove(GenList<T> pattern)
    {
        return null;
    }
    
    public void removeAll(GenList<T> pattern)    //���Ҳ�ɾ��������pattern��ȵ��ӱ�
    {}

    //����������pattern��ȵ��ӱ��������滻�����ã�Ϊgenlist�ӱ�
    public void replaceAll(GenList<T> pattern, GenList<T> genlist)
    {}
}
/*
//�������˵�����¡�
��1������û��������
    void set(int i, T x);                        //���õ�i�����Ԫ��Ϊx��0��i<����
      ��Ϊ��i�����Ԫ�ؿ�����ԭ�ӻ��ӱ����Ը�ԭ��ֵ��ǰ����Ҫ����ԭ�ӵ����ӱ�
���ܸ��ӱ�ı�������Ϊ�ӱ��һ������д�ڶദ������һ�¡�

*/
//@author��Yeheya��2014��10��6�գ�2016-1-22��2019��12��29�գ�2020��2��5��