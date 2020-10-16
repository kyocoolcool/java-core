package core.v2ch01.streams;



import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/10/16 4:04 PM
 **/
public class CountLongWords
{
   public static void main(String[] args) throws IOException
   {
      var contents = new String(Files.readAllBytes(
         Paths.get("../gutenberg/alice30.txt")), StandardCharsets.UTF_8);
      List<String> words = List.of(contents.split("\\PL+"));

      long count = 0;
      for (String w : words)
      {
         if (w.length() > 12) count++;
      }
      System.out.println(count);

      count = words.stream().filter(w -> w.length() > 12).count();
      System.out.println(count);

      count = words.parallelStream().filter(w -> w.length() > 12).count();
      System.out.println(count);
   }
}
