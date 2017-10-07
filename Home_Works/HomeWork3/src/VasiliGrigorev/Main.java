
package VasiliGrigorev;

import java.util.Scanner;

public class Main {


    // Первая и вторая задачи
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = scanner.nextInt();
        int array[] = new int[arraySize];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        int summaChetnyh = 0;
        int summaNechetnyh = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                summaChetnyh = summaChetnyh + array[i];
            } else summaNechetnyh = summaNechetnyh + array[i];

        }
        System.out.println("Сумма четных " + summaChetnyh + " Сумма нечетных " + summaNechetnyh);

        // Третья и четвертая задачи
        int summaChetPosition = 0;
        int summaNeChetPosition = 0;
        for (int i = 0; i < array.length; i++) {
            if ((i + 1) % 2 == 0) {
                summaChetPosition = summaChetPosition + array[i];
            } else summaNeChetPosition = summaNeChetPosition + array[i];
        }
        System.out.println("Сумма элементов, стоящих на четной позиции " + summaChetPosition + " Сумма элементов, стоящих на нечетной позиции " + summaNeChetPosition);

        // Пятая задача
        int k = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1]) {
                if (array[i] > array[i + 1]) {
                    k = k + 1;
                }
            }
        }
        System.out.println("Количество локальных максимумов " + k);


        // Шестая задача
        for (int i = 0; i < array.length; i++) {
            if (array[i + 1] > array[i]) {
                System.out.print(array[i] + " ");
            }
        }


    }
}