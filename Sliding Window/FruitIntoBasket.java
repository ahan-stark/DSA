//in this problem we have to identify max consecutive fruits that can be put into basket of variety = k

import java.util.HashMap;
import java.util.HashSet;

public class FruitIntoBasket {
    public static void main(String[] args) {
        int arr[] = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
        int k = 2;
        Solution solution = new Solution();
        int bruteForce = solution.getBruteForce(arr, k);
        System.out.println(bruteForce);
        int betterSol = solution.getBetterApproach(arr, k);
        System.out.println(betterSol);
    }

    private static class Solution {
        private int getBruteForce(int arr[], int k) {
            int maxLen = 0;
            for (int i = 0; i < arr.length; i++) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = i; j < arr.length; j++) {
                    set.add(arr[j]);
                    if (set.size() <= k) {
                        maxLen = Math.max(maxLen, j - i + 1);
                    }
                    if (set.size() > k)
                        break;
                }
            }
            return maxLen;
        }

        private int getBetterApproach(int arr[], int k) {
            int left = 0;
            int right = 0;
            int maxLen = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            while (right < arr.length) {
                map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
                while (map.size() > k) {
                    map.put(arr[left], (map.get(arr[left])) - 1);
                    if (map.get(arr[left]) == 0)
                        map.remove(arr[left]);
                    left = left + 1;
                }
                maxLen = Math.max(maxLen, right - left + 1);
                right = right + 1;
            }
            return maxLen;
        }
    }
}
// In the better approach, we put the new element that is arr[right] into the
// map, if already present , then increment the value.... since only k variety
// of fruits are allowed, we check the size of map, if it is greater than k,
// that means we have to change the window, so we reduce the count of arr[left]
// from the map untill its count becomes 0 and we remove it and now one variety
// of fruits will be deleted, and left = left + s1, loop continues untill
// map.size <= k.
