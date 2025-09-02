
import java.util.Scanner;

public class assignment_8_29 {
    
    /** Ask the user to enter 2 arrays and check if they are 3x3 */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a 3x3 arrays: ");
        String array1 = input.nextLine();

        System.out.print("Enter a 3x3 arrays: ");
        String array2 = input.nextLine();

        if (is3x3(array1) && is3x3(array2)) {
            if (equals(toArray(array1), toArray(array2))) {
                System.out.println("The two arrays are strictly identical");
            }
            else {
                System.out.println("The two arrays are not strictly identical");
            }
        }
        else {
            System.out.println("You did not enter a 3x3 array");
        }

        input.close();
    }

    /** Check to make sure they input a 3x3 array */
    public static Boolean is3x3(String number) {
        String[] numbers = String.valueOf(number).split(" ");

        if (numbers.length != 9) {
            return false;
        }

        return true;
    }

    /** Convert the long into an array */
    public static int[][] toArray(String number) {
        int[][] array = new int[3][3];

        String[] numbers = String.valueOf(number).split(" ");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = Integer.parseInt(numbers[i * 3 + j]);
            }
        }
        return array;
    }

    /** Check if the two arrays are strictly identical */
    public static boolean equals(int[][] a1, int[][] a2) {
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[i].length; j++) {
                if (a1[i][j] != a2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
