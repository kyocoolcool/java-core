import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/11/11 5:51 PM
 **/
class Tank {
    int level;
}

public class Main {
    public static void main(String[] args) {
        List<Tank> tankList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            Tank tank = new Tank();
            tank.level = i;
            tankList.add(tank);
            intList.add(i * 100);
        }
        System.out.println("intList: " + intList.get(0) + ", " + intList.get(1));
        fooIntList(intList);
        System.out.println("intList: " + intList.get(0) + ", " + intList.get(1));
        System.out.println("tankList: " + tankList.get(0).level + ", " + tankList.get(1).level);
        fooTankList(tankList);
        System.out.println("tankList: " + tankList.get(0).level + ", " + tankList.get(1).level);
    }

    public static void fooTankList(List<Tank> tankList) {
        for (Tank tank : tankList) {
            tank.level = 500;
        }
    }

    public static void fooIntList(List<Integer> intList) {
        for (Integer i : intList) {
            i = 2000;
        }
    }
}
