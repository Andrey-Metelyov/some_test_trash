package WhatIsAnUpperBound;

// Do not remove imports

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Set;
import java.util.Scanner;

class TestClass {
    public Set<? extends Number> someMethod() {
        return null;
    }
}

class ListParameterInspector {
    // Do not change the method
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String methodName = scanner.next();

        ListParameterInspector inspector = new ListParameterInspector();
        inspector.printParameterType(new TestClass(), methodName);
    }

    public void printParameterType(TestClass obj, String methodName) throws Exception {
        // Add implementation here
        Class clazz = obj.getClass();
        Method method = clazz.getMethod(methodName);
        ParameterizedType parameterizedType = (ParameterizedType) method.getGenericReturnType();
        WildcardType wildcardType = (WildcardType) parameterizedType.getActualTypeArguments()[0];
        System.out.println(wildcardType.getUpperBounds()[0].getTypeName());
    }
}