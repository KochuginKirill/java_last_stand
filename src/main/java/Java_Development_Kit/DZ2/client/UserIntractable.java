package Java_Development_Kit.DZ2.client;

/**
 * Интерфейс описывающий абстракцию GUI
 */
public interface UserIntractable {
    /**
     * Метод для отображения сообщения в GUI
     * @param message текст сообщения
     */
    void showMessage(String message);

    /**
     * Метод отключения от сервера со стороны сервера
     */
    void disconnectedFromServer();
}