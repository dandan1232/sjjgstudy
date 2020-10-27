//�����ݽṹ���㷨��Java�棩����5�棩�������ߣ�Ҷ���ǣ�2019��7��1��
//��2.3 ���Ա����ʽ�洢��ʵ��
//��2.3.2  ������
//3. ��ͷ���ĵ�������
//��10.2.2  �ṩ����������

// �������࣬T��ʾ����Ԫ�ص��������ͣ�Ĭ�ϼ̳�Object��
////ʵ��List<T>�ӿڣ�ֻ��Ϊ�˲��ԡ��̲Ĳ�ʵ��List<T>�ӿڣ�������βָ��
public class SinglyList<T> extends Object //implements List<T>
                //implements java.lang.Iterable<T>    //10.2.2��ʵ�ֿɵ����ӿ�
//public class SinglyList<T> extends MyAbstractList<T>//�������࣬�̳г����б���//��10�£�10.2 ʵ�ֵ����� 
{
    public Node<T> head;                         // ͷָ�룬ָ�������ͷ���
    //ע�⣬head����������Ȩ�ޣ���Ϊ7.2.2�ڣ�ͼ���ڽӱ��У�ɾ������Ҫ������2014��8��3��
    
    //��1�����췽��
    public SinglyList()                          //���췽��������յ�����
    {
        this.head = new Node<T>();               //����ͷ��㣬data��nextֵ��Ϊnull
    }
    
    //���쵥����β����values����Ԫ�أ��������пն��󡣵�����Ԫ�ش���������Ԫ�ش�����ͬ��O(n)
    public SinglyList(T[] values)
    {
        this();                                  //�����յ�����ֻ��ͷ���
        Node<T> rear = this.head;                //rearָ���������һ�����
        for(int i=0; i<values.length; i++)       //��values.length==0�����������
        {
        	if(values[i]!=null)
            {
                rear.next = new Node<T>(values[i], null);  //β���룬�����������rear���֮��
                rear = rear.next;                //rearָ���µ���β���
            }
        }
    }

    //��2���пա���ȡԪ�ء��󳤶ȡ����������ַ����ȷ���
    public boolean isEmpty()                     //�ж��Ƿ�գ�O(1)
    {
        return this.head.next==null;
    }

    public T get(int i)                          //���ص�i��Ԫ�أ�0��i<�������ȡ���iԽ�磬�򷵻�null��O(n)
    {
        Node<T> p=this.head.next;
        for(int j=0;  p!=null && j<i;  j++)      //����������Ѱ�ҵ�i����㣨pָ��
            p = p.next;
        return (i>=0 && p!=null) ? p.data : null;//��pָ���i����㣬�򷵻���Ԫ��ֵ
    }
   
    //���õ�i��Ԫ��Ϊx��0��i<����������x!=null��
    //��x==null���׳��ն����쳣����i���Խ�磬�׳����Խ���쳣��O(n)////û�з���ֵ
    public void set(int i, T x)
    {
        if(x==null)
            throw new NullPointerException("x==null");     //�׳��ն����쳣
        else
        {
            Node<T> p=this.head.next;
            for(int j=0;  p!=null && j<i;  j++)  //����Ѱ�ҵ�i����㣨pָ��
               p = p.next;
            if(i>=0 && p!=null)
               p.data = x;                       //pָ���i�����
            else throw new IndexOutOfBoundsException(i+"");//�׳����Խ���쳣
        }
    }
    
    //��������Ԫ�ص������ַ�������ʽΪ��(,)��������Object���toString()������O(n)
    public String toString()
    {
        String str="(";
//        String str=this.getClass().getName()+"(";//��������
        for(Node<T> p=this.head.next;  p!=null;  p=p.next) //p����������
        {
//            str += p.data.toString();
//            if(p.next!=null) 
//                str += ","; 
            str += p.data.toString()+(p.next!=null?",":"");//�������һ�����ʱ���ӡ�,���ָ���
        }
        return str+")";                          //�ձ���()
    }
    
    public int size()                            //���ص������ȣ�O(n)
    {
        int i=0; 
        for(Node<T> p=this.head.next;  p!=null;  p=p.next) //p����������
            i++;
        return i;
    }
    
    //��3������
    //����x��Ϊ��i��Ԫ�أ�x!=null�����ز����㡣��i�ݴ���i<0����ͷ���룻��i>���ȣ���β���롣O(n)
    public Node<T> insert(int i, T x)
    {
        if(x==null)
            return null;               ////û�в����㡣����һ��ִ�н�������Ǵ��󣬲��׳��쳣
        Node<T> front=this.head;                 //frontָ��ͷ���
        for(int j=0;  front.next!=null && j<i;  j++)  //Ѱ�ҵ�i-1�������һ����㣨frontָ��
            front = front.next;
        front.next = new Node<T>(x, front.next); //��front֮�����ֵΪx��㣬����ͷ���롢�м�/β����
        return front.next;
    }
    public Node<T> insert(T x)                   //������β����x��O(n)������
    {
        //����insert(i,x)�����������ֵָ����������󣬱���һ�Σ�i�����ݴ�
        return insert(Integer.MAX_VALUE, x);     //Integer.MAX_VALUE��0x7fffffff�����������ֵ
   //   return insert(this.size(), x);           //��������������Σ�Ч�ʽϵ�
    }
    //�δ��õ��˷���ֵ����8�¡���8.2��  ʹ��ɢ�б��ʾԪ�ػ���ļ��ϡ�
    
//    public void insert(SinglyList<T> list){}
    //��˵���������������ء���Ȼ�����ò���Ϊnullʱ�������б���ͬ����������������ԣ�����������ȷ��ִ�����ط����е���һ����

    
    //��4��ɾ��
    public T remove(int i)         //ɾ����i��Ԫ�أ�0��i<�������ȣ����ر�ɾ��Ԫ�ء���iԽ�磬�򷵻�null��O(n)
    {
        Node<T> front=this.head;                 //frontָ��ͷ���
        for(int j=0;  front.next!=null && j<i;  j++)//����Ѱ�ҵ�i-1��㣨frontָ��
            front = front.next;
        if(i>=0 && front.next!=null)             //��front�ĺ�̽����ڣ���ɾ��֮
        {
            T x = front.next.data;               //��ô�ɾ��������õĶ���
            //ɾ��front�ĺ�̽�㣬����ͷɾ�����м�/βɾ������Java������Ժ��ͷŽ��ռ�ô洢��Ԫ
            front.next = front.next.next;
            return x;
        }
        return null;                             //��i<0��i>�����򷵻�null
//        throw new IndexOutOfBoundsException(i+"");       //�׳����Խ���쳣
    }

    public void clear()                          //ɾ�����������н��
    {
        this.head.next = null;                   //Java�Զ��ջ����н��ռ�õĴ洢�ռ�
    }

    //��5�����ң�ɢ�б���
    //���ܼ������������׸���key���Ԫ�ؽ�㣬�����Ҳ��ɹ�����null
    //�����������keyΪ�ն���Java���׳��ն����쳣
    //�㷨��Ч�ʣ�˳����ң�O(n)
    //����7.2.2��ͼ���ڽӱ����뷵�ؽ�㣬��ΪҪ���̽�㡣2014��8��6�գ�������Ӱ��δ�޸�

    //��5��˳����Һͻ��ڲ����㷨�Ĳ�����������ʡ��
    //8.3 ɢ�м����ã�
    public Node<T> search(T key)                 //˳����Ҳ������׸���key���Ԫ�ؽ�㣬�����Ҳ��ɹ����򷵻�null
    {
//        System.out.print(this.getClass().getName()+".search("+key+")��");
        for(Node<T> p=this.head.next;  p!=null;  p=p.next)
        {
//          System.out.print(p.data.toString()+"��");
            if(key.equals(p.data))              //ִ��T���equals(Object)����������ʱ��̬
              return p;
        }
        return null;
    }

    //˳����Ҳ�ɾ���׸���key���Ԫ�ؽ�㣬���ر�ɾ��Ԫ�أ������Ҳ��ɹ����򷵻�null
    public T remove(T key)
    {
        //����forѭ����p����������frontָ��p��ǰ����㣩��˳�������key���Ԫ�ؽ��
        for(Node<T> front=this.head, p=front.next; p!=null; front=p, p=p.next)
        {
            if(key.equals(p.data))               //�����ҳɹ�
            {
                front.next = p.next;             //ɾ��front�ĺ�̣�p��㣩������ͷɾ�����м�/βɾ��
                return p.data;
            }
        }
        return null;
    }
    //����ʵ��ADT List����2��  
    
    //4.  �����������Ч�ʷ���
    //5.  �������Ӧ��
    //����2.2���������ϣ�ʹ�õ�����
    //����2.3�����Josephus�����⣬ʹ�õ�����
    //��ʵ����2-2����������ת��
    
    //6. �������ǳ���������
    //��˼����2-5��
    //����    public SinglyList(SinglyList<? extends T> list)   //������췽�������Ƶ�����list�����н��
   //�൱��Node<? extends T>����Node<?>
    
    public SinglyList(SinglyList<T> list)        //������췽�������Ƶ�����list�����н��
    {
        this();                                  //�����յ�����ֻ��ͷ���
        this.copy(list);
    }
    public void copy(SinglyList<T> list)         // ����list����Ԫ�ص�this������thisԭ��㡣O(n)
    {
    	this.clear();                            //����thisΪ�յ�������this.head.next = null;
    	Node<T> rear=this.head;
        for(Node<T> p=list.head.next; p!=null; p=p.next) //p����list������
        {
            rear.next = new Node<T>(p.data, null);//���ƽ��β���뵽this�������������ã�û�и���
            rear = rear.next;                    //ָ��this������β
        }
    }
    
    public boolean equals(Object obj)            //�Ƚ�this��obj���õ������������Ƿ���ȣ�����Object���equals(obj)����
    {
        System.out.print(this.getClass().getName()+".equals("+obj.getClass().getName()+")��");
        if(this==obj)
            return true;
        if(obj instanceof SinglyList<?>)
        {
            Node<T> p=this.head.next;
            Node<T> q=((SinglyList<T>)obj).head.next;
            while(p!=null && q!=null && p.data.equals(q.data))
            {
                p=p.next;
                q=q.next;
            }
            return p==null && q==null;
        }
        return false;
    }   
    
    //7.  ������ļ��ϲ�����
    //��˼����2-6����������������㡣    
    //���ϲ���this+=list����this������list�����н�㣻����list�գ�O(n)
    public void concat(SinglyList<T> list)
    {
        Node<T> rear=this.head;
        while(rear.next!=null)                   //rear����this�������ҵ����һ�����
            rear = rear.next;
        rear.next = list.head.next;              //��rear���֮������list���׸�Ԫ�ؽ��
        list.head.next = null;                   //����list�գ������߼����޸���list���õĵ�����
    }

    //���ϲ���this+=list����this�����������list�����ı�list
    public void addAll(SinglyList<T> list)
    {
        this.concat(new SinglyList<T>(list));    //�����������list�������Ӹ��Ƶ�list
    }

    //���·��ز�����this+list���������طֱ���this��list�������ӵĵ�����this��list����
    public SinglyList<T> union(SinglyList<T> list)
    {
        SinglyList<T> result = new SinglyList<T>(this);    //���this������
        result.addAll(list);
        return result;                           //����result���õĵ������ͷ�result����
    }
    //˵����ֻ�ܷ���SinglyList<T>�����ܷ�������ʵ����������븲�ǡ�
   
   
    //��10��
    //��10.2.2   �ṩ�������������
    //2.  ���������ṩ������
    public java.util.Iterator<T> iterator()      //���ص���������ʵ��Iterable<T>�ɵ����ӿ�
    {
        return new SinglyIterator();
    }

    private class SinglyIterator implements java.util.Iterator<T> //˽���ڲ��࣬ʵ�ֵ������ӿ�
    {
        Node<T> current=SinglyList.this.head;    //��ǰ��㣬��ֵΪ�ⲿ�൥����ͷ���
        Node<T> front=null;                      //��ǰ����ǰ�����

        public boolean hasNext()                 //���к��Ԫ�أ�����true
        {
            return this.current!=null && this.current.next!=null;
        }

        public T next()                          //���غ��Ԫ��
        {
            if(this.hasNext())
            {
                this.front = this.current;
                this.current = this.current.next;
                return this.current.data;
            }
            else
                throw new java.util.NoSuchElementException();  //�׳��޴�Ԫ���쳣
        }

        public void remove()                     //ɾ�������������ʾ�ļ��ϵ�ǰԪ��
        {
            if(this.front!=null)
            {
                this.front.next = this.current.next; //ɾ����ǰ���
                this.current = this.front;
                this.front=null;                     //���ò�������ɾ���ı��
            }
            else
                throw new java.lang.IllegalStateException();//�׳���Ч״̬�쳣
//            throw new UnsupportedOperationException();     //��֧�ָò������׳��쳣
        }
    }//�ڲ������
    //��˼����10-2��
}
/*
//2015��10��4�ոĽ�������rearβָ�룬ʹβ����ΪO(1)��
ʹ�ã���2.2 �������ϣ���4.3 �����ã�
     4.2.2 ��ʽ���У�
     5.2.2 �����еĵ�����
     8.4.1 ɢ�б�
//2019��7��1�գ�û��rearβָ�롣
 */
//@author��Yeheya��2015-10-5��2019��8��6��