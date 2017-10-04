package VasiliGrigorev;

public class Documents {
    static int count = 0;

    void showDocuments(Document Documents[]) {
        for (int i = 0; i < Documents.length; i++) {
            String lineToOut = Documents[i] == null ? "_______" : "Документ № "+ (i + 1);
            System.out.println(i + ": " + lineToOut);
        }
    }



    static void newDocuments(Document Documents[], Document document[]) {
        for (int i = 0; i < Documents.length; i++) {
            if (Documents[i] == null && count < Documents.length) {
                document[i] = new Document();
                Documents[i] = document[i];
                count++;
                break;
            }
            if (count >= Documents.length) {
                System.err.println("Нет места");
                break;
            }
        }
    }





}
