package Java_Junior.lesson4.hw;

import Java_Junior.lesson4.entity.Author;
import Java_Junior.lesson4.entity.AuthorBook;
import Java_Junior.lesson4.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Homework {

  /**
   * Используя hibernate, создать таблицы:
   * 1. Post (публикация) (id, title)
   * 2. PostComment (комментарий к публикации) (id, text, post_id)
   *
   * Написать стандартные CRUD-методы: создание, загрузка, удаление.
   *
   * Доп. задания:
   * 1. * В сущностях post и postComment добавить поля timestamp с датами.
   * 2. * Создать таблицу users(id, name) и в сущностях post и postComment добавить ссылку на юзера.
   * 3. * Реализовать методы:
   * 3.1 Загрузить все комментарии публикации
   * 3.2 Загрузить все публикации по идентификатору юзера
   * 3.3 ** Загрузить все комментарии по идентификатору юзера
   * 3.4 **** По идентификатору юзера загрузить юзеров, под чьими публикациями он оставлял комменты.
   * // userId -> List<User>
   *
   *
   * Замечание:
   * 1. Можно использовать ЛЮБУЮ базу данных (например, h2)
   * 2. Если запутаетесь, приходите в группу в телеграме или пишите мне @inchestnov в личку.
   */
  public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.configure();
    try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
      // sessionFactory <-> connection
      withSession(sessionFactory);
//      withSessionCRUD(sessionFactory);
    }
  }

  private static void withSession(SessionFactory sessionFactory) {
    try (Session session = sessionFactory.openSession()) {
      Post post = new Post();
      post.setId(1L);
      post.setTitle("Post");

      PostComment postComment1 = new PostComment();
      postComment1.setId(1L);
      postComment1.setTitle("postComment1");
      postComment1.setPost_id(post);

//      PostComment postComment2 = new PostComment();
//      postComment2.setId(1L);
//      postComment2.setTitle("postComment2");
//      postComment2.setPost_id(post);

      Transaction tx = session.beginTransaction();
      session.persist(post);
      session.persist(postComment1);
//      session.persist(postComment2);
      tx.commit();
      if (true) {
        throw new RuntimeException();
      }
    }
  }

  private static void withSessionCRUD(SessionFactory sessionFactory) {
    try (Session session = sessionFactory.openSession()) {
      // session <-> statement

      Post post = session.find(Post.class, 1L);
      System.out.println("Post(1) = " + post);
    }

    try (Session session = sessionFactory.openSession()) {
      Transaction tx = session.beginTransaction();
      Post post = new Post();
      post.setId(22L);
      post.setTitle("Post #1");

      session.persist(post); // insert
      tx.commit();
    }

    try (Session session = sessionFactory.openSession()) {
      Post toUpdate = session.find(Post.class, 1L);
      session.detach(toUpdate);
      toUpdate.setTitle("UPDATED");

      Transaction tx = session.beginTransaction();
//      session.merge(toUpdate); // update
      tx.commit();
    }

    try (Session session = sessionFactory.openSession()) {
      Post toDelete = session.find(Post.class, 1L);

      Transaction tx = session.beginTransaction();
      session.remove(toDelete); // delete
      tx.commit();
    }
}
}
