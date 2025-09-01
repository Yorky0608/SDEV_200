
public class assignment_6_9 {
    
    public static void main(String[] args) {

        /** Outputs: Feet    Meters  |   Meters  Feet
         * ------------------------------------------
         */
		System.out.println("Feet\tMeters\t|\tMeters\tFeet");
        System.out.println("---------------------------------------");

        /** For loop to print the conversion table */
        for (int i = 1; i < 11; i++) {
            System.out.printf("%d\t%.3f\t|\t%.3f\t%.3f\n", i, footToMeter(i + 1), i * 5.0 + 20.0, meterToFoot(i * 5.0 + 20.0));
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
