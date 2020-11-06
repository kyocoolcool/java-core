package core.v2ch02.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/11/5 5:11 PM
 **/
public class RegexTest {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println("enter pattern");
        String patterString = in.nextLine();
        Pattern pattern = Pattern.compile(patterString);
        while (true) {
            System.out.println("Enter String to match");
            String input = in.nextLine();
            if (input == null || input.equals("")) {
                return;
            }
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                System.out.println("match");
                int g = matcher.groupCount();
                if (g > 0) {
                    for (int i = 0; i < input.length(); i++) {
                        for (int j = 1; j <= g; j++) {
                            if (i == matcher.start(j) && i == matcher.end(j))
                                System.out.print("()");
                        }
                        for (int j = 1; j <= g; j++) {
                            if (i == matcher.start(j) && i != matcher.end(j))
                                System.out.print('(');
                        }
                        System.out.print(input.charAt(i));
                        for (int j = 1; j <= g; j++) {
                            if (i + 1 != matcher.start(j) && i + 1 == matcher.end(j))
                                System.out.print(')');
                        }
                    }
                    System.out.println();
                }
            } else{
                System.out.println("No match");
            }
        }
    }
}

