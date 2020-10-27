/**
 * @author Flobby
 * @version :1.0
 * @date :2020/10/9
 * @ClassName :顺序表类
 */

public class SeqList<T> {

    protected Object[] elements;
    protected int n;
    private static final int MIN = 16;

    public SeqList(int length){
        if (length < MIN){
            length = MIN;
        }
        this.elements = new Object[length];
        this.n = 0;
    }
    public SeqList(){
        this(MIN);
    }
    public SeqList(T[] values){
        this(values.length*2);
        for (int i = 0; i<values.length; i++){
            if (values[i] == null){
                this.elements[this.n++] = values[i];
            }
        }
    }

    public SeqList(SeqList<? extends T> list) {
        this.elements = new Object[list.elements.length];
        for (int i = 0; i < list.n; i++){
            this.elements[i] = list.elements[i];
        }
        this.n = list.n;
    }

    public boolean isEmpty(){
        return this.n == 0;
    }
    public int size(){
        return this.n;
    }

    public T get(int i){
        if (i >= 0 && i < this.n){
            return (T)this.elements[i];
        }
        return null;
    }

    public void set(int i,T x){
        if (x == null){
            throw new NullPointerException("x == null");
        }
        if (i >= 0 && i < this.n){
            this.elements[i] = x;
        }else {
            throw new IndexOutOfBoundsException(i+"");
        }
    }

    @Override
    public String toString(){
        String str = this.getClass().getName()+"(";
        if (this.n > 0){
            str += this.elements[0].toString();
        }
        for (int i = 1; i < this.n; i++){
            str += ","+this.elements[i].toString();
        }
        return str + ")";
    }

    public String toPreviousString(){
        return null;
    }

    public int insert(int i,T x){
        if (x==null){
            return -1;
        }
        if (i < 0){
            i = 0;
        }
        if (i > this.n){
            i = this.n;
        }
        Object[] source = this.elements;
        if (this.n == elements.length){
            this.elements = new Object[source.length*2];
            for (int j = 0; j < 1; j++){
                this.elements[j] = source[j];
            }
        }
        for (int j = this.n-1; j >= i; j--){
            this.elements[j+1] = source[j];
        }
        this.elements[i] = x;
        this.n++;
        return i;
    }

    public int insert(T x){
        return this.insert(this.n,x);
    }

    public T remove(int i){
        if (i >= 0 && i < this.n){
            T x = (T)this.elements[i];
            for (int j = 1; j < this.n-1; j++){
                this.elements[j] = this.elements[j+1];
            }
            this.elements[this.n-1] = null;
            this.n--;
            return x;
        }
        return null;
    }

    public void clear(){
        this.n = 0;
    }
}
