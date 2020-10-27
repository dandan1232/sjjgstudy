public class SeqList<T> extends Object {
    protected Object[] element;
    protected int n;
    private static final int MIN_CAPACITY = 16;

    public SeqList(int length) {
        if (length < MIN_CAPACITY)
            length = MIN_CAPACITY;
        this.element = new Object[length];
        this.n = 0;
    }

    public SeqList() {
        this(MIN_CAPACITY);
    }

    public SeqList(T[] values) {
        this(values.length * 2);
        for (int i = 0; i < values.length; i++)
            if (values[i] != null)
                this.element[this.n++] = values[i];
    }



    public boolean isEmpty() {
        return this.n == 0;
    }

    public int size() {
        return this.n;
    }

    public T get(int i) {
        if (i >= 0 && i < this.n)
            return (T) this.element[i];
        return null;
    }

    public void set(int i, T x) {
        if (x == null)
            throw new NullPointerException("x==null");
        if (i >= 0 && i < this.n)
            this.element[i] = x;
        else
            throw new java.lang.IndexOutOfBoundsException(i + "");
    }

    @Override
    public String toString() {
        String str = this.getClass().getName() + "(";
        if (this.n > 0)
            str += this.element[0].toString();
        for (int i = 1; i < this.n; i++)
            str += "," + this.element[i].toString();
        return str + ")";
    }

}

