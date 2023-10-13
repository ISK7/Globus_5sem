package kiselev.task;

public class Queue<T> {
    Element<T> first;
    Element<T> last;
    private int size;

    public Queue() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T t) {
        Element<T> e = new Element<T>(first);
        while(e.next != null && !e.value.equals(t)) {
            e = e.next;
        }
        return e.value.equals(t);
    }
    public void add(T t) {
        Element<T> nel = new Element<>(t);
        if(size == 0) {
            first = nel;
            last = nel;
        }
        else {
            last.next = nel;
            last = nel;
        }
        size++;
    }
    public boolean addAfter(T iter,T t) {
        Element<T> e = new Element<T>(first);
        while(e.next != null && !e.value.equals(iter)) {
            e = e.next;
        }
        if (!e.value.equals(iter)) return false;
        Element<T> nn = null;
        if(e.next != null) {
            nn = e.next;
        }
        Element<T> nex = new Element<>(t);
        nex.next = nn;
        e.next = nex;
        size++;
        return true;
    }
    public T getFirst() {
        return first.value;
    }
    public T getLast() {
        return last.value;
    }
    public T popFirst() {
        Element<T> res = first;
        size--;
        Element<T> nfirst = first.next;
        first = nfirst;
        return res.value;
    }
}
class Element<T> {
    T value;
    Element<T> next;

    Element(T val) {
        value = val;
    }
    Element(Element<T> el) {
        value = el.value;
        next = el.next;
    }

    void add(Element<T> e) {
        next = e;
    }
}
