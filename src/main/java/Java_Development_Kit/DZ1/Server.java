package Java_Development_Kit.DZ1;

import java.io.*;

public class Server {
    private static final String CHAT_HISTORY = "src/main/java/Java_Development_Kit/DZ1/chat.txt";

    void saveToFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CHAT_HISTORY, true))) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    File createFile(){
        return new File(CHAT_HISTORY);
    }

    BufferedReader reader(File file) throws FileNotFoundException {
        return new BufferedReader(new FileReader(file));
    }
}
