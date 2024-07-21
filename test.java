
class test {

    static void m1(Integer... x) {
        System.out.println("int, byte");
    }

    static void m1(Integer x, Integer y) {
        System.out.println("Byte, Byte");
    }

    static void m1(Float... x) {
        System.out.println("Float ... ");
    }

    static void m1(Double... x) {
        System.out.println("D ... ");
    }

    public static void main(String[] args) {
        byte b = 5;
        m1(b, b);

    }
}