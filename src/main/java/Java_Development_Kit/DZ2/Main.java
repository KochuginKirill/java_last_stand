package Java_Development_Kit.DZ2;

import Java_Development_Kit.DZ2.client.ClientController;
import Java_Development_Kit.DZ2.client.ClientGUI;
import Java_Development_Kit.DZ2.server.ServerController;
import Java_Development_Kit.DZ2.server.ServerGUI;
import Java_Development_Kit.DZ2.server.ServerStorageRepository;

public class Main {
    public static void main(String[] args) {

        //создание объектов сервера и создание связи между ними
        ServerGUI serverWindow = new ServerGUI();
        ServerController serverController = new ServerController();
        ServerStorageRepository serverStorageRepository = new ServerStorageRepository();
        serverController.setServerRepository(serverStorageRepository);
        serverController.setServerView(serverWindow);
        serverWindow.setServerController(serverController);

        //создание объектов клиента1 и создание связи между ними
        ClientGUI clientGUI1 = new ClientGUI();
        ClientController clientController1 = new ClientController();
        clientController1.setClientView(clientGUI1);
        clientGUI1.setClient(clientController1);
        clientController1.setServer(serverController);

        //создание объектов клиента2 и создание связи между ними
        ClientGUI clientGUI2 = new ClientGUI();
        ClientController clientController2 = new ClientController();
        clientController2.setClientView(clientGUI2);
        clientGUI2.setClient(clientController2);
        clientController2.setServer(serverController);
    }
}