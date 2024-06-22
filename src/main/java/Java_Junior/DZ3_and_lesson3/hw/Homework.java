package Java_Junior.DZ3_and_lesson3.hw;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Homework {

  /**
   * С помощью JDBC, выполнить следующие пункты:
   * 1. Создать таблицу Person (скопировать код с семниара)
   * 2. Создать таблицу Department (id bigint primary key, name varchar(128) not null)
   * 3. Добавить в таблицу Person поле department_id типа bigint (внешний ключ)
   * 4. Написать метод, который загружает Имя department по Идентификатору person
   * 5. * Написать метод, который загружает Map<String, String>, в которой маппинг person.name -> department.name
   *   Пример: [{"person #1", "department #1"}, {"person #2", "department #3}]
   * 6. ** Написать метод, который загружает Map<String, List<String>>, в которой маппинг department.name -> <person.name>
   *   Пример:
   *   [
   *     {"department #1", ["person #1", "person #2"]},
   *     {"department #2", ["person #3", "person #4"]}
   *   ]
   *
   *  7. *** Создать классы-обертки над таблицами, и в пунктах 4, 5, 6 возвращать объекты.
   */

  /**
   * Пункт 4
   */
  public static String getPersonDepartmentName(Connection connection, long personId) throws SQLException {
    // FIXME: Ваш код тут
    try (PreparedStatement statement =
                 connection.prepareStatement("select person.departmentId, department.departmentName from person join department on person.departmentId = department.id  where person.id = ?")) {
      statement.setInt(1, Integer.parseInt(String.valueOf(personId)));
      ResultSet resultSet = statement.executeQuery();

      List<String> names = new ArrayList<>();
      while (resultSet.next()) {
        names.add(resultSet.getString("department.departmentName"));
      }
      return names.toString();
    }
  }

  /**
   * Пункт 5
   */
  public static Map<String, String> getPersonDepartments(Connection connection) throws SQLException {
    // FIXME: Ваш код тут
    throw new UnsupportedOperationException();
  }

  /**
   * Пункт 6
   */
  private static Map<String, List<String>> getDepartmentPersons(Connection connection) throws SQLException {
    // FIXME: Ваш код тут
    throw new UnsupportedOperationException();
  }

}
