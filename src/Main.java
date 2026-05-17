import Donor.Donor;
import Donor.Location;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {

    static void main(String[] args) {
        Random random = new Random();
        List<Donor> uniqueDonors = new ArrayList<>();

        String[] names = {"Urram Shahzad", "Salman Ahmad", "Khuram Arif", "Mirza Shehzad", "Mian Rizwan Ul Haq", "Kunwar Naveed", "Zohaib", "M Harris Omer", "Zaheer", "Haroon Azam", "Ayaz Abdullah", "Jawad Masood Chohan", "Usman", "Bilal Ramzan", "Iftikhar", "Muhammad Hafeez", "Abbas Haider Zaidi", "Mohammed Ejaz", "Sabir Hussain", "Mohammad Adnan", "Basharat Ali", "Mohammad Kashif", "Zahid Javed", "Waqar Hassan", "Mohammad Shafiq", "Saqib Sarwar", "M Adnan Seyal", "Imran Malik", "Muhammad Umar", "Usman", "M Nawaz Awan", "Hafiz Asim", "Tahir Naveed", "Mohammad Imran", "Mohammad Anas Rafiq", "Mohammad Rafiq", "Usama Usman", "Waqas Sarwer", "Mumtaz Ahmad Malik", "Kamran Jahangir Malik", "Qamar Shahzad", "Ehtesham Ulhaq", "Ghulam Mohyuddin", "M Amir Hanif", "Ahmad", "Babar Khursheed", "Tauseef Masood", "Hamid Khan", "Kashif Altaf", "Adnan", "Muhammad Usman", "Tayyab Ashaq", "Sajid", "Imran", "Sami Ullah", "Kazim Shah", "Fazal-Ur-Rehman", "Azeem Aziz", "Ibrahim", "Asad Mustafa", "Faizan ul Hassan", "Fiaz Ahmad Kashif", "Shuaib M Shahzad", "Abdul Jabbar", "Mohammad Farhan", "Mohammad Nadeem Akhtar", "Malik Ehsan Ellahi", "Innayat Ullah Khan Niazi", "Fawad Rashid", "Imran Haider", "Mohammad Kashif", "Umer Farooq", "Munir Ahmad", "Hassan Bin Ghafoor", "Khuram Shahzad", "Nadeem Akram", "Ali Raza", "Mamud Rasheed", "Asad", "Abdur Rehman Khan", "Munir Ahmad", "Majid Mustafa", "Ahmad Ali", "Shamshad Ali", "Ramiz", "Ahmad", "Shrafat", "Sajid Ali", "Hassan", "Zohaib Asif", "Asim Hafeez", "Muhammad Baqar", "M Mutahir Saddam", "Adeel Ghaffar", "Rizwan Shahzad", "Mudassar Sarfraz", "Mobashar Hussain", "Usama Tabish", "Ramiz", "M Usman Farrukh", "Osama", "Mr Dastgir", "Ghulam Murtaza Ansari", "Atif Aziz", "Qaiser Abbas", "Ghulam Abbas", "Basharat Ali", "Haris Ameer", "Mirza Hasham Zia Baig", "Mohammad Najib Subhani", "Nadir Hasan", "Sh Awais", "Arslan Bashir", "M Zain Usman", "Hassan", "Muhammad Bazan", "Abdul Mannan", "Ahmed", "Hafiz Umar Nisar", "M Usman Hameed", "Farhan", "Kamran John", "S Asim Zubair", "Mohammad Farooq", "Ch Naeem", "Rana Imran"};

        String[] bloodTypes = {"A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A+", "A-", "A-", "A-", "A-", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B+", "B-", "B-", "B-", "B-", "B-", "AB+", "AB+", "AB+", "AB+", "AB+", "AB+", "AB+", "AB+", "AB+", "AB+", "AB+", "AB+", "AB+", "AB+", "AB+", "AB+", "AB-", "AB-", "O+", "O+", "O+", "O+", "O+", "O+", "O+", "O+", "O+", "O+", "O+", "O+", "O+", "O+", "O+", "O+", "O+", "O+", "O+", "O+", "O+", "O+", "O-", "O-", "O-", "O-"

        };

        String[] areas = {"Model Town", "Gulberg", "DHA Phase 5", "Johar Town", "Bahria Town"};

        String[] phones = {"3334059959", "3334132749", "3454222415", "3334235142", "3214689585", "3224428692", "3334550884", "3224287688", "3074538028", "3454186727", "3344349509", "3224035601", "322435528", "3018494600", "3455544617", "3334061188", "3214281680", "3214051985", "3214242541", "3238650589", "3434388598", "3324363544", "3454634583", "3336389006", "3136507032", "3334482509", "3005027124", "3454599995", "3137281122", "3454286264", "3334363051", "3314181744", "3008002622", "3218880679", "3324861690", "3469720524", "3336871501", "3136957261", "3009465496", "3004557893", "3004994065", "3335765774", "3224054204", "3338924189", "3004188817", "3334829932", "3218755196", "3004201169", "3214352062", "3224436200", "3234683787", "3224887879", "3238823987", "3034634007", "3214465909", "3469556174", "3009404250", "3444554912", "3218827579", "3334663303", "3008165997", "3334914118", "3216408889", "3067614886", "3214119941", "3477454899", "3025326925", "3349742947", "3134828120", "3214247205", "3004075481", "3337846446", "3467812330", "3219344441", "3214706997", "3004446101", "3004624606", "3224865184", "3004916522", "3334910494", "3476944839", "3324550225", "3224207168", "3219423212", "3234383402", "3217244778", "3444678227", "3054110421", "3334588090", "3129990888", "3214334850", "3445507028", "3444577748", "3457334979", "3006547407", "3336004023", "3244142433", "3317464963", "3234383433", "3004494434", "3314525345", "3224636590", "3349838138", "3014761634", "3026126275", "3006660982", "3347790860", "3327213353", "3324540485", "3004388508", "3068703558", "3334205916", "3006379700", "3226840398", "3324134114", "3004462689", "3224873787", "3214456070", "3004780439", "3334455211", "3124323819", "3434000146", "3228042946", "3009485173", "3014160771", "3219456806"};

        // Register
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            String bloodType = bloodTypes[i];
            String area = areas[random.nextInt(areas.length)];
            String phone = "0" + phones[i];
            int lastDaysDonation = random.nextInt(3);

            uniqueDonors.add(new Donor(name, bloodType, new Location("Stop " + (i + 1), area, "Lahore", "Pakistan"), phone, true, lastDaysDonation));
        }

        // Creating HashMap(BloodGroup, listOfMembersWithSameBloobGroup)
        HashMap<String, ArrayList<Donor>> donorHashMap = new HashMap<>();

        ArrayList<Donor> APositive = new ArrayList<>();
        ArrayList<Donor> BPositive = new ArrayList<>();
        ArrayList<Donor> OPositive = new ArrayList<>();
        ArrayList<Donor> ABPositive = new ArrayList<>();
        ArrayList<Donor> ANegative = new ArrayList<>();
        ArrayList<Donor> BNegative = new ArrayList<>();
        ArrayList<Donor> ONegative = new ArrayList<>();
        ArrayList<Donor> ABNegative = new ArrayList<>();

        for (Donor donor : uniqueDonors) {
            switch (donor.getBloodGroup()) {
                case "A+" -> APositive.add(donor);
                case "B+" -> BPositive.add(donor);
                case "O+" -> OPositive.add(donor);
                case "AB+" -> ABPositive.add(donor);
                case "A-" -> ANegative.add(donor);
                case "B-" -> BNegative.add(donor);
                case "O-" -> ONegative.add(donor);
                default -> ABNegative.add(donor);
            }
        }

        donorHashMap.put("A+", APositive);
        donorHashMap.put("B+", BPositive);
        donorHashMap.put("O+", OPositive);
        donorHashMap.put("AB+", ABPositive);
        donorHashMap.put("A-", ANegative);
        donorHashMap.put("B-", BNegative);
        donorHashMap.put("O-", ONegative);
        donorHashMap.put("AB-", ABNegative);

        // Searching
        List<Donor> opositives = donorHashMap.get("A+");

        for (Donor o : opositives)
            System.out.println(o + "\n");

        System.out.println("Total Donors: " + opositives.size());

        System.out.println(names.length);
        System.out.println(phones.length);
        System.out.println(bloodTypes.length);

    }
}
