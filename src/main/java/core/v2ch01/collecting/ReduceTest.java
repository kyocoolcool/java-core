package core.v2ch01.collecting;

import java.util.stream.Stream;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/10/16 4:04 PM
 **/
public class ReduceTest {
    public static void main(String[] args) {
        final Stream<String> stream = Stream.of("aaaaa", "bbbbb", "ccccc", "dddddd");
        final Integer reduce = stream.reduce(0, (x, y) -> x + y.length(), (x1, x2) -> x1 + x2);
        System.out.println(reduce);

    }
}
