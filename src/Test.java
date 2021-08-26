import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println(TestFunc("xhihixhx"));
//        System.out.println(TestFunc(new int[]{1, 1, 2, 1, 1}));
//        System.out.println(TestFunc(new int[]{1,1,1,2,2}));
//        System.out.println(TestFunc(new int[]{7, 1, 2, 9, 7, 2, 1}));
//        System.out.println(TestFunc(new int[]{}));
        Long val = 4321L;

        Long val2 = new Long(4321);

        Long val3 = Long.parseLong("4321");

        Long val4 = new Long("4321");
    }

    public static int TestFunc(String str) {
        if (str.length() < 2) return 0;
        if (str.substring(0,2).toLowerCase().equals("hi")) return 1 + TestFunc(str.substring(2));
        return TestFunc(str.substring(1));
    }
}


