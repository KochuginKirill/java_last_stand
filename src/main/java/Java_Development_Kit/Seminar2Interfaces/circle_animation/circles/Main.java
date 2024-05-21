package Java_Development_Kit.Seminar2Interfaces.circle_animation.circles;

import Java_Development_Kit.Seminar2Interfaces.circle_animation.circles.view.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
}