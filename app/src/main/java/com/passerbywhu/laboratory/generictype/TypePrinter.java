package com.passerbywhu.laboratory.generictype;

import android.text.TextUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * Created by hzwuwenchao on 2018/1/8.
 */

public class TypePrinter {
    public static class TypeClazz<T1, T2 extends Number> {
        public T2 member;
        public T1 member2;
        public Collection<? extends Number> collection;
        public Collection<T2> collection2;
        public T2[] array;
        public <T extends Type> void method(T p1, T2 p2) {}
    }

    public static void printlnType(Type type) {
        System.out.println(type.getClass().getSimpleName() + ":" + type);
    }

    public static Type printlnFieldType(Class<? extends TypeClazz> clazz, String name) {
        System.out.println("name:" + name);
        Type type = null;
        try {
            Field field = clazz.getDeclaredField(name);
            type = field.getGenericType();
            printlnType(type);
        } catch (Exception e) {}
        if (type instanceof ParameterizedType) {
            ParameterizedType ptype = (ParameterizedType) type;
            Type[] types = ptype.getActualTypeArguments();
            for (Type t : types) {
                System.out.print(">>");
                printlnType(t);
            }
        }
        return type;
    }

    public static void printlnMethodType(Class<? extends TypeClazz> clazz, String name) {
        System.out.println("name: " + name);
        Method[] ms = clazz.getDeclaredMethods();
        Method method = null;
        for (Method m : ms) {
            if (TextUtils.equals(m.getName(), name)) {
                method = m;
                break;
            }
        }
        printlnType(method.getGenericReturnType());
        Type[] types = method.getGenericParameterTypes();
        for (Type t: types) {
            printlnType(t);
        }
    }

    public static void test() {
        TypeClazz<String, Integer> clazz = new TypeClazz<>();
        TypePrinter.printlnFieldType(clazz.getClass(), "member");
        TypePrinter.printlnFieldType(clazz.getClass(), "member2");
        TypePrinter.printlnFieldType(clazz.getClass(), "collection");
        TypePrinter.printlnFieldType(clazz.getClass(), "collection2");
        TypePrinter.printlnFieldType(clazz.getClass(), "array");
        TypePrinter.printlnMethodType(clazz.getClass(), "method");
    }
}
