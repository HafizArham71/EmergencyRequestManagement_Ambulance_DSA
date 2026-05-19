import engine.model.Donor;
import engine.model.EmergencyRequest;

public class Main {

    private static int totalTests = 0;
    private static int passedTests = 0;

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   RUNNING ENGINE MODEL DEPTH TESTS");
        System.out.println("==================================================\n");

        runDonorHappyPathTests();
        runDonorValidationTests();
        runEmergencyRequestHappyPathTests();
        runEmergencyRequestValidationTests();
        runObjectContractTests();

        System.out.println("==================================================");
        System.out.printf("   TEST SUITE EXECUTION SUMMARY: %d/%d PASSED\n", passedTests, totalTests);
        System.out.println("==================================================");
    }

    private static void runDonorHappyPathTests() {
        System.out.println("--> [TEST] Donor Happy Path & Initialization...");
        try {
            totalTests++;
            Donor donor = new Donor("D-101", "  Arham Mujahid ", Donor.BloodType.O_PLUS, "03001234567", "Node_A");

            // Verify structural trimming and storage
            assertExpectation("D-101", donor.getId(), "Donor ID storage mismatch");
            assertExpectation("Arham Mujahid", donor.getName(), "Donor name whitespace trimming failed");
            assertExpectation(Donor.BloodType.O_PLUS, donor.getBloodType(), "Blood type mapping mismatch");
            assertExpectation("03001234567", donor.getPhoneNumber(), "Phone number mapping mismatch");
            assertExpectation("Node_A", donor.getLocationNodeId(), "Location node mapping mismatch");
            assertExpectation(true, donor.isAvailable(), "Default donor availability state should be true");

            passedTests++;
            System.out.println("    [PASS] Valid donor initialized with clean states.");
        } catch (Exception e) {
            System.out.println("    [FAIL] Unexpected exception during valid donor tracking: " + e.getMessage());
        }
    }

    private static void runDonorValidationTests() {
        System.out.println("\n--> [TEST] Donor Input Boundary Validations...");

        // Test 1: Invalid Phone Number format
        try {
            totalTests++;
            new Donor("D-102", "Hamza", Donor.BloodType.B_PLUS, "12345", "Node_B");
            System.out.println("    [FAIL] System allowed an invalid phone format (12345).");
        } catch (IllegalArgumentException e) {
            passedTests++;
            System.out.println("    [PASS] Caught invalid phone string format: " + e.getMessage());
        }

        // Test 2: Blank strings
        try {
            totalTests++;
            new Donor(" ", "Rahila", Donor.BloodType.A_MINUS, "03217654321", "Node_C");
            System.out.println("    [FAIL] System allowed a blank whitespace ID.");
        } catch (IllegalArgumentException e) {
            passedTests++;
            System.out.println("    [PASS] Caught empty/blank data field violation: " + e.getMessage());
        }

        // Test 3: Null safety boundary
        try {
            totalTests++;
            new Donor("D-103", "Valid Name", null, "03331112223", "Node_D");
            System.out.println("    [FAIL] System allowed a null blood type object.");
        } catch (NullPointerException e) {
            passedTests++;
            System.out.println("    [PASS] Caught null pointer block safely: " + e.getMessage());
        }
    }

    private static void runEmergencyRequestHappyPathTests() {
        System.out.println("\n--> [TEST] Emergency Request Happy Path...");
        try {
            totalTests++;
            long preInitTime = System.currentTimeMillis();
            Thread.sleep(1); // Force minimal delay for distinct clock window

            EmergencyRequest request = new EmergencyRequest("REQ-999", "Jinnah Hospital", Donor.BloodType.AB_MINUS, "Node_H1", EmergencyRequest.UrgencyLevel.CRITICAL);

            assertExpectation("REQ-999", request.getRequestId(), "Request ID storage mismatch");
            assertExpectation("Jinnah Hospital", request.getHospitalName(), "Hospital name storage mismatch");
            assertExpectation(Donor.BloodType.AB_MINUS, request.getRequiredBloodType(), "Required blood type mismatch");
            assertExpectation("Node_H1", request.getHospitalNodeId(), "Target node mapping mismatch");
            assertExpectation(EmergencyRequest.UrgencyLevel.CRITICAL, request.getUrgency(), "Urgency mapping mismatch");

            // Verify timestamp integrity
            if (request.getTimestamp() >= preInitTime && request.getTimestamp() <= System.currentTimeMillis()) {
                passedTests++;
                System.out.println("    [PASS] Emergency request tracking records correct systemic timestamps.");
            } else {
                System.out.println("    [FAIL] System tracking timestamp is out of logical execution sync.");
            }
        } catch (Exception e) {
            System.out.println("    [FAIL] Unexpected exception during request processing: " + e.getMessage());
        }
    }

    private static void runEmergencyRequestValidationTests() {
        System.out.println("\n--> [TEST] Emergency Request Input Boundary Validations...");

        try {
            totalTests++;
            new EmergencyRequest("R-01", "", Donor.BloodType.O_MINUS, "Node_X", EmergencyRequest.UrgencyLevel.LOW);
            System.out.println("    [FAIL] System allowed an empty hospital name.");
        } catch (IllegalArgumentException e) {
            passedTests++;
            System.out.println("    [PASS] Caught empty hospital value exception validation: " + e.getMessage());
        }
    }

    private static void runObjectContractTests() {
        System.out.println("\n--> [TEST] Equality and Hashing Architecture Contracts...");
        totalTests++;

        Donor donorA = new Donor("ID-X", "Donor Alpha", Donor.BloodType.O_PLUS, "03451234567", "Node_1");
        Donor donorB = new Donor("ID-X", "Donor Beta (Different details)", Donor.BloodType.AB_PLUS, "03459999999", "Node_99");
        Donor donorC = new Donor("ID-Y", "Donor Alpha", Donor.BloodType.O_PLUS, "03451234567", "Node_1");

        // Object Equals contract: Unique ID overrides matching descriptive variants
        boolean keysMatch = donorA.equals(donorB);
        boolean keysDiffer = !donorA.equals(donorC);
        boolean hashMatches = donorA.hashCode() == donorB.hashCode();

        if (keysMatch && keysDiffer && hashMatches) {
            passedTests++;
            System.out.println("    [PASS] Identity systems rely exclusively on distinct IDs.");
        } else {
            System.out.println("    [FAIL] Object hashcode or equivalence structures are leaking detailed mutations.");
        }
    }

    // Custom lightweight assertion helper avoiding reliance on JVM '-ea' execution flags
    private static void assertExpectation(Object expected, Object actual, String failMsg) {
        if (!expected.equals(actual)) {
            throw new IllegalStateException(String.format("%s [Expected: %s, Found: %s]", failMsg, expected, actual));
        }
    }
}