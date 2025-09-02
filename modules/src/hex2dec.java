import java.util.Scanner;

public class hex2dec {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String hexa = input.nextLine();

        int deci = hex2deca(hexa);

        System.out.print(deci);

        input.close();
    }

    public static int hex2deca(String hex) {
        int decicaml_value = 0;
        for (int i = 0; i < hex.length(); i++) {
            decicaml_value = i;
        }
        return decicaml_value;
    }
}