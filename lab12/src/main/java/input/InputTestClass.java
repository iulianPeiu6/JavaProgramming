package input;

import org.testng.annotations.Test;

@Test
public class InputTestClass {

    @Test
    public static void staticParameterlessTestAnnotatedMethod(){
        System.out.println("staticParameterlessTestAnnotatedMethod");
    }

    @Test
    public static void staticOneParameterTestAnnotatedMethod(int param){
        System.out.println("staticOneParameterTestAnnotatedMethod");
    }

    @Test
    public void parameterlessTestAnnotatedMethod(){
        System.out.println("staticParameterlessTestAnnotatedMethod");
    }

    public static void staticParameterlessMethod(){
        System.out.println("staticParameterlessTestAnnotatedMethod");
    }

}
