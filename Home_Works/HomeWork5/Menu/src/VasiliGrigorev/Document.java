package VasiliGrigorev;

public class Document {

    int count = 0;
    String lines[] = new String[3];

    void showDocument() {
        for (int i = 0; i < lines.length; i++) {
            String lineToOut = lines[i] == null ? "_______" : lines[i];
            System.out.println(i + ": " + lineToOut);
        }
    }

    void addLineToBegin(String newLine) {
        for (int i = count; i > 0; i--) {
            lines[i] = lines[i - 1];
        }
        lines[0] = newLine;
        count++;
    }

    void addLineToEnd(String newLine) {
        lines[count] = newLine;
        count++;
    }

    void delLine(int lineToDel) {

        for (int i = 0; i < lines.length - lineToDel - 1; i++) {
            lines[lineToDel + i] = lines[lineToDel + i + 1];
        }
        lines[lines.length - 1] = null;
        count--;
    }

    void removeLine(int reLine, String newLine) {
        lines[reLine] = newLine;
    }

    void  clearRow(int lineToClear){
        lines[lineToClear] = null;
        count--;
    }
}