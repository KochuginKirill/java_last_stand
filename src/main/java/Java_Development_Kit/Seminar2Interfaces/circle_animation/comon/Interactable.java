package Java_Development_Kit.Seminar2Interfaces.circle_animation.comon;

import java.awt.*;

public interface Interactable {
    void update(MainCanvas canvas, float deltaTime);
    void render(MainCanvas canvas, Graphics g);
}
