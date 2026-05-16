
package Queue;

import Request.Request;

public class RequestQueue {

    // Node class 
    private static class Node {
        Request request;
        Node next;

        Node(Request request) {
            this.request = request;
            this.next = null;
        }
    }

    private Node front;  
    private Node rear;   
    private int size;

    public RequestQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(Request request) {
        Node newNode = new Node(request);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Request added to queue: " + request.getName() + 
                           " | Blood: " + request.getBloodGroup() + 
                           " | Urgency: " + request.getUrgency());
    }

  
    public Request dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No pending requests.");
            return null;
        }
        Request processed = front.request;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return processed;
    }

    public Request peek() {
        if (isEmpty()) return null;
        return front.request;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("No requests in queue.");
            return;
        }
        Node current = front;
        int position = 1;
        System.out.println("\n--- Current Request Queue ---");
        while (current != null) {
            System.out.println(position++ + ". " + current.request.getName() + 
                               " | Blood: " + current.request.getBloodGroup() + 
                               " | Urgency: " + current.request.getUrgency());
            current = current.next;
        }
        System.out.println("-----------------------------\n");
    }
}
