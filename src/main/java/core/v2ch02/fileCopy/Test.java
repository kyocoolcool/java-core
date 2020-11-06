package core.v2ch02.fileCopy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/11/4 8:09 PM
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        final Path path5 = Paths.get("/Users/chris/git/java-core/src/main/resources/test5/test55");
        final Path path6 = Paths.get("/Users/chris/git/java-core/src/main/resources/test6");
        final Path path7 = Paths.get("src/main/resources");
        Files.walk(path6).forEach(p -> {
            System.out.println(p);
            try {
                final Path q = path6.relativize(p);
                System.out.println(q);
                final Path resolve = path5.resolve(q);
                System.out.println(resolve);
                if (Files.isDirectory(p)) {
                    if (q.toString().equals("")) {
                        final Path path = Paths.get(resolve.toString(), p.getFileName().toString());
                        Files.createDirectory(path);
                    } else
                        Files.createDirectory(resolve);
                } else
                    Files.copy(p, resolve);
            } catch (Exception e) {
                System.out.println("error");
            }
        });
    }
}
