package core.v2ch02.memoryMap;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/11/5 3:47 PM
 **/
public class BufferTest {
    public static void main(String[] args) throws IOException {
//        final ByteBuffer buffer = ByteBuffer.allocate(1000);
//        final Path filename = Paths.get("src/main/resources/test6/bbb663948207975310939.txt");
//        try (FileChannel channel = FileChannel.open(filename)) {
//            final int read = channel.read(buffer);
//        }
        manipulateByteBuffer( Paths.get("src/main/resources/test6/aaa5941647699362271167/7899"));
    }

    public static void manipulateByteBuffer(Path fileName) throws IOException {
        // Crate buffer
        CharBuffer charBuffer = CharBuffer.allocate(6);

        // Add one byte
//        byteBuffer.put((byte) 9);

        // Add another three bytes
//        byteBuffer.put((byte) 4).put((byte) 8).put((byte) 7);
        final byte[] bytes = Files.newInputStream(fileName).readAllBytes();
        final String s = new String(bytes);

        charBuffer.put(s);
        charBuffer.flip();

        System.out.println(charBuffer.get());

        while (charBuffer.hasRemaining()) {
            System.out.println(charBuffer.get());
        }

        charBuffer.clear();
    }
}
