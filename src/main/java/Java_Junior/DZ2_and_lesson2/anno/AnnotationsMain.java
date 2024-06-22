package Java_Junior.DZ2_and_lesson2.anno;

import Java_Junior.DZ2_and_lesson2.anno.lib.ObjectCreator;
import Java_Junior.DZ2_and_lesson2.anno.lib.Random;
import Java_Junior.DZ2_and_lesson2.anno.lib.RandomDate;

import java.util.Date;

public class AnnotationsMain {

  public static void main(String[] args) {
    Person rndPerson = ObjectCreator.createObj(Person.class);
    System.out.println("age1 = " + rndPerson.age1);
    System.out.println("age2 = " + rndPerson.age2);
    System.out.println("Date = " + rndPerson.date1);
    System.out.println("Date = " + rndPerson.date2);

    // extPerson.isAssignableFrom(ExtPerson.class) // true
    // extPerson.isAssignableFrom(Person.class) // false
    // person.isAssignableFrom(ExtPerson.class) // true

    Person p = new Person();
    Person ep = new ExtPerson();

    System.out.println(p.getClass().isAssignableFrom(Person.class)); // true
    System.out.println(p.getClass().isAssignableFrom(ExtPerson.class)); // true

    System.out.println(ep.getClass().isAssignableFrom(Person.class)); // false
    System.out.println(ep.getClass().isAssignableFrom(ExtPerson.class)); // true

  }

  public static class ExtPerson extends Person {

  }

  public static class Person {

    @Random // рандомное число в диапазоне [0, 100)
    private int age1;

    @Random(min = 50, max = 51) // рандомное число в диапазоне [50, 51) => 50
    private int age2;

    @Random
    private String age3;

    @RandomDate
    private Date date1;

    @RandomDate(min = 1704067200001L, max = 1735689600002L)
    private Date date2;

  }

}
