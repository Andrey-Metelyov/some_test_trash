import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

class TestClass {
    public <A, B, C> void someMethod() {
        //
        return;
    }
}
public class TypeVariablesInspector {


    public void printTypeVariablesCount(TestClass obj, String methodName) throws Exception {
        // Add implementation here
        Class clazz = obj.getClass();
        Method method = clazz.getDeclaredMethod(methodName);
        TypeVariable[] typeVariables = method.getTypeParameters();
        System.out.println(typeVariables.length);
//        for (TypeVariable typeVariable : typeVariables) {
//            System.out.println(typeVariable.getName());
//        }
    }

    public static void main(String[] args) throws Exception {
        TypeVariablesInspector inspector = new TypeVariablesInspector();
        TestClass obj = new TestClass();
        inspector.printTypeVariablesCount(obj, "someMethod");
    }
}
