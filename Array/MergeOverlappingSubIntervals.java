import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingSubIntervals {
    public static void main(String[] args) {
        int arr[][] = { { 1, 3 }, { 2, 6 }, { 8, 9 }, { 9, 11 }, { 8, 10 }, { 2, 4 }, { 15, 18 }, { 16, 17 } };
        Solution solution = new Solution();
        // bruteForce Solution
        List<List<Integer>> brutForce = solution.bruteFoce(arr);
        System.out.println("Bruter Force");
        for (List<Integer> list : brutForce) {
            System.out.println(list);
        }
        // Optimal Solution
        List<List<Integer>> optimalSol = solution.optimalSol(arr);
        System.out.println("Optimal Solution :");
        for (List<Integer> list : optimalSol) {
            System.out.println(list);
        }
    }

    private static class Solution {
        private List<List<Integer>> bruteFoce(int arr[][]) {
            List<List<Integer>> finalList = new ArrayList<>();
            Arrays.sort(arr, new Comparator<int[]>() {
                public int compare(int a[], int b[]) {
                    return a[0] - b[0];
                }
            });
            for (int i = 0; i < arr.length; i++) {
                // get first and last and the comapare
                int start = arr[i][0];
                int end = arr[i][1];
                // to escape the duplicate repitation just keep moving the i
                if (!finalList.isEmpty() && end <= finalList.get(finalList.size() - 1).get(1))
                    continue;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j][0] <= end) {
                        end = Math.max(end, arr[j][1]);
                    } else {
                        break;
                    }

                }
                finalList.add(Arrays.asList(start, end));
            }
            return finalList;
        }

        private List<List<Integer>> optimalSol(int arr[][]) {
            List<List<Integer>> finalList = new ArrayList<>();
            Arrays.sort(arr, new Comparator<int[]>() {
                public int compare(int a[], int b[]) {
                    return a[0] - b[0];
                }
            });
            for (int i = 0; i < arr.length; i++) {
                if (finalList.isEmpty() || arr[i][0] > finalList.get(finalList.size() - 1).get(1)) {
                    finalList.add(Arrays.asList(arr[i][0], arr[i][1]));
                } else {
                    // update the interval if there is a interval overlap
                    finalList.get(finalList.size() - 1).set(1,
                            Math.max(finalList.get(finalList.size() - 1).get(1), arr[i][1]));
                }

            }
            return finalList;
        }

    }
}
