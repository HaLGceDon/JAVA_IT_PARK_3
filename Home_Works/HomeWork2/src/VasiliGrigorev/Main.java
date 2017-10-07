package VasiliGrigorev;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Введите число");
	int sum = scanner.nextInt();
	int thousand = sum / 1000;
	int fivehundread = (sum - thousand * 1000) / 500;
	int onehundread = (sum - thousand * 1000 - fivehundread * 500) / 100;
	int fifty = (sum - thousand * 1000 - fivehundread * 500 - onehundread * 100) / 50;
	int ten = (sum - thousand * 1000 - fivehundread * 500 - onehundread * 100 - fifty * 50) / 10;
	int five = (sum - thousand * 1000 - fivehundread * 500 - onehundread * 100 - fifty * 50 - ten * 10) / 5;
	int two = (sum - thousand * 1000 - fivehundread * 500 - onehundread * 100 - fifty * 50 - ten * 10 - five * 5) / 2;
	int one =  (sum - thousand * 1000 - fivehundread * 500 - onehundread * 100 - fifty * 50 - ten * 10 - five * 5 - two * 2) / 1;
	System.out.println("1000 - " + thousand + " 500 - " + fivehundread + " 100 - " + onehundread + " 50 - " + fifty + " 10 - " + ten + " 5 - " + five + " 2 - " + two + " 1 - " + one);


    }
}
