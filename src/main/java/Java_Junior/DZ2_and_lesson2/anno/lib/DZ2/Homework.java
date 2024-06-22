package Java_Junior.DZ2_and_lesson2.anno.lib.DZ2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

public class Homework {

  /**
   * В существующий класс ObjectCreator добавить поддержку аннотации RandomDate (по аналогии с Random):
   * 1. Аннотация должна обрабатываться только над полями типа java.util.Date
   * 2. Проверить, что min < max
   * 3. В поле, помеченной аннотацией, нужно вставлять рандомную дату,
   * UNIX-время которой находится в диапазоне [min, max)
   *
   * 4. *** Добавить поддержку для типов Instant, ...
   * 5. *** Добавить атрибут Zone и поддержку для типов LocalDate, LocalDateTime
   */

  /**
   * Примечание:
   * Unix-время - количество милисекунд, прошедших с 1 января 1970 года по UTC-0.
   */

  // FIXME: Заставить аннотацию ставится только над полями
//  @Retention(RetentionPolicy.RUNTIME)
//  @Target(ElementType.FIELD)
//  @interface RandomDate {
//
//    long min() default 1704067200000L; // 1 января 2024 года UTC0
//
//    long max() default 1735689600000L; // 1 января 2025 года UTC0
//
////    String zone() default "Moscow";
//
//  }

  public static void main(String[] args) {
    long t = 1704067200000L;
    long min = 1704067200000L; // 1 января 2024 года UTC0
    long max = 1735689600000L;

    Date date = new Date(t);
    System.out.println(date);
    System.out.println();
    System.out.println(new Date(1704067200000L));
    System.out.println(new Date(1735689600000L));

//    LocalDate.ofInstant(date.toInstant(), ZoneOffset.of("Moscow"))
  }

}
