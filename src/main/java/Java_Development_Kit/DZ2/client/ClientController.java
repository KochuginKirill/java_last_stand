package Java_Development_Kit.DZ2.client;

import Java_Development_Kit.DZ2.server.ServerClient;
import Java_Development_Kit.DZ2.server.ServerController;
import Java_Development_Kit.DZ2.server.ServerLog;

/**
 * класс содержащий логику работы клиента
 *
 * @clientView абстракция графического интерфейса
 * @server объект для связи с сервером
 */
public class ClientController implements ClientInteractions {
    private boolean connected;
    private String name;
    private ClientInteractions clientView;
    private ServerClient server;

    //сеттеры
    public void setClientView(ClientInteractions clientView) {
        this.clientView = clientView;
    }

    public void setServer(ServerClient server) {
        this.server = server;
    }


    /**
     * Метод попытки подключения к серверу. Вызывается из GUI
     * @param name имя пользователя, которым будем подписывать исходящие сообщения
     * @return ответ от сервера. true, если прошли авторизацию
     */
    public boolean connectToServer(String name) {
        this.name = name;
        if (server.connectUser(this)){
            showMessage("Вы успешно подключились!\n");
            connected = true;
            String log = server.getHistoryFromRepository();
            if (log != null){
                showMessage(log);
            }
            return true;
        } else {
            showMessage("Подключение не удалось");
            return false;
        }
    }

    /**
     * Метод отключения от сервера инициализированное сервером
     */
    public void disconnectedFromServer() {
        if (connected) {
            connected = false;
            clientView.disconnectedFromServer();
            showMessage("Вы были отключены от сервера!");
        }
    }

    /**
     * Метод отключения от сервера инициализированное клиентом (например закрыто GUI)
     */
    public void disconnectFromServer() {
        server.disconnectUser(this);
    }

    /**
     * Метод, с помощью которого сервер передает клиенту сообщения
     * @param text текст переданный от сервера
     */
    public void answerFromServer(String text) {
        showMessage(text);
    }

    /**
     * Метод для передачи сообщения на сервер
     * @param text текст передаваемого сообщения
     */
    public void message(String text) {
        if (server.isWorking()) {
            if (!text.isEmpty()) {
                server.message(name + ": " + text);
            }
        } else {
            showMessage("Нет подключения к серверу");
        }
    }

    /**
     * Метод вывода сообщения на GUI
     * @param message текст, который требуется вывести на экран
     */
    @Override
    public void showMessage(String message) {
        clientView.showMessage(message);
    }
}
