import Queue.RequestQueue;
import Request.Request;
import Donor.Location;

// Inside main():

RequestQueue emergencyQueue = new RequestQueue();


emergencyQueue.enqueue(new Request("Patient Ali", "O+", 
    new Location("CMH", "Cantt", "Lahore", "Pakistan"), "03001234567", "High"));

emergencyQueue.enqueue(new Request("Patient Sara", "B+", 
    new Location("Services Hospital", "Gulberg", "Lahore", "Pakistan"), "03009876543", "Medium"));

emergencyQueue.enqueue(new Request("Patient Hamza", "A+", 
    new Location("Jinnah Hospital", "Johar Town", "Lahore", "Pakistan"), "03331234567", "Critical"));


emergencyQueue.displayQueue();

// Process requests one by one
System.out.println("\n--- Processing Requests ---");
while (!emergencyQueue.isEmpty()) {
    Request current = emergencyQueue.dequeue();
    System.out.println("Now handling: " + current.getName() + 
                       " needs " + current.getBloodGroup());
    //  call for  matching logic (arham bahi)
}
