package Java_Development_Kit.DZ1;

import javax.swing.*;
import java.awt.*;


public class ChatWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_POSX = 600;
    private static final int WINDOW_POSY = 200;
    private final JTextField loginField = new JTextField();

    ChatWindow() {
        setTitle("Запускаем чат");
        setBounds(WINDOW_POSX, WINDOW_POSY, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(9, 1));
        JLabel loginPanel = new JLabel("Login: ");
        panel.add(loginPanel, BorderLayout.CENTER);
        panel.add(loginField, BorderLayout.CENTER);
        loginField.setBackground(Color.decode("#FFFFF0"));

        JLabel passwordPanel = new JLabel("Password ");
        JTextField passwordField = new JTextField();
        passwordField.setBackground(Color.decode("#FFFFF0"));
        panel.add(passwordPanel, BorderLayout.CENTER);
        panel.add(passwordField, BorderLayout.CENTER);

        JLabel ipPanel = new JLabel("Server ip ");
        JTextField ipField = new JTextField();
        panel.add(ipPanel, BorderLayout.CENTER);
        panel.add(ipField, BorderLayout.CENTER);
        ipField.setBackground(Color.decode("#FFFFF0"));

        JLabel portLabel = new JLabel("Port: ");
        JTextField portField = new JTextField();
        portField.setBackground(Color.decode("#FFFFF0"));
        panel.add(portLabel, BorderLayout.CENTER);
        panel.add(portField, BorderLayout.CENTER);

        JButton btnLogin = new JButton("Connect to server");
        panel.add(btnLogin, BorderLayout.AFTER_LINE_ENDS);
        add(panel);
        btnLogin.addActionListener(e -> {
            String login = loginField.getText().trim();
            new JChat(login);
        });
        setVisible(true);
    }
}
