/**
 * Exam 1 problem part 2:
 * Create a "Queue" class that uses a linked list with a "first in first out" rule,
 * similar to "Stack".
 *
 * @author Riley Simmons
 *
 * @param <T>
 */
public class Queue<T>
{

    int size = 0;
    Node<T> front;
    Node<T> rear;

    /**
     * "Queues" an object into the list by assigning it to a Node and placing it in
     * the rear of the linked list.
     * @param obj The data to be added to the queue.
     */
    void queue(T obj)
    {
        if (rear != null)
            this.rear = new Node<T>(obj, this.rear);
        else this.rear = new Node<T>(obj, null);
        if (front == null) front = rear;
        size++;
    }

    /**
     * Removes the node from the front of the queue and sets the front to the node behind
     * it, and returns the data from the removed node.
     *
     * @return The data from the node at the front of the queue.
     */
    T deQueue()
    {
        if (front != null)
        {
            T data =  front.getData();
            Node<T> current = rear;
            for (int i = 0; i < size; i++)
            {
                if (current.getLink().getLink() == null)
                {
                    current.setLink(null);
                    front = current;
                    size--;
                }
                current = current.getLink();
            }
            return data;
        }
        return null;
    }

    /**
     * Finds the current size of the queue.
     *
     * @return The size of the queue.
     */
    int size()
    {
        return size;
    }

    /**
     * Finds and reports the data from the front of the queue.
     *
     * @return The data from the front of the queue.
     */
    T peek()
    {
        if (empty())
        {
            return null;
        }
        return front.getData();
    }

    /**
     * Checks if a specified object appears in the queue or not.
     *
     * @param obj The object to be checked against the queue.
     * @return Whether the object is in the list.
     */
    boolean contains(T obj)
    {
        Node<T> current = rear;
        for (int i = 0; i < size; i++)
        {

            if (current.getData().equals(obj))
            {
                return true;
            }

            current = current.getLink();
        }
        return false;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return Whether the queue is empty.
     */
    boolean empty()
    {
        return size == 0;
    }

    /**
     * Removes all nodes from the linked list queue.
     */
    void clear()
    {
        front = null;
        rear = null;
    }
}
