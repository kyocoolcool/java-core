package core.v2ch02;

import java.io.*;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/10/29 7:54 PM
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        try (var in = new BufferedReader(new FileReader("employee2.dat"))) {
            final String s = in.readLine();
            try (var op=new BufferedWriter(new FileWriter("employee.dat"))){
                op.write(s);
            }
        }
    }
}
