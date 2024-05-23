package Java_Development_Kit.DZ2.server;

import javax.swing.*;
import java.awt.*;

//класс требуется разделить на GUI, controller и repository (смотри схему проекта)
public class ServerGUI extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    JButton btnStart, btnStop;
    JTextArea chatHistoryArea;
    private ServerClient serverClient;

    public void setServerClient(ServerClient serverClient) { this.serverClient = serverClient; }

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
                while (!serverClient.clientListFromRepository().isEmpty()){
                    serverClient.disconnectUser(serverClient.clientListFromRepository().get(serverClient.clientListFromRepository().size()-1));
                }
                appendLog("Сервер остановлен!");
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }
}
