import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    static int dp[][];

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        dp = new int[nums.length][nums.length + 2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println("The total longest subsequence is : " + recursion(0, -1, nums));
        System.out.println("The total longest subsequence is : " + tabulation(nums));
        printSubsequences(nums);
    }

    private static int recursion(int index, int prevIndex, int[] nums) {
        if (index == nums.length)
            return 0;
        if (dp[index][prevIndex + 1] != -1)
            return dp[index][prevIndex + 1];
        int pick = 0;
        if (prevIndex == -1 || nums[prevIndex] < nums[index]) {
            pick = 1 + recursion(index + 1, index, nums);
        }
        int noPick = recursion(index + 1, prevIndex, nums);
        dp[index][prevIndex + 1] = Math.max(pick, noPick);
        return dp[index][prevIndex + 1];
    }

    private static int tabulation(int nums[]) {
        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        int maxCount = 0;
        for (int curIndex = 1; curIndex < dp.length; curIndex++) {
            for (int prevIndex = 0; prevIndex < curIndex; prevIndex++) {
                if (nums[curIndex] > nums[prevIndex] && dp[prevIndex] + 1 > dp[curIndex]) {
                    dp[curIndex] = 1 + dp[prevIndex];
                }

            }
            if (dp[curIndex] > maxCount) {
                maxCount = dp[curIndex];
            }
        }
        return maxCount;

    }

    private static void printSubsequences(int arr[]) {
        int parent[] = new int[arr.length];
        int dp[] = new int[arr.length];
        int maxCount = 1;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
        }
        for (int curIndex = 1; curIndex < dp.length; curIndex++) {
            parent[curIndex] = curIndex;
            for (int prevIndex = 0; prevIndex < curIndex; prevIndex++) {

                if (arr[curIndex] > arr[prevIndex]) {
                    if (dp[prevIndex] + 1 > dp[curIndex]) {
                        dp[curIndex] = dp[prevIndex] + 1;
                        parent[curIndex] = prevIndex;
                    } else if (dp[prevIndex] + 1 == dp[curIndex] && prevIndex < parent[curIndex]) {
                        parent[curIndex] = prevIndex;
                    }
                }
            }
            if (dp[curIndex] > maxCount || (maxCount == dp[curIndex] && curIndex < maxIndex)) {
                maxCount = dp[curIndex];
                maxIndex = curIndex;
            }
        }
        List<Integer> list = new ArrayList<>();
        while (parent[maxIndex] != maxIndex) {
            list.add(arr[maxIndex]);
            maxIndex = parent[maxIndex];
        }
        list.add(arr[maxIndex]);

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }
    }

}
// logic for dp
// logic is same as pick and non pick
// for each flow maintain the last index, if picked for next the cur is last
// index
// if no pick then whatever we have as the lastindex will be the lastindex even
// next
// since initially we use -1 as prevIndex so we cannot memoize the dp with -1 so
// push one
// further that is -1 will be 0 and 0 -> 1 , 1 -> 2 only the prev memoized state

// we can solve this in binary search also

// List<Integer> list = new ArrayList<>();
// for(int i = 0; i < nums.length; i++){
// if(list.isEmpty() || list.get(list.size() - 1) < nums[i]){
// list.add(nums[i]);
// }
// else{
// int replaceIndex = binarySearch(list, nums[i]);
// list.set(replaceIndex, nums[i]);
// }
// }
// return list.size();

// private int binarySearch(List<Integer> list, int target){
// int low = 0;
// int high = list.size() - 1;
// while(low <= high){
// int mid = (low + high) / 2;
// if(list.get(mid) >= target){
// high = mid - 1;
// }
// else{
// low = mid + 1;
// }
// }
// return low;
// }

// logic for bs
// the logic is for every new ele check if it follows increasing pattern,
// initailly put in list
// if it follows put in list
// if not find the lower bound, since the list we are adding in increasing order
// apply B.S on that
// for the lower bound replace that elem with the curEle
// arr = 1,4,8,12,7
// 1,4,8,12
// new elem is 7 so find the lower bound for 7 that is index 2(4), so replace8
// with 7
// new arr will be 1, 4, 7, 12
// we need just big length so we can do this

// printing
// same tabulation code, we use parent array and maintain parents for longest
// subsequnece to track back and find the elems.
// In case we get same length of subsequence, we get in the "else if" statement
// and check if both the length are equal and prevIndex is coming before the
// already stored prevIndex, we get this through parent[curIndex], if we see the
// curPrevIndex is coming before the already stored one and also the length are
// equal, change the parent[curIndex] to prevIndex.
//because we need index that come before, Index-wise Lexicographically Smallest.