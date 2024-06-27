package Java_Junior.lesson5;

/**
 * {
 *   "type": "users"
 * }
 */
public class ListRequest extends AbstractRequest {

  public static final String TYPE = "list";

  public String getType() {
    return TYPE;
  }

  private String recipient;

  public String getRecipient() {
    return recipient;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }



}
