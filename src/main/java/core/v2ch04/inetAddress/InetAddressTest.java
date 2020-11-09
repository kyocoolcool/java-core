package core.v2ch04.inetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/11/9 6:05 PM
 **/
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        if (args.length > 0) {
            String host = args[0];
            final InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress address : addresses) {
                System.out.println(address);
            }
        } else {
            final InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
        }
    }
}
