package Java_Development_Kit.DZ2.server;

import Java_Development_Kit.DZ2.client.ClientController;
import Java_Development_Kit.DZ2.client.ClientGUI;

import java.util.List;


public class ServerController implements ServerClient {
    public static ServerLog repository;
    boolean work;

    public void setServerRepository(ServerLog repository) { this.repository = repository; }

    public boolean connectUser(ClientController clientController) {
        if (!work) {
            return false;
        }
        repository.clientList().add(clientController);
        return true;
    }

    public String getHistoryFromRepository() {
        return repository.readHistory();
    }

    @Override
    public List<ClientController> clientListFromRepository() {
        return repository.clientList();
    }

    public void disconnectUser(ClientController clientController) {
        repository.clientList().remove(clientController);
        if (clientController != null) {
            clientController.disconnectedFromServer();
        }
    }

    private void answerAll(String text) {
        for (ClientController clientController : repository.clientList()) {
            clientController.answerFromServer(text);
        }
    }

    public boolean isWorking() {
        return work;
    }

    public void turnOn() {
        work = true;
    }

    public void turnOff() {
        work = false;
    }

    public void message(String s) {
        if (!work) {
            return;
        }
        s += "";
        answerAll(s);
        repository.save(s);
    }
}


