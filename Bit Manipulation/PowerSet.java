// Given an integer array nums of unique elements, return all possible 
// subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

// Example 1:

// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]
import java.util.*;;

public class PowerSet {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        Solution solution = new Solution();
        List<List<Integer>> powerSets = solution.getPowerSets(arr);
        System.out.println("Power Sets are :");
        for (List<Integer> list : powerSets) {
            System.out.println(list);
        }
    }

    private static class Solution {
        private List<List<Integer>> getPowerSets(int arr[]) {
            List<List<Integer>> list = new ArrayList<>();
            int n = arr.length; // 3 elems, so n = 3
            int totalSubSets = 1 << n; // total subsets will be 2 pow n
            for (int num = 0; num < totalSubSets; num++) {
                ArrayList<Integer> subList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if ((num & (1 << i)) != 0) {
                        subList.add(arr[i]);
                    }
                }
                list.add(subList);
            }
            return list;
        }
    }
    // i am using logic like total subsets will 2 pow n
    // to get all possible subsets
    // we create logic table for n = 3 that is 2 pow 0, 2 pow 1, 2 pow 2
    // 0 000
    // 1 001
    // 2 010
    // 3 011
    // 4 100
    // 5 101
    // 6 110
    // 7 111
    // then we iterate over each 8 subsets and check which is 1 that is flipped in
    // that flipped bit take from arr[fliiped bit]
    // for each subsets create a new sublist and add it to mainList
}
