import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = { 3, 5, 10, 20 };
        System.out.println("Largest Divisible Subset : " + largestDivisibleSubset(nums));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int maxVal = 0;
        int maxIndex = 0;
        int parent[] = new int[nums.length];
        int dp[] = new int[nums.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int index = 1; index < nums.length; index++) {
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                if (nums[index] % nums[prevIndex] == 0 && 1 + dp[prevIndex] > dp[index]) {
                    dp[index] = 1 + dp[prevIndex];
                    parent[index] = prevIndex;
                }
            }
            if (dp[index] > maxVal) {
                maxVal = dp[index];
                maxIndex = index;
            }
        }
        List<Integer> list = new ArrayList<>();
        while (parent[maxIndex] != maxIndex) {
            list.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }
        list.add(nums[maxIndex]);
        return list;
    }
}
// Since they have asked subset, not subsequence, we can sort and check if a
// divides b, also the order doesn't matter, so sorting is fine.
// Follow tabulation, check what happens if I choose the curIndex with other
// prevIndex, take the max one from all the prev one's
// maintain parent array to track back all the connected indexes