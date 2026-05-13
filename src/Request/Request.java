package Request;

import Donor.Location;

public class Request {

    // Attribute
    private String name;
    private String bloodGroup;
    private Location location;
    private String phoneNumber;
    private String urgency;

    // Constructor
    public Request(String name, String bloodGroup, Location location, String phoneNumber, String urgency) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.urgency = urgency;
    }

    // Methods
    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
