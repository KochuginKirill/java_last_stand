package Java_Development_Kit.Seminar2Interfaces.circle_animation.comon;

import Java_Development_Kit.Seminar2Interfaces.circle_animation.comon.MainCanvas;

import java.awt.*;

public interface CanvasRepaintListener {
    void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime);
}
