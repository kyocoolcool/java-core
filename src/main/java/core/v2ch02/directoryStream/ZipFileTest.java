package core.v2ch02.directoryStream;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/11/4 8:35 PM
 **/
public class ZipFileTest {
    public static void main(String[] args) throws IOException {
        final FileSystem fileSystem = FileSystems.newFileSystem(Paths.get("src/main/resources/test6/aaa5941647699362271167.zip"), null);
        final Path path = Paths.get("src/main/resources/test6");
        System.out.println(fileSystem);
        final Path path1 = fileSystem.getPath("123");
        System.out.println(path1);
//        final Path copy = Files.copy(fileSystem.getPath("/aaa5941647699362271167/789"), path);
        FileSystem fs = FileSystems.newFileSystem(Paths.get("src/main/resources/test6/aaa5941647699362271167.zip"), null);
        Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                return super.visitFile(file, attrs);
            }
        });

    }
}
