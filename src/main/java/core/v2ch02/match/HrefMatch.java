package core.v2ch02.match;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/11/5 5:45 PM
 **/
public class HrefMatch {
    public static void main(String[] args) throws IOException {
            String urlString;
            if(args.length>0) urlString = args[0];
            else urlString = "http://openjdk.java.net";

            InputStream in = new URL(urlString).openStream();
            var input = new String(in.readAllBytes(), StandardCharsets.UTF_8);

            var patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
            final Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            pattern.matcher(input).results().map(MatchResult::group).forEach(System.out::println);
    }
}
