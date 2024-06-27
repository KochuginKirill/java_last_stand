package Java_Junior.lesson5;

public class SendToAllRequest {
    public static final String TYPE = "sendToAllRequest";

    public String getType() {
        return TYPE;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
