// A robber is targeting to rob houses from a street. Each house has security measures that alert the police 
// when two adjacent houses are robbed. The houses are arranged in a circular manner, 
// thus the first and last houses are adjacent to each other.

// Given an integer array money, where money[i] represents the amount of money that can be looted from the (i+1)th house. 
// Return the maximum amount of money that the robber can loot without alerting the police.
// Input: money = [1, 5, 2, 1, 6]

// Output: 11

// Explanation: [1, 5, 2, 1, 6] The underlined houses would give the maximum loot.

import java.util.Arrays;

public class HouseRobberCircular {
    public static void main(String[] args) {
        int[] money = { 1, 5, 2, 1, 6 };
        System.out.println("max house that can he can rob is : " + modify(money));
        System.out.println("max house that can he can rob is : " + tabModify(money));
    }

    private static int modify(int[] money) {
        if (money.length == 1)
            return money[0];
        int dp1[] = new int[money.length - 1];
        int dp2[] = new int[money.length - 1];
        int arr1[] = new int[money.length - 1];
        int arr2[] = new int[money.length - 1];
        for (int i = 0; i < money.length - 1; i++) {
            arr1[i] = money[i];
        }
        for (int i = 0; i < money.length - 1; i++) {
            arr2[i] = money[i + 1];
        }
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        int val1 = recursion(arr1.length - 1, arr1, dp1);
        int val2 = recursion(arr2.length - 1, arr2, dp2);
        return Math.max(val1, val2);
    }

    private static int recursion(int n, int[] money, int[] dp) {
        if (n == 0)
            return money[0];
        if (n < 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int pick = money[n] + recursion(n - 2, money, dp);
        int nonPick = 0 + recursion(n - 1, money, dp);
        dp[n] = Math.max(pick, nonPick);
        return dp[n];
    }

    private static int tabModify(int[] money) {
        if (money.length == 1)
            return money[0];
        int arr1[] = new int[money.length - 1];
        int arr2[] = new int[money.length - 1];
        for (int i = 0; i < money.length - 1; i++) {
            arr1[i] = money[i];
        }
        for (int i = 0; i < money.length - 1; i++) {
            arr2[i] = money[i + 1];
        }
        int val1 = tabulation(arr1);
        int val2 = tabulation(arr2);
        return Math.max(val1, val2);
    }

    private static int tabulation(int money[]) {
        int[] dp = new int[money.length];
        dp[0] = money[0];
        for (int i = 1; i < money.length; i++) {
            int pick = money[i];
            int nonPick = 0 + dp[i - 1];
            if (i - 2 >= 0) {
                pick = pick + dp[i - 2];
            }
            dp[i] = Math.max(pick, nonPick);
        }
        return dp[dp.length - 1];
    }
}
// use same pick and non pick algo
// since first and last is connected
// we choose first then remove the last elem and do a dp
// we choose last, then remove the first elem and do a dp
// we do this because if we choose last and then keep going
// we might end up choosing first also, so do seperatley for both
// so del one that is add all to new arr except for last and same
// for first also create 2 arr find both max values return that