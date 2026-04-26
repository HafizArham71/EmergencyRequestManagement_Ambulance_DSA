public class Main {

    public static int heartAttack = 0;
    public static int Accident = 0;
    public static int injury = 0;
    public static int fever = 0;

    static void main(String[] args) {

        Request r1 = new Request("Rahul1", new Location("College Stop", "Shalimar Garden", "Lahore", "Pakistan"), EmergencyStatus.FEVER, 1);

        Request r2 = new Request("Rahul2", new Location("College Stop", "Shalimar Garden", "Lahore", "Pakistan"), EmergencyStatus.FEVER, 1);

        Request r3 = new Request("Rahul3", new Location("College Stop", "Shalimar Garden", "Lahore", "Pakistan"), EmergencyStatus.FEVER, 1);

        Request r4 = new Request("Rahul4", new Location("College Stop", "Shalimar Garden", "Lahore", "Pakistan"), EmergencyStatus.FEVER, 1);

        Request r5 = new Request("Rahul5", new Location("College Stop", "Shalimar Garden", "Lahore", "Pakistan"), EmergencyStatus.FEVER, 1);

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
            else if (heartAttack)
        }

    }
}
