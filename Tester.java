package ru.geegbrains.Tests.tester;

import ru.geegbrains.Tests.Tests;
import ru.geegbrains.Tests.tester.annotations.AfterSuite;
import ru.geegbrains.Tests.tester.annotations.BeforeSuite;
import ru.geegbrains.Tests.tester.annotations.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Tester {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        start(Tests.class);
    }

    public static void start(Class classX) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int before = 0;
        int after = 0;
        Constructor constructor = classX.getConstructor();
        Method[] methods = classX.getMethods();
        Object instance = constructor.newInstance();
        for (Method o : methods) {
            if (o.getAnnotation(BeforeSuite.class) != null) {
                if (before > 0) throw new RuntimeException();
                o.invoke(instance);
                before++;
            }
        }
        List<Method> tests = Arrays
                .stream(classX.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Test.class))
                .collect(Collectors.toList());


        tests.sort(Comparator.comparingInt((Method i) -> {
            return i.getAnnotation(Test.class).priority().getPriority();
        }));

        for (Method o : tests) {
            o.invoke(instance);
        }
        for (Method o : methods) {
            if (o.getAnnotation(AfterSuite.class) != null) {
                if (after> 0) throw new RuntimeException();
                o.invoke(instance);
                after++;
            }


        }
    }
}
