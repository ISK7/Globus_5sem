package kiselev.task;

public class Stack<T> {
    private final static int default_size = 10;
    private int size;
    private Object[] arr;
    private int iterator;

    public Stack (int i) {
        arr = new Object[i];
        size = i;
        iterator = -1;
    }
    public Stack () {
        this(default_size);
    }

    private void increaceSize() {
        Object[] array = new Object[arr.length * 2];
        System.arraycopy(arr, 0, array, 0,
                arr.length);
        arr = array;
        size *= 2;
    }

    public void add(T t) {
        if(iterator + 1 >= size) increaceSize();
        arr[++iterator] = t;
    }
    public T get() {
        if(iterator < 0) {throw new ArrayIndexOutOfBoundsException();}
        return (T)arr[iterator];
    }
    public T pop() {
        if(iterator < 0) throw new ArrayIndexOutOfBoundsException();
        T res = (T)arr[iterator];
        arr[iterator--] = null;
        return res;
    }
}
