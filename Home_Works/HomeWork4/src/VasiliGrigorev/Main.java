package VasiliGrigorev;

public class Main {


    public static int parse(char digits[]) {
        int result = 0;
        int k = 1;

        for (int i = digits.length; i > 0; i--) {
            result = result + (digits[i-1] - 48) * k;
            k = k * 10;

        }
        return result;
    }


    public static void main(String args[]) {


            char number[] = {'3', '2', '4', '1'};
            int numberAsInt = parse(number);
            System.out.println(numberAsInt);

    }
}
