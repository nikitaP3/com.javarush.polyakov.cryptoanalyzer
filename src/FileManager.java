import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public String readFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                sb.append(reader.readLine());
                sb.append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            System.out.println("Что-то не так" + e);
        }
        return "";
    }
    public void writeFile(String content, Path path) {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Что-то не так" + e);
        }
    }
}
