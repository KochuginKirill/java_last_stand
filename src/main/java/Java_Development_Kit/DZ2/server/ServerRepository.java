package Java_Development_Kit.DZ2.server;

import Java_Development_Kit.DZ2.client.ClientController;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ServerRepository implements ServerLog {

    List<ClientController> clients = new ArrayList<>();
    public static final String LOG_PATH =
            "src/main/java/Java_Development_Kit/DZ2/log.txt";

    @Override
    public List<ClientController> clientList() {
        return clients;
    }

    @Override
    public String readHistory() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH)){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void save(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
