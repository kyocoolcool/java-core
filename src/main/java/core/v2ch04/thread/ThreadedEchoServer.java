package core.v2ch04.thread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/11/10 3:25 PM
 **/
public class ThreadedEchoServer {
    public static void main(String[] args) throws IOException {
        try (final ServerSocket serverSocket = new ServerSocket(8189);) {
            int i = 1;
            while (true) {
                final Socket incoming = serverSocket.accept();
                System.out.println("Spawning:" + i);
                Runnable r = new ThreadedEchoHandler(incoming);
                final Thread thread = new Thread(r);
                thread.start();
                i++;
            }
        }
    }

    private static class ThreadedEchoHandler implements Runnable {
         Socket incoming;

        public ThreadedEchoHandler(Socket incoming) {
            this.incoming = incoming;
        }

        @Override
        public void run() {
            try (final InputStream inputStream = incoming.getInputStream();
                 final OutputStream outputStream = incoming.getOutputStream();
                 final Scanner in = new Scanner(inputStream, StandardCharsets.UTF_8);
                 final PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8),true)
            ) {
                out.println("Hello! Enter BYE to exit.");
                var done = false;
                while (!done && in.hasNextLine()) {
                    final String line = in.nextLine();
                    out.println("Echo:" + line);
                    if (line.trim().equals("BYE")) {
                        done = true;
                    }
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
