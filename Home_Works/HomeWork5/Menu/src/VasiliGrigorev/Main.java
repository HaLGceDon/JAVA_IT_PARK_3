package VasiliGrigorev;

        import java.io.IOException;
        import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Document documents[] = new Document[3];
        Document[] document = new Document[3];
        while (true) {
            Menu.showMenu();
            int command = scanner.nextInt();
            switch (command) {
                case 3: {
                    System.out.println("Ведите номер документа");
                    int numberOfDocument = scanner.nextInt();
                    Submenu.subDocument(documents[numberOfDocument]);

                }

                case 2: {
                    Documents.newDocuments(documents, document);
                }
                break;
                case 6:
                    System.exit(0);
            }
        }
    }
}