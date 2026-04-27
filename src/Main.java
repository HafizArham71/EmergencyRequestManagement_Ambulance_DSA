import MinHeap.HeapTree;
import MinHeap.Node;
import Requests.EmergencyStatus;
import Requests.Location;
import Requests.Request;

public class Main {

    public static int heartAttack = 1;
    public static int Accident = 2;
    public static int injury = 3;
    public static int fever = 4;

    static void main(String[] args) {

        HeapTree heapTree = new HeapTree();

        Request r1 = new Request("Rahul1", new Location("College Stop", "Shalimar Garden", "Lahore", "Pakistan"), EmergencyStatus.FEVER);
        Request r2 = new Request("Rahul2", new Location("College Stop", "Shalimar Garden", "Lahore", "Pakistan"), EmergencyStatus.HEART_ATTACK);
        Request r3 = new Request("Rahul3", new Location("College Stop", "Shalimar Garden", "Lahore", "Pakistan"), EmergencyStatus.HEART_ATTACK);
        Request r4 = new Request("Rahul4", new Location("College Stop", "Shalimar Garden", "Lahore", "Pakistan"), EmergencyStatus.INJURY);
        Request r5 = new Request("Rahul5", new Location("College Stop", "Shalimar Garden", "Lahore", "Pakistan"), EmergencyStatus.ACCIDENT);
        Request r6 = new Request("Rahul6", new Location("College Stop", "Shalimar Garden", "Lahore", "Pakistan"), EmergencyStatus.FEVER);

        Node n1 = new Node(r1);
        Node n2 = new Node(r2);
        Node n3 = new Node(r3);
        Node n4 = new Node(r4);
        Node n5 = new Node(r5);
        Node n6 = new Node(r6);

        heapTree.addNode(n1);
        heapTree.addNode(n2);
        heapTree.addNode(n3);
        heapTree.addNode(n4);
        heapTree.addNode(n5);
        heapTree.addNode(n6);


    }
}
