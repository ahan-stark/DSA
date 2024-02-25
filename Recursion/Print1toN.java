public class Print1toN {
    public static void main(String[] args) {
        int n = 50;
        print(n);
    }

    private static void print(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        print(n - 1);
        System.out.println(n);
    }
}
