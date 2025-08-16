import java.util.Arrays;

public class SubsetSumEqualsToTarget {
    static int[][] dp;

    public static void main(String[] args) {
        int[] arr = { 1, 2, 7, 3 };
        int target = 6;
        dp = new int[arr.length][target + 1];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        System.out.println("Subset sum = " + target + "  is present ? : " + recursion(arr, target, arr.length - 1));
    }

    private static boolean recursion(int[] arr, int target, int curIndex) {
        if (target == 0)
            return true;
        if (curIndex < 0)
            return false;
        if (target < 0)
            return false;
        if (dp[curIndex][target] != -1)
            return dp[curIndex][target] == 1 ? true : false;
        boolean pick = recursion(arr, target - arr[curIndex], curIndex - 1);
        boolean nonPick = recursion(arr, target, curIndex - 1);
        dp[curIndex][target] = pick == true || nonPick == true ? 1 : 0;
        return dp[curIndex][target] == 1 ? true : false;
    }
}
