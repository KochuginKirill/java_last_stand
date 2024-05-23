package Java_Development_Kit.DZ2.server;

import Java_Development_Kit.DZ2.client.ClientController;

import java.util.List;

public interface ServerLog {

    List<ClientController> clientList();
    String readHistory();
    void save(String text);
}
