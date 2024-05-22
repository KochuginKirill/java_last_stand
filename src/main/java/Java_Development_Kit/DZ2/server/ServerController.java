package Java_Development_Kit.DZ2.server;

import Java_Development_Kit.DZ2.client.ClientController;

import java.util.ArrayList;
import java.util.List;

public class ServerController {
    private ServerView serverView;
    public static ServerLog repository;
    List<ClientController> clients = new ArrayList<>();
    boolean work;

    public void setServerView(ServerView serverView) { this.serverView = serverView; }
    public void setServerRepository (ServerLog repository) { this.repository = repository; }
    public boolean connectUser(ClientController clientController) {
        if (!work){
            return false;
        }
        clients.add(clientController);
        return true;
    }

    public String getHistoryFromRepository() {
        return repository.readHistory();
    }

    public void disconnectUser(ClientController clientController) {
        clients.remove(clientController);
        if (clientController != null){
            clientController.disconnectedFromServer();
        }
    }
    private void answerAll(String text){
        for (ClientController clientController: clients){
            clientController.answerFromServer(text);
        }
    }

    public boolean isWorking() {
        return work;
    }

    public void turnOn(){
        work = true;
    }

    public void turnOff(){
        work = false;
    }

    public void message(String s) {
        if (!work){
            return;
        }
        s += "";
        //appendLog(s);
        answerAll(s);
        repository.save(s);
    }

//    private void appendLog(String s) {
//        for (ClientController client:
//             clients) {
//            client.showMessage(s);
//        }
//    }
}
