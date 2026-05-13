package Donor;

public class Donor {

    // Attributes
    private String id;
    private String name;
    private String bloodGroup;
    private Location location;
    private String phoneNumber;
    private boolean isAvailable;
    private int lastDonationDays;

    public static int counter = 0;

    // Constructor
    public Donor(String name, String bloodGroup, Location location, String phoneNumber, boolean isAvailable, int lastDonationDays) {
        this.id = generateId();
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.isAvailable = isAvailable;
        this.lastDonationDays = lastDonationDays;
    }

    // Methods
    public static String generateId() {
        return String.format("donor_%03d", ++counter);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getLastDonationDays() {
        return lastDonationDays;
    }

    public void setLastDonationDays(int lastDonationDays) {
        this.lastDonationDays = lastDonationDays;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Donor.counter = counter;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("ID: " + id + "\nName: " + name + "\nBloodGroup: " + bloodGroup + "\nLocation: " + location + "\nPhone Number: " + phoneNumber + "\nIsAvailable: " + isAvailable + "\nLastDonationDays: " + lastDonationDays);
    }

}
