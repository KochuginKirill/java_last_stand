package Java_Development_Kit.Lecture1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WINDTH = 350;

    private int currentSize = 5;


    private JPanel gameModePanel(){
        Label label = new Label("Выберите режим игры");
        JRadioButton radioButton1 = new JRadioButton("Человек против компьютера");
        JRadioButton radioButton2 = new JRadioButton("Человек против человека");
        JPanel panel = new JPanel(new GridLayout(3, 1));
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        panel.add(label);
        panel.add(radioButton1);
        panel.add(radioButton2);
        return panel;
    }

    private JPanel fieldSizeSliderPanel(){

        JSlider slider = new JSlider(3,10,5);
        Label fieldSizeLabel = new Label("Установленный размер поля: " + currentSize);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentSize = slider.getValue();
                fieldSizeLabel.setText("Установленный размер поля: " + currentSize);
            }
        });
        Label choiceOfSize = new Label("Выберите размер поля");
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(choiceOfSize);
        panel.add(fieldSizeLabel);
        panel.add(slider);
        return panel;
    }

    private JPanel winCountForVictoryPanel(){
        Label winSize = new Label("Выберите длину для победы");
        Label currentLength = new Label("Установленная длина: " + currentSize);
        JSlider slider = new JSlider(3,10,5);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                currentSize = slider.getValue();
                currentLength.setText("Установленная длина: " + currentSize);
            }
        });
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(winSize);
        panel.add(currentLength);
        panel.add(slider);
        return panel;
    }



    JButton btnStart = new JButton("Start new game");
    SettingWindow(GameWindow gameWindow) {
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WINDTH, WINDOW_HEIGHT);
        JPanel panel = new JPanel(new GridLayout(3,1));
        panel.add(gameModePanel());
        panel.add(fieldSizeSliderPanel());
        panel.add(winCountForVictoryPanel());
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(0, 3, 3, 3);
                setVisible(false);
            }
        });
        add(panel);
        add(btnStart, BorderLayout.SOUTH);
    }

}
