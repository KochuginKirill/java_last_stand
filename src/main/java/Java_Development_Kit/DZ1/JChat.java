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
    private static final String CHAT_HISTORY = "chat.txt";
    private final JTextArea chatOutput = new JTextArea("");
    private final JTextField chatInput = new JTextField();

    JChat(String login) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Online chat");
        setBounds(WINDOW_POSX, WINDOW_POSY, WIDTH, HEIGHT);
        chatOutput.setEditable(false);
        chatOutput.setBackground(Color.decode("#FFFFF0"));
        update();
        JPanel grid = new JPanel(new GridLayout(5, 1));
        grid.add(chatOutput);
        JLabel label = new JLabel("Enter your message ");
        grid.add(label);
        grid.add(chatInput);
        JButton buttonConnect = new JButton("Send");
        grid.add(buttonConnect);
        buttonConnect.addActionListener(e -> sendMessage(login));
        JButton buttonUpdate = new JButton("Update");
        grid.add(buttonUpdate);
        buttonUpdate.addActionListener(e -> update());
        chatInput.setBackground(Color.decode("#FFFFF0"));
        chatInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage(login);
                }
            }
        });

        add(grid);
        setVisible(true);
    }

    private void sendMessage(String login) {
        String message = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss"))
                + " " + login + " : " + chatInput.getText() + "\n";
        chatOutput.append(message);
        saveMessageToFile(message);
        chatInput.setText("");
    }

    private void saveMessageToFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CHAT_HISTORY, true))) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        File file = new File(CHAT_HISTORY);
        chatOutput.setText("");
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
