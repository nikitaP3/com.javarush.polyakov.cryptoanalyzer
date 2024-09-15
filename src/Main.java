import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    private static final String PATH = "Enter path to file";

    private static final String KEY = "Enter key";

    private static final String WRONG_NUMBER = "Wrong number";

    public static void main(String[] args) {
        System.out.println("CryptoAnalyzer");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Menu - 1 \nEncode - 2 \nDecode - 3 \nBrute - 4 \nStatisticAnalyzer - 5 \nExit - 6");
                int indexMenu = Integer.parseInt(reader.readLine());
                String path, s;
                int key;
                switch (indexMenu) {
                    case 1:
                        break;
                    case 2:
                        System.out.println(PATH);
                        path = new FileManager().readFile(Path.of(reader.readLine()));
                        System.out.println(KEY);
                        key = Integer.parseInt(reader.readLine());
                        s = new Cipher().encrypt(path, key);
                        new FileManager().writeFile(s, Path.of("src/Files/encryptedText.txt"));
                        break;
                    case 3:
                        System.out.println(PATH);
                        path = new FileManager().readFile(Path.of(reader.readLine()));
                        System.out.println(KEY);
                        key = Integer.parseInt(reader.readLine());
                        s = new Cipher().decrypt(path, key);
                        new FileManager().writeFile(s, Path.of("src/Files/decryptedText.txt"));
                        break;
                    case 4:
                        System.out.println(PATH);
                        path = new FileManager().readFile(Path.of(reader.readLine()));
                        s = new BruteForce().decryptByBruteForce(path);
                        new FileManager().writeFile(s, Path.of("src/Files/decryptedByBruteForceText.txt"));
                        break;
                    case 5:
                        System.out.println(PATH);
                        path = new FileManager().readFile(Path.of(reader.readLine()));
                        s = new StatisticalAnalyzer().decrypt(path);
                        new FileManager().writeFile(s, Path.of("src/Files/decryptedByStatisticAnalyzerText.txt"));
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println(WRONG_NUMBER);
                }
            }
        } catch (IOException e) {
            System.out.println("Input / Output error" + e.getMessage());
        }
    }
}