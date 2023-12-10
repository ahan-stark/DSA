import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourNumberSum {
    public static void main(String[] args) {
        int arr[] = { 1, 0, -1, 0, -2, 2 };
        Solution solution = new Solution();
        // brute force solution
        List<List<Integer>> bruteSol = solution.bruteForce(arr);
        System.out.println("Brute Force Solution");
        for (List<Integer> list : bruteSol) {
            System.out.println(list);
        }
        // better Approach = hashing
        List<List<Integer>> betterSol = solution.betterApproach(arr);
        System.out.println("Better Solution");
        for (List<Integer> list : betterSol) {
            System.out.println(list);
        }
        // optimal solution = 4 pointers
        List<List<Integer>> optimalSol = solution.optimalApproach(arr);
        System.out.println("Optimal Solution");
        for (List<Integer> list : optimalSol) {
            System.out.println(list);
        }
    }

    private static class Solution {
        private List<List<Integer>> bruteForce(int arr[]) {
            List<List<Integer>> finalList = new ArrayList<>();
            Set<List<Integer>> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    for (int k = j + 1; k < arr.length; k++) {
                        for (int l = k + 1; l < arr.length; l++) {
                            if (arr[i] + arr[j] + arr[k] + arr[l] == 0) {
                                List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                                list.sort(null);
                                set.add(list);
                            }
                        }
                    }
                }
            }
            finalList = new ArrayList<>(set);
            return finalList;

        }

        private List<List<Integer>> betterApproach(int arr[]) {
            List<List<Integer>> finalList = new ArrayList<>();
            Set<List<Integer>> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    Set<Integer> tempSet = new HashSet<>();
                    for (int k = j + 1; k < arr.length; k++) {
                        int fourthNum = arr[i] + arr[j] + arr[k];
                        if (tempSet.contains(-(fourthNum))) {
                            List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k], -(fourthNum));
                            list.sort(null);
                            set.add(list);
                        }
                        tempSet.add(arr[k]);
                    }
                }
            }
            finalList = new ArrayList<>(set);
            return finalList;
        }

        private List<List<Integer>> optimalApproach(int arr[]) {
            // using 4 pointers
            List<List<Integer>> finalList = new ArrayList<>();
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                // Escaping the duplicates
                if (i > 0 && arr[i] == arr[i - 1])
                    continue;
                else {
                    for (int j = i + 1; j < arr.length; j++) {
                        // Escaping the duplicates
                        if (j > i + 1 && arr[j] == arr[j - 1])
                            continue;
                        int k = j + 1;
                        int l = arr.length - 1;
                        while (k < l) {
                            long sum = arr[i] + arr[j];
                            sum = sum + arr[k];
                            sum = sum + arr[l];
                            if (sum < 0) {
                                k++;
                            } else if (sum > 0) {
                                l--;
                            } else {
                                List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                                finalList.add(list);
                                k++;
                                l--;
                                // Escaping the duplicates
                                while (k < l && arr[k] == arr[k - 1])
                                    k++;
                                while (k < l && arr[l] == arr[l + 1])
                                    l--;
                            }
                        }
                    }
                }
            }
            return finalList;
        }

    }

}
