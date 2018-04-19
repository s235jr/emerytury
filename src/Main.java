import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {

        String filepathinput = "C:\\git\\emerytury\\emerytury.txt";

        analyzeFile(filepathinput);
    }

    static void analyzeFile(String filepath) {
        BufferedReader filereader = null;
        try {
            filereader = new BufferedReader(new FileReader(filepath));
            String read;
            while ((read = filereader.readLine()) != null) {
                saveRekord(read);
            }
        } catch (java.io.IOException e) {
            System.out.println("Nie udało się otworzyć pliku.");
        }
    }

    static void saveRekord(String read) {
        String filepathoutputM = "C:\\git\\emerytury\\m.txt";
        String filepathoutputK = "C:\\git\\emerytury\\k.txt";

        String[] arrayRead = read.split(" ");
        String filepathoutput = "";
        int retirement = 0;
        if (arrayRead[2].equals("M")) {
            filepathoutput = filepathoutputM;
            retirement = 65 - Integer.parseInt(arrayRead[3]);
        } else if (arrayRead[2].equals("K")) {
            filepathoutput = filepathoutputK;
            retirement = 60 - Integer.parseInt(arrayRead[3]);
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filepathoutput, true);
            fileWriter.write(arrayRead[1] + " " + arrayRead[0] + " " + Integer.toString(retirement) + System.lineSeparator());
            fileWriter.close();
        } catch (java.io.IOException e) {
            System.out.println("Nie udało mi się zapisać do pliku.");
        }
    }
}

