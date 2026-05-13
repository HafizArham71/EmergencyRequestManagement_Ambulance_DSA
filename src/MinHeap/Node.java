package MinHeap;

public class Node {

    // Attributes
    private Node prev;
    private int data;
    private Node next;

    // Constructor
    public Node(int data) {
        this.data = data;
    }

    // Methods
    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
