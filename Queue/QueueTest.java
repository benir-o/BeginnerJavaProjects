package BeginnerJavaProjects.Queue;
/**
 * Used to test the methods and constructors of the Queue class.
 *
 * @author Riley Simmons
 */
public class QueueTest
{
    public static void main(String[] args)
    {
        Queue<Double> q = new Queue<Double>();

        System.out.println("Current size: " + q.size());
        System.out.println(q.peek());
        System.out.println(q.deQueue());
        System.out.println("Adding doubles... (1.2, 4.3, and 3.14)");
        q.queue(1.2);
        q.queue(4.3);
        q.queue(3.14);
        System.out.println("Current size: " + q.size());
        System.out.println("Front of queue (peek): " + q.peek());
        System.out.println("Front of queue (deQueue): " +  q.deQueue());
        System.out.println("Front of queue (peek): " + q.peek());
        System.out.println("Size: " + q.size());
        System.out.println("Empty: " + q.empty());
        System.out.println("Contains 4.3? " + q.contains(4.3));
        System.out.println("Contains 4.5? " + q.contains(4.5));
        q.clear();
    }
}
