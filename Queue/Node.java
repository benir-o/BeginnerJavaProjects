/**
 * Generic node class used as pieces for a linked list.
 *
 * @author Riley Simmons
 *
 * @param <D>
 */
public class Node<D>
{
    private D data;
    private Node link;

    public Node(D d, Node l)
    {
        data = d;
        link = l;
    }

    public D getData() {return data;}

    public Node getLink() {return link;}

    public void setData(D d) {data = d;}
    public void setLink(Node l) {link = l;};
}
