package VasiliGrigorev;

import java.io.IOException;
import java.util.Scanner;

public class Submenu {
    public static void subDocument (Document document) throws IOException {

            Scanner scanner = new Scanner(System.in);

            while (true) {
                Menu.showSubMenu();

                int command = scanner.nextInt();

                switch (command) {
                    case 1: {
                        document.showDocument();
                    }
                    break;
                    case 2: {
                        if (document.count == document.lines.length) {
                            System.err.println("Нет места");
                            break;
                        }
                        System.out.println("Введите строку: ");
                        String newLine = scanner.next();
                        document.addLineToBegin(newLine);
                    }
                    break;
                    case 3: {
                        if (document.count == document.lines.length) {
                            System.err.println("Нет места");
                            break;
                        }
                        System.out.println("Введите строку: ");
                        String newLine = scanner.next();
                        document.addLineToEnd(newLine);
                    }
                    break;
                    case 4: {
                        System.out.println("Какую строку удалить ");
                        int lineToDel = scanner.nextInt();
                        document.delLine(lineToDel);
                    }
                    case 5: {
                        System.out.println("Введите номер строки");
                        int reLine = scanner.nextInt();
                        System.out.println("Введите строку");
                        String newLine = scanner.next();
                        document.removeLine(reLine, newLine);
                    }
                    break;
                    case 6: {
                        System.out.println("Какую строку очистить ");
                        int lineToClear = scanner.nextInt();
                        document.clearRow(lineToClear);

                    }
                    break;
                    case 7:
                       return;
                }
            }

    }


}
