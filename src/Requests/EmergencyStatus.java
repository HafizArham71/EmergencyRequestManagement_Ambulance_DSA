package Requests;

public enum EmergencyStatus {

    // Attributes
    HEART_ATTACK(1),
    ACCIDENT(2),
    INJURY(3),
    FEVER(4);
    private final int weight;

    // Constructor
    EmergencyStatus(int weight) {
        this.weight = weight;
    }

    // Methods
    public int getWeight() {
        return weight;
    }

}
