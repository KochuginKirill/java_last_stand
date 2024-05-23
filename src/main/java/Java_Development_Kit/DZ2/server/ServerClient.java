package Java_Development_Kit.DZ2.server;

import Java_Development_Kit.DZ2.client.ClientController;

import java.util.List;

public interface ServerClient {
    void disconnectUser(ClientController clientController);

    boolean isWorking();

    void turnOn();

    void turnOff();

    boolean connectUser(ClientController clientController);

    void message(String s);

    String getHistoryFromRepository();

    List<ClientController> clientListFromRepository();

}
