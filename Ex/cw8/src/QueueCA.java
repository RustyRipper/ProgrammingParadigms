//Maciej Makara
//zadanie 1
import java.util.ArrayList;
import java.util.List;

public class QueueCA<E> implements MyQueue<E> {
    private int f;
    private int r;
    private final List<E> array;

    public QueueCA(int n) {
        f = 0;
        r = 0;
        array = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            array.add(null);
        }
    }

    @Override
    public void enqueue(E x) throws FullException {
        if (isFull())
            throw new FullException("full queue");
        else {
            array.set(r, x);
            r = (r + 1) % array.size();
        }
    }

    @Override
    public void dequeue() {
        if (!isEmpty())
            f = (f + 1) % array.size();
    }

    @Override
    public E first() throws EmptyException {
        if (isEmpty())
            throw new EmptyException("empty queue");
        else
            return array.get(f);
    }

    @Override
    public boolean isEmpty() {
        return f == r;
    }

    @Override
    public boolean isFull() {
        return (r + 1) % array.size() == f;
    }
}
