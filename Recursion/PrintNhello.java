public class PrintNhello {
    public static void main(String[] args) {
        int n = 10;
        printNHello(n);
    }

    private static void printNHello(int n) {
        if (n == 0)
            return;
        printNHello(n - 1);
        System.out.println("Hello");
    }
}