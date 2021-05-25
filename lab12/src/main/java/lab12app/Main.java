package lab12app;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) {
        ClassLoaderDemo classLoaderDemo = new ClassLoaderDemo();
        classLoaderDemo.load("input.InputTestClass");

    }
}
