import java.util.Arrays;
import java.util.List;


public class Cipher {
    static final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');

    public String encrypt(String text, int shift) {
        if (shift < 0)
            return "WRONG_KEY";
        int key = shift % ALPHABET.size();// получение ключа
        boolean isSymbolUp = false;
        StringBuilder encodedText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (Character.isUpperCase(symbol)) {
                symbol = Character.toLowerCase(symbol);
                isSymbolUp = true;
            }
            if (ALPHABET.contains(symbol)) {
                int oldIndex = ALPHABET.indexOf(symbol);
                int newIndex = oldIndex + key;
                if (newIndex >= ALPHABET.size()) {
                    newIndex -= ALPHABET.size();
                }
                char newSymbol = ALPHABET.get(newIndex);
                if (isSymbolUp) {
                    encodedText.append(Character.toUpperCase(newSymbol));
                    isSymbolUp = false;
                    continue;
                }
                encodedText.append(newSymbol);
                continue;
            }
            encodedText.append(symbol);
        }
        return encodedText.toString();
    }

    public String decrypt(String encryptedText, int shift) {
        if (shift < 0)
            return "Wrong key";
        int key = shift % ALPHABET.size(); // получение ключа
        boolean isSymbolUp = false;
        StringBuilder decodedText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char symbol = encryptedText.charAt(i);
            if (Character.isUpperCase(symbol)) {
                symbol = Character.toLowerCase(symbol);
                isSymbolUp = true;
            }
            if (ALPHABET.contains(symbol)) {
                int oldIndex = ALPHABET.indexOf(symbol);
                int newIndex = oldIndex - key;
                if (newIndex < 0) {
                    newIndex += ALPHABET.size(); // сделать круг по алфавиту
                }
                char newSymbol = ALPHABET.get(newIndex);
                if (isSymbolUp) {
                    decodedText.append(Character.toUpperCase(newSymbol));
                    isSymbolUp = false;
                    continue;
                }
                decodedText.append(newSymbol);
                continue;
            }
            decodedText.append(symbol);
        }
        return decodedText.toString();
    }
}