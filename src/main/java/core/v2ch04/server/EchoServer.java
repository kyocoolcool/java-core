package core.v2ch04.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/11/9 6:40 PM
 **/
public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8189);) {
            try (Socket incoming = serverSocket.accept();) {
                final InputStream inputStream = incoming.getInputStream();
                final OutputStream outputStream = incoming.getOutputStream();
                try (var in = new Scanner(inputStream, StandardCharsets.UTF_8)) {
                    final PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);
                    out.println("Hello! Enter BYE to exit");
                    var done = false;
                    while (!done && in.hasNextLine()) {
                        final String line = in.nextLine();
                        out.println("Echo:" + line);
                        if (line.trim().equals("BYE"))
                            done = true;
                    }
                }
            }
        }
    }
}
