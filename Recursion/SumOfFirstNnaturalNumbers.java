public class SumOfFirstNnaturalNumbers {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(sumOfNumbers(n));
    }

    private static int sumOfNumbers(int n) {
        if (n == 1)
            return 1;
        return sumOfNumbers(n - 1) + n;

    }
}
