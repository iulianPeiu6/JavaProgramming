package lab12app;

import input.InputTestClass;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class ClassLoaderDemo {
    public ClassLoaderDemo() {
    }

    public void load(String classname){
        ClassLoader loader = this.getClass().getClassLoader();
        try {
            var associatedClass = loader.loadClass(classname);
            printDetails(associatedClass);
            printStaticNoArgumentsTestAnnotatedMethods(associatedClass);
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
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

    private void printDetails(Class<?> associatedClass) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        var className = associatedClass.getName();
        var methods = associatedClass.getMethods();
        System.out.println("Class, " + className + " has the following methods: ");
        for (var method : methods)
            System.out.println(method);

        //tryInvokeTests(associatedClass,methods);
    }

    private void tryInvokeTests(Class<?> associatedClass, Method[] methods) throws InvocationTargetException, IllegalAccessException {
        if (associatedClass.isAnnotationPresent(Test.class)) {
            for (var method : methods)
                if (method.getParameterCount() == 0)
                    method.invoke(associatedClass);
        }
    }

    public List<File> exploreDirectory(String path){
        File directory = new File(path);
        return Arrays.asList(directory.listFiles());
    }
}
