package InvokingAMethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class SomeClass {

    // there is a method
    void method() {
        System.out.println("aaaa");
    }
}

public class MethodsDemo {

    public static void main(String[] args) {
        // write your code here
        Class cl = SomeClass.class;
        Method[] m = cl.getMethods();
        try {
            m[0].invoke(new SomeClass());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}