import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int candidates[] = { 1, 3, 2 };
        int target = 3;
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int n = candidates.length;
        findCombination(i, target, list, ansList, n, candidates);
        for (List<Integer> tempList : ansList) {
            System.out.println(tempList);
        }

    }

    private static void findCombination(int i, int target, List<Integer> list, List<List<Integer>> ansList, int n,
            int[] arr) {
        if (target < 0) {
            return;
        }
        if (i >= n) {
            return;
        }
        if (target == 0) {
            ansList.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[i]);
        findCombination(i, target - arr[i], list, ansList, n, arr);
        list.remove(list.size() - 1);
        findCombination(++i, target, list, ansList, n, arr);
    }
}
