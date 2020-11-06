package core.v2ch02.directoryStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/11/4 8:13 PM
 **/
public class DirectoryStream {
    public static void main(String[] args) throws IOException {
        final Path test6 = Paths.get("src/main/resources/test6");
        try (java.nio.file.DirectoryStream<Path> paths = Files.newDirectoryStream(test6,"*.txt")) {
            for (Path path : paths) {
                System.out.println(path);
            }
        }
    }
}
