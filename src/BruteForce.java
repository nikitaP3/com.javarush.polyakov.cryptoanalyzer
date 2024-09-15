import java.util.Scanner;

public class BruteForce {
    public String decryptByBruteForce(String encryptedText) {
        int key = 0;
        Scanner scanner = new Scanner(encryptedText);
        Scanner scannerAnswer = new Scanner(System.in);
        String line = scanner.nextLine(), decryptedText;
        Cipher cipher = new Cipher();
        while (true) {
            System.out.println(cipher.decrypt(line, key));
            System.out.println("a meaningful expression? / 1 - \"yes\", 2 - \"no\""); // осмысленно?
            int answer = Integer.parseInt(scannerAnswer.nextLine());
            if (answer == 1) {
                decryptedText = cipher.decrypt(encryptedText, key);
                break;
            } else if (answer == 2) {
                key++;
            }
        }
        return decryptedText;
    }
}
