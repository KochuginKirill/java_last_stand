package Java_Development_Kit.DZ2.server;

import Java_Development_Kit.DZ2.client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//класс требуется разделить на GUI, controller и repository (смотри схему проекта)
public class ServerGUI extends JFrame implements ServerView {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    List<ClientGUI> clientGUIList;

    JButton btnStart, btnStop;
    JTextArea chatHistoryArea;
    private ServerController serverController;

    public void setServerController(ServerController serverController) { this.serverController = serverController; }

    public ServerGUI(){
        clientGUIList = new ArrayList<>();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }


    public void disconnectUser(ClientGUI clientGUI){
        clientGUIList.remove(clientGUI);
        if (clientGUI != null){
            clientGUI.disconnectedFromServer();
        }
    }


    private void appendLog(String text){
        chatHistoryArea.append(text + "\n");
    }

    private void createPanel() {
        chatHistoryArea = new JTextArea();
        add(chatHistoryArea);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(e -> {
            if (serverController.isWorking()){
                appendLog("Сервер уже был запущен");
            } else {
                serverController.turnOn();
                appendLog("Сервер запущен!");
            }
        });

        btnStop.addActionListener(e -> {
            if (!serverController.isWorking()){
                appendLog("Сервер уже был остановлен");
            } else {
                serverController.turnOff();
                while (!clientGUIList.isEmpty()){
                    disconnectUser(clientGUIList.get(clientGUIList.size()-1));
                }
                appendLog("Сервер остановлен!");
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }
}
