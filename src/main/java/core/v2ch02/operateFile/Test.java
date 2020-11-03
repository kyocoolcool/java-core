package core.v2ch02.operateFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/11/3 7:48 PM
 **/
public class Test {
    public static void main(String[] args) throws IOException {
//        final Path path = Paths.get("src/main/resources","test");
//        System.out.println(path);
//        final Path path1 = Paths.get("src/main/resources");
//        final Path resolve = path1.resolve("test");
//        System.out.println(resolve);
//        final Path path3 = path1.resolveSibling("hello");
//        System.out.println(path3);
        final Path path4 = Paths.get("/Users/chris/git/java-core/src/main/resources/test");
        final Path path5 = Paths.get("/Users/chris/git/java-core/src/main/resources/test2");
//        System.out.println(path.getFileName());
//        System.out.println(path.getParent());
//        System.out.println(path4.getRoot());
//        final Scanner scanner = new Scanner(path4);
//        while (scanner.hasNext()) {
//            System.out.println(scanner.next());
//        }
        //        final String s = Files.readString(path4, StandardCharsets.UTF_8);
//        System.out.println(s);
//        final byte[] bytes = Files.readAllBytes(path4);
//        final String s1 = new String(bytes);
//        System.out.println(s1);
//        final List<String> strings = Files.readAllLines(path4, StandardCharsets.UTF_8);
//        strings.forEach(System.out::println);
//        final StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("hello");
//        Files.writeString(path4, stringBuilder,StandardCharsets.UTF_8,StandardOpenOption.APPEND);
//        Files.write(path4, "yoyo".getBytes(StandardCharsets.UTF_8),StandardOpenOption.APPEND);
//        final List<String> strings = Arrays.asList("chris", "mary", "nick");
//        Files.write(path4, strings, StandardOpenOption.APPEND);
//        final InputStream inputStream = Files.newInputStream(path4);
//        final OutputStream outputStream = Files.newOutputStream(path5);
//        outputStream.write(inputStream.readAllBytes());
//        final BufferedReader bufferedReader = Files.newBufferedReader(path4);
//        final BufferedWriter bufferedWriter = Files.newBufferedWriter(path5);
//        System.out.println(bufferedReader.readLine());
//        String string;
//        while ((string = bufferedReader.readLine()) != null){
//            System.out.println(string);
//            bufferedWriter.write(string);
//        }
//        bufferedWriter.flush();
//        final Path path6 = Paths.get("/Users/chris/git/java-core/src/main/resources/test5/test7");
//        Files.createDirectories(path6);
//        final Path path7 = Paths.get("/Users/chris/git/java-core/src/main/resources/test7");
//        Files.createFile(path7);
//        final Path path8 = Paths.get("/Users/chris/git/java-core/src/main/resources/test6");
//        final Path aaa = Files.createTempDirectory(path8, "aaa");
//        System.out.println(aaa);
        final Path path9 = Paths.get("/Users/chris/git/java-core/src/main/resources/test6");
        Files.createTempFile(path9, "bbb", ".txt");
    }
}
