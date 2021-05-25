package lab12app;

import org.testng.annotations.Test;

import java.lang.reflect.Modifier;

public class ClassLoaderDemo {
    public ClassLoaderDemo() {
    }

    public void load(String classname){
        ClassLoader loader = this.getClass().getClassLoader();
        try {
            var associatedClass = loader.loadClass(classname);
            printDetails(associatedClass);
            printStaticNoArgumentsTestAnnotatedMethods(associatedClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void printStaticNoArgumentsTestAnnotatedMethods(Class<?> associatedClass) {
        var className = associatedClass.getName();
        var methods = associatedClass.getMethods();
        System.out.println("Class, " + className + " has the following static with no arguments and @Test annotated methods: ");
        for (var method : methods) {
            if (method.isAnnotationPresent(Test.class))
                if (method.getParameterCount() == 0)
                    if (Modifier.isStatic(method.getModifiers()))
                        System.out.println(method);
        }
    }

    private void printDetails(Class<?> associatedClass) {
        var className = associatedClass.getName();
        var methods = associatedClass.getMethods();
        System.out.println("Class, " + className + " has the following methods: ");
        for (var method : methods)
            System.out.println(method);
    }
}
