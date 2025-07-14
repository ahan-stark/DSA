import java.util.Arrays;

public class Introduction {
    public static void main(String[] args) {
        int n = 10;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Fibonacci number at : " + n + " is  " + findFibo(n, dp));
    }

    private static int findFibo(int num, int[] dp) {
        if (num <= 1)
            return num;
        if(dp[num] != -1)
            return dp[num];
        dp[num] = findFibo((num - 1), dp) + findFibo(num - 2, dp);
        return dp[num];
    }
}