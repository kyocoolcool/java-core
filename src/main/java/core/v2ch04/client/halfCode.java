package core.v2ch04.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/11/10 5:31 PM
 **/
public class halfCode {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("127.0.0.1", 8189))
        {
            final Scanner in = new Scanner(socket.getInputStream(), StandardCharsets.UTF_8);
            final PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println("....");
            out.flush();
            socket.isOutputShutdown();
            while (in.hasNextLine()) {
                final String s = in.nextLine();
                System.out.println(s);
            }

        }
    }
}
