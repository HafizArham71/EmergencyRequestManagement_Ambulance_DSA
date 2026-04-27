public class Main {

    public static int heartAttack = 1;
    public static int Accident = 2;
    public static int injury = 3;
    public static int fever = 4;

    static void main(String[] args) {

        Request r1 = new Request("Rahul1", new Location("College Stop", "Shalimar Garden", "Lahore", "Pakistan"), EmergencyStatus.FEVER);

        Request r2 = new Request("Rahul2", new Location("College Stop", "Shalimar Garden", "Lahore", "Pakistan"), EmergencyStatus.FEVER);

        Request r3 = new Request("Rahul3", new Location("College Stop", "Shalimar Garden", "Lahore", "Pakistan"), EmergencyStatus.FEVER);

        Request r4 = new Request("Rahul4", new Location("College Stop", "Shalimar Garden", "Lahore", "Pakistan"), EmergencyStatus.FEVER);

        Request r5 = new Request("Rahul5", new Location("College Stop", "Shalimar Garden", "Lahore", "Pakistan"), EmergencyStatus.FEVER);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);
    }

    static int generatePriority(EmergencyStatus status) {
        if(status == EmergencyStatus.HEART_ATTACK) {
            if(heartAttack == 0 || )
                heartAttack++;
            else if
        }

    }
}
