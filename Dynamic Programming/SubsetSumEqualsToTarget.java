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
        System.out.println("Subset sum = " + target + "  is present ? : " + tabulation(arr, target));

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

    private static boolean tabulation(int[] arr, int target) {
        boolean dp[][] = new boolean[arr.length + 1][target + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        if (target >= arr[0]) {
            dp[0][arr[0]] = true;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int tar = 1; tar <= target; tar++) {
                boolean noPick = dp[i - 1][tar];
                boolean pick = false;
                if (tar - arr[i] >= 0) {
                    pick = dp[i - 1][tar - arr[i]];
                }
                dp[i][tar] = pick == true ? true : noPick;
            }
        }
        return dp[arr.length - 1][target];
    }
}
// everytime you pick a val, -subtract from target and move down untill you
// reach target == 0, base case
// dp is for index and target values
// Since we need in boolean, keep values as -1 0 1
// 1 -> true
// 0 -> false
// set it and then if 1 -> return true or else false

// in tabulation fill the dp with index * target, then check if i pick this
// element when I have this target, what will be the prev one if subtract with
// the current ele
// base condition keep all the target as 0, meaning when we reach 0, we have the
// target achieved
// one more is if the first index elem is less than target, set that element
// target pos as true
// the reason we do it is, we have 2,3 elem and target = 5
// if 2 < 5, mark index 0 of target 2 as true. because when we pick 3 we check
// prev ind with target 3, hence this will be true