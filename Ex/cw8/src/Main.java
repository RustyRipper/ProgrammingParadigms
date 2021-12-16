//Maciej Makara
//zadanie 1
public class Main {
    public static void main(String[] args) throws FullException, EmptyException {
        MyQueue<Integer> queue = new QueueCA<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        //queue.enqueue(4); //FullException
        System.out.println("isFull = " +queue.isFull());
        System.out.println("isEmpty = " +queue.isEmpty());

        System.out.println("First = "+ queue.first());
        queue.dequeue();
        System.out.println("First = "+ queue.first());
        queue.dequeue();
        System.out.println("First = "+ queue.first());
        queue.dequeue();
        System.out.println("isEmpty = " +queue.isEmpty());
        System.out.println("isFull = " +queue.isFull());
        //System.out.println(queue.first()); //EmptyException
        queue.enqueue(4);
        System.out.println("First = "+ queue.first());
    }
}
