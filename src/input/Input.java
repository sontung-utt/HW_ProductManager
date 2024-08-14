package input;

import java.util.Scanner;

public class Input {
    private static Scanner input = new Scanner(System.in);
    public static int inputInteger(){
        do {
            try {
                String data = input.nextLine();
                int number = Integer.parseInt(data);
                return number;
            } catch (NumberFormatException e) {
                System.out.print("Yêu cầu nhập số nguyên: ");
            }
        } while (true);
    }

    public static double inputDouble(){
        do {
            try {
                String data = input.nextLine();
                double number = Double.parseDouble(data);
                return number;
            } catch (NumberFormatException e){
                System.out.print("Yêu cầu nhập số thực: ");
            }
        } while (true);
    }

    public static String inputString(){
        String str = input.nextLine();
        return str;
    }
}
