
public class assignment_6_9 {
    public static void main(String[] args) {

		System.out.println("Feet\tMeters\t|\tMeters\tFeet");
        System.out.println("---------------------------------------");

        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%.3f\t|\t%.3f\t%.3f\n", i + 1, footToMeter(i + 1), i * 5.0 + 20.0, meterToFoot(i * 5.0 + 20.0));
        }
        
    }

    /** Convert from feet to meters */
    public static double footToMeter(double foot) {
        return foot * 0.305;
    }

    /** Convert from meters to feet */
    public static double meterToFoot(double meter) {
    return meter / 0.305;
    }
    
}
