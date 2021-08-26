package MethodFinder;

import java.lang.reflect.Method;

public class MethodFinder {
    public static String findMethod(String methodName, String[] classNames) {
        for (String className : classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
//                    System.out.println(method.getName());
                    if (methodName.equals(method.getName())) {
                        return clazz.getName();
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] classes = {"java.lang.String", "java.lang.StringBuffer", "java.lang.Math"};
        System.out.println(findMethod("abs", classes));
        System.out.println("string");
    }
}
