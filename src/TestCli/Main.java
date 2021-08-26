package TestCli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        String[] commands = {
                "/output ",
                "/output",
                "/output              ",
                "/output zopa gavno kakashka",
                "/output qwerqwer \"asdf zxcv\"",
                "/output \"qwer qwer\" \"asdf zxcv\"",
                "/output qwerqwer asdfzxcv",
                "/output \"     qwerqwer  asdf   \"       zxcv",
                "/output \"   qwer      qwer\"  \"asdf zxcv\"",
                "/output qwerqwer      asdfzxcv \"asdf asdf\" asdfzcv \"asd zcxv asdlf\" \"asdfzcv\"",
        };
        System.out.println(Arrays.toString(commands));
        for (String command : commands) {
            System.out.print(command);
            System.out.print(" -> ");
            System.out.println((parse(command)));
        }
    }

    private static List<String> parse(String command) {
        List<String> list = new ArrayList<>();
        String[] commands = command.split("\\s+", 2);
        list.add(commands[0]);
        if (commands.length > 1) {
            String params = commands[1];
            while (!params.isEmpty()) {
                if (params.charAt(0) == '"') {
                    int closeQuotePos = params.indexOf('\"', 1);
                    list.add(params.substring(1, closeQuotePos));
                    params = params.substring(closeQuotePos + 1).trim();
                } else {
                    int nextSpacePos = params.indexOf(' ', 0);
                    if (nextSpacePos != -1) {
                        list.add(params.substring(0, nextSpacePos));
                        params = params.substring(nextSpacePos + 1).trim();
                    } else {
                        list.add(params);
                        params = "";
                    }
                }
            }
        }
        return list;
    }
}
