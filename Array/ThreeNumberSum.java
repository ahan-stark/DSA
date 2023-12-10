import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeNumberSum {
    public static void main(String[] args) {
        int arr[] = { -1, 0, 1, 2, -1, 4 };
        Solution solution = new Solution();
        // brute force approach
        List<List<Integer>> bruteForce = new ArrayList<>();
        bruteForce = solution.bruteForce(arr);
        System.out.println("Brute Force Approach");
        for (List<Integer> elements : bruteForce) {
            System.out.println(elements);
        }
        // better approach
        List<List<Integer>> betterApproach = new ArrayList<>();
        betterApproach = solution.betterApproach(arr);
        System.out.println("Better Approach");
        for (List<Integer> elements : betterApproach) {
            System.out.println(elements);
        }
        // optimal approach 3 pointers
        List<List<Integer>> optimalApproach = new ArrayList<>();
        optimalApproach = solution.optimalApproach(arr);
        System.out.println("optimal Approach");
        for (List<Integer> elements : optimalApproach) {
            System.out.println(elements);
        }
    }

    private static class Solution {
        private List<List<Integer>> bruteForce(int arr[]) {
            Set<List<Integer>> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (arr[i] + arr[j] + arr[k] == 0) {
                            List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                            temp.sort(null);
                            set.add(temp);
                        }
                    }
                }
            }
            List<List<Integer>> list = new ArrayList<>(set);
            return list;
        }

        private List<List<Integer>> betterApproach(int arr[]) {
            // Hashing technique
            Set<List<Integer>> finalSet = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = i + 1; j < arr.length; j++) {
                    // to find arr[i]+arr[j]+arr[k]=0
                    // we can do arr[k] = -(arr[i]+arr[j])
                    int thirdNum = -(arr[i] + arr[j]);
                    if (set.contains(thirdNum)) {
                        List<Integer> list = Arrays.asList(arr[i], arr[j], thirdNum);
                        list.sort(null);
                        finalSet.add(list);
                    }
                    set.add(arr[j]);
                }
            }
            List<List<Integer>> finalList = new ArrayList<>(finalSet);
            return finalList;
        }

        private List<List<Integer>> optimalApproach(int arr[]) {
            List<List<Integer>> list = new ArrayList<>();
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                if (i != 0 && arr[i] == arr[i - 1]) {
                    // escaping duplicates
                    continue;
                }
                int j = i + 1;
                int k = arr.length - 1;
                while (j < k) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (sum < 0) {
                        // increment j++ to increase the sum
                        j++;
                    } else if (sum > 0) {
                        // decrement k-- to reduce the sum
                        k--;
                    } else {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        list.add(temp);
                        j++;
                        k--;
                        // Escaping the duplicates
                        while (j < k && arr[j] == arr[j - 1])
                            j++;
                        while (j < k && arr[k] == arr[k + 1])
                            k--;
                    }
                }
            }
            return list;
        }

    }
}
