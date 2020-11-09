package core.v2ch04.socket;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/11/9 5:45 PM
 **/
public class SocketTest {
    public static void main(String[] args) throws IOException {
        try (final Socket socket = new Socket("time-a.nist.gov", 13);
             final Scanner scanner = new Scanner(socket.getInputStream(), StandardCharsets.UTF_8)) {
            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                System.out.println(line);
            }

        }
    }
}
