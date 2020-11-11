/**
 * @author Chris Chen https://blog.kyocoolcool.com
 * @version 1.0
 * @since 2020/11/11 7:24 PM
 **/
public class Test {
        static String aa = "a";
    static String bb = new String("bb");
    static Integer cc = 10;
    static Dog dog = new Dog("aloha");

    public static void hello(String a) {
        System.out.println(a == aa);
//        a += a;
        a = a.concat(a);
        System.out.println(a == aa);
    }

    public static void hellobb(String a) {
        System.out.println(a == bb);
//        a += a;
        a = a.concat(a);
        System.out.println(a == bb);
    }


    public static void hellocc(Integer c) {
        Integer a = c;
        System.out.println(a==c);
//        a += a;
        c = c*c;
        System.out.println(a==c);
    }

    public static void hellocc2(Integer c) {
        Integer i = c*c;
        System.out.println(c == i);
    }

    public static void hellobb2(String a) {
        String aaa = a;
//        a += a;
        a = a.concat(a);
        String bbb = a;
        System.out.println(aaa == bbb);
    }

    public static void hello2(Dog dog2) {
        System.out.println(dog == dog2);
        dog2.name = "qqqqqqq";
        System.out.println(dog == dog2);
    }

    public static void main(String[] args) {
//        hello(aa);
//        System.out.println(aa);
//        System.out.println(aa);
//        String bb = new String("bb");
//        hellobb2(bb);
//        hellobb(bb);
//        System.out.println(bb);
//        hello2(dog);
//        System.out.println(dog);
//        hellocc(cc);
//        System.out.println(cc);
        int var = 100;
        hellocc(var);
        System.out.println(var);

    }

    private static class Dog {
        String name;

        public Dog(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
