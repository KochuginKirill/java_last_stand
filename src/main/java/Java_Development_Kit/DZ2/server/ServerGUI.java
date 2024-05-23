package Java_Development_Kit.DZ2.server;

import Java_Development_Kit.DZ2.client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//класс требуется разделить на GUI, controller и repository (смотри схему проекта)
public class ServerGUI extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    JButton btnStart, btnStop;
    JTextArea chatHistoryArea;
    private ServerClient serverClient;
    ServerLog repository;

    public void setServerClient(ServerClient serverClient) { this.serverClient = serverClient; }

    public void setServerRepository(ServerLog repository) { this.repository = repository; }

    public ServerGUI(){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
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
            if (serverClient.isWorking()){
                appendLog("Сервер уже был запущен");
            } else {
                serverClient.turnOn();
                appendLog("Сервер запущен!");
            }
        });

        btnStop.addActionListener(e -> {
            if (!serverClient.isWorking()){
                appendLog("Сервер уже был остановлен");
            } else {
                serverClient.turnOff();
                while (!repository.clientList().isEmpty()){
                    serverClient.disconnectUser(repository.clientList().get(repository.clientList().size()-1));
                }
                appendLog("Сервер остановлен!");
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }
}
