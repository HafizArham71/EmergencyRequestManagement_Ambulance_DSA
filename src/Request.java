public class Request {

    // Attributes
    private String name;
    private Location location;
    private EmergencyStatus status;
    private int priority;

    // Constructor
    public Request(String name, Location location, EmergencyStatus status, int priority) {
        this.name = name;
        this.location = location;
        this.status = status;
        this.priority = priority;
    }

    // Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public EmergencyStatus getStatus() {
        return status;
    }

    public void setStatus(EmergencyStatus status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return String.format("Name: " + name + "\nLocation: " + location + "\nEmergency Status: " + status + "\nPriority: " + priority);
    }
}
