import java.util.HashMap;
import java.util.Map;

public class StatisticalAnalyzer {
    public String decrypt(String encryptedText) {
        Map<Character, Integer> symbolCount = new HashMap<>();
        char[] textByChar = encryptedText.substring(0, 150).toCharArray();
        for (char symbol : textByChar) {
            if (symbolCount.containsKey(symbol)) {
                symbolCount.put(symbol, symbolCount.get(symbol) + 1);
            } else {
                symbolCount.put(symbol, 0);
            }
        }
        int maxValue = 0;
        char maxCountSymbol = ' ';
        for (Map.Entry<Character, Integer> characterIntegerEntry : symbolCount.entrySet()) {
            int value = characterIntegerEntry.getValue();
            if (value > maxValue) {
                maxValue = value;
                maxCountSymbol = characterIntegerEntry.getKey();
            }
        }
        int key = Cipher.ALPHABET.indexOf(maxCountSymbol) + 1;
        return new Cipher().decrypt(encryptedText, key);
    }
}
