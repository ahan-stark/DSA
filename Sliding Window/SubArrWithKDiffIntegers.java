import java.util.HashMap;
import java.util.HashSet;

public class SubArrWithKDiffIntegers {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 1, 2, 3 };
        int k = 2;
        Solution solution = new Solution();
        int bruteForce = solution.getBruteForce(nums, k);
        System.out.println(bruteForce);
        int optimalSol = solution.getOptimal(nums, k);
        System.out.println(optimalSol);
    }

    private static class Solution {
        private int getBruteForce(int nums[], int k) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = i; j < nums.length; j++) {
                    set.add(nums[j]);
                    if (set.size() == k)
                        count = count + 1;
                    else if (set.size() > k)
                        break;
                }
            }
            return count;
        }

        private int getOptimal(int nums[], int k) {
            int count = findAllSubArr(nums, k) - findAllSubArr(nums, k - 1);
            return count;
        }

        private int findAllSubArr(int nums[], int k) {
            int left = 0;
            int right = 0;
            int count = 0;
            if (k == 0) {
                return 0;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            while (right < nums.length) {
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
                while (map.size() > k) {
                    map.put(nums[left], map.get(nums[left]) - 1);
                    if (map.get(nums[left]) == 0) {
                        map.remove(nums[left]);
                    }
                    left = left + 1;
                }
                if (map.size() <= k) {
                    count = count + (right - left + 1);
                }
                right = right + 1;
            }
            return count;
        }
    }
}
// the logic is to find the subArr that contains exactly k distinct elements, it
// will be very hard to find exactly k , so we find all subArr less than k and k
// - 1 and subtract, we add one element to map with the count, if that
// map.size() > k then we have to move our window from left and also decrement
// the count of that nums[left] , if the map.get(nums[left]) becomes 0, then
// remove it, this is the logic