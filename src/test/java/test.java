


public class test {
    static boolean test1(int val) {
        System.out.println("test1(" + val + ")");
        System.out.println("pe3yLbTaT: " + (val < 1));
        return val < 1;
    }

    static boolean test2(int val) {
        System.out.println("test2(" + val + ")");
        System.out.println("pe3ynbTaT: " + (val < 2));
        return val < 2;
    }

    static boolean test3(int val) {
        System.out.println("test2(" + val + ")");
        System.out.println("pe3ynbTaT: " + (val < 3));
        return val < 3;

    }

    public static void main(String[] args) {
        boolean b = test1(0) && test2(0) && test3(1);
        System.out.println("total: " + b);
    }
}
