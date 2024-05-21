package Java_Development_Kit.DZ1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class JChat extends JFrame {
    private static final int HEIGHT = 600;
    private static final int WIDTH = 400;
    private static final int WINDOW_POSX = 100;
    private static final int WINDOW_POSY = 100;
    private final JTextArea chatOutput = new JTextArea("");
    private final JTextField chatInput = new JTextField();
    private static final Server SERVER = new Server();

    JChat(String login) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Online chat user: " + login);
        setBounds(WINDOW_POSX, WINDOW_POSY, WIDTH, HEIGHT);
        chatOutput.setEditable(false);
        chatOutput.setBackground(Color.decode("#FFFFF0"));
        updateChat();
        JPanel grid = new JPanel(new GridLayout(3, 1));
        JPanel gridOutput = new JPanel(new GridLayout(1, 1));
        JPanel gridInput = new JPanel(new GridLayout(2, 1));
        JPanel gridButtons = new JPanel(new GridLayout(2, 2));
        gridOutput.add(chatOutput);
        JLabel EnterLabel = new JLabel("Enter your message ");
        gridInput.add(EnterLabel);
        gridInput.add(chatInput);
        JLabel sendLabel = new JLabel("Send your message");
        gridButtons.add(sendLabel);
        JLabel updateLabel = new JLabel("Update to load new messages");
        gridButtons.add(updateLabel);
        JButton buttonSend = new JButton("Send");
        gridButtons.add(buttonSend);
        buttonSend.addActionListener(e -> sendMessage(login));
        JButton buttonUpdate = new JButton("Update");
        gridButtons.add(buttonUpdate);
        buttonUpdate.addActionListener(e -> updateChat());
        chatInput.setBackground(Color.decode("#FFFFF0"));
        chatInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage(login);
                }
            }
        });
        grid.add(gridOutput);
        grid.add(gridInput);
        grid.add(gridButtons);
        add(grid);
        setVisible(true);
    }

    private void sendMessage(String login) {
        String message = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss"))
                + " " + login + " : " + chatInput.getText() + "\n";
        chatOutput.append(message);
        save(message);
        chatInput.setText("");
    }

    private void save(String message) {
        SERVER.saveToFile(message);
    }

    private void updateChat() {
        chatOutput.setText("");
        File file = SERVER.createFile();
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    chatOutput.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
