package Java_Junior.DZ2_and_lesson2.anno.lib;

import Java_Junior.DZ2_and_lesson2.anno.lib.DZ2.Homework;

import java.lang.reflect.Field;
import java.util.Date;

public class RandomAnnotationProcessor {

  public static void processAnnotation(Object obj) {
    // найти все поля класса, над которыми стоит аннотация @Random
    // вставить туда рандомное число в диапазоне [0, 100)

    java.util.Random random = new java.util.Random();
    Class<?> objClass = obj.getClass();
    for (Field field : objClass.getDeclaredFields()) {
      // obj.getClass().isAssignableFrom(AnnotationsMain.Person.class)

      if (field.isAnnotationPresent(Random.class) && field.getType().isAssignableFrom(int.class)) {
        Random annotation = field.getAnnotation(Random.class);
        int min = annotation.min();
        int max = annotation.max();
        try {
          field.setAccessible(true); // чтобы можно было изменять финальные поля
          field.set(obj, random.nextInt(min, max));
        } catch (IllegalAccessException e) {
          System.err.println("Не удалось вставить значение в поле: " + e.getMessage());
        }
      } else if (field.isAnnotationPresent(RandomDate.class) && field.getType().isAssignableFrom(java.util.Date.class)){
        RandomDate randomDate = field.getAnnotation(RandomDate.class);
        long min = randomDate.min();
        long max = randomDate.max();
        if(min < max) {
          try {
            field.setAccessible(true); // чтобы можно было изменять финальные поля
            field.set(obj, new Date(random.nextLong(min, max)));
          } catch (IllegalAccessException e) {
            System.err.println("Не удалось вставить значение в поле: " + e.getMessage());
          }
        }else {
          throw new RuntimeException("Минимум больше максимума");
        }
      }
    }

  }

}
