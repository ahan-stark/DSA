public class FactorialOfN {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(printFactorial(n));
    }

    private static int printFactorial(int n) {
        if (n == 1)
            return 1;
        return n * printFactorial(n - 1);
    }
}
