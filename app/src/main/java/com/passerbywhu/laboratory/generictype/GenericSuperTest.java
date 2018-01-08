package com.passerbywhu.laboratory.generictype;

/**
 * Created by hzwuwenchao on 2018/1/5.
 */

public class GenericSuperTest {
    static class Person<T> {
        /**
         * private things
         */
        T t;
    }

    static class Book {
        String name;
    }

    static class Student extends Person<Book> {

    }

    public static void test() {
        System.out.println("Student.class.getSuperclass()\n" + Student.class.getSuperclass());
        System.out.println("Student.class.getGenericSuperclass()\n" + Student.class.getGenericSuperclass());

        System.out.println("Book.class.getSuperclass()\n" +Book.class.getSuperclass());
        System.out.println("Book.class.getGenericSuperclass()\n" + Book.class.getGenericSuperclass());

        System.out.println("Person.class.getSuperclass()\n" + Person.class.getSuperclass());
        System.out.println("Person.class.getGenericSuperclass()\n" + Person.class.getGenericSuperclass());

        System.out.println("Object.class.getSuperclass()\n" + Object.class.getSuperclass());
        System.out.println("Object.class.getGenericSuperclass()\n" + Object.class.getGenericSuperclass());

        System.out.println("void.class.getSuperclass()\n" + void.class.getSuperclass());
        System.out.println("void.class.getGenericSuperclass()\n" + void.class.getGenericSuperclass());

        System.out.println("int[].class.getSuperclass()\n" + int[].class.getSuperclass());
        System.out.println("int[].class.getGenericSuperclass()\n" + int[].class.getGenericSuperclass());
    }
}
