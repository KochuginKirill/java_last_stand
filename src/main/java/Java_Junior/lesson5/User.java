package Java_Junior.lesson5;

public class User {

  public User(String login) {
    setLogin(login);
  }

  private String login;
  // еще поля, описывающие юзера

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }
}
