package MinHeap;

public class HeapTree {

    // Attributes
    private Node head;
    private Node tail;
    private int counter = 0;


    private Node parent;
    private Node leftNode;
    private Node rightNode;

    // Methods
    public Node addNode(Node node) {
        if(head == null) {
            head = tail = parent = node;
        } else {
            if(parent.getPrev() == null) {
                parent.setPrev(node);
                node.setNext(parent);
                leftNode = tail = node;

                Node currNode = node; // child
                while(currNode != head) {

                    // Swap if parent > child
                    if(currNode.getRequest().getPriority() < currNode.getNext().getRequest().getPriority()) {
                        Node up = currNode.getNext();
                        Node down = currNode;

                        Request tempRequest = up.getRequest();
                        up.setRequest(down.getRequest());
                        down.setRequest(tempRequest);

                    }

                    currNode = currNode.getNext();
                }
            }
            else {
                parent.setNext(node);
                node.setPrev(parent);
                rightNode = tail = node;

                Node currNode = node; // child
                while(currNode != head) {

                    // Swap if parent > child
                    if(currNode.getRequest().getPriority() < parent.getRequest().getPriority()) {
                        Node up = currNode.getPrev();
                        Node down = currNode;

                        Request tempRequest = up.getRequest();
                        up.setRequest(down.getRequest());
                        down.setRequest(tempRequest);

                    }

                    // Swap if leftChild > RightChild
                    Node parent2 = findParent(currNode, head);
                    if(parent2.getPrev().getRequest().getPriority() > parent2.getNext().getRequest().getPriority()) {
                        Node temp = parent2.getPrev();  // Left
                        parent2.setPrev(parent2.getNext()); // left = Right
                        parent2.setNext(temp); // Right = Left
                    }

                    currNode = currNode.getPrev();
                }

                parent = leftNode;
            }
        }
        counter++;
        return null;
    }

    // Depth First Search
    static Node findParent(Node node, Node target) {
        if(node == null || (node.getPrev() == target || node.getNext() == target)) {
            return node;
        } else {
            Node leftNode = findParent(node.getPrev(), target);
            Node rightNode = findParent(node.getNext(), target);
        }
        return node;
    }

}
