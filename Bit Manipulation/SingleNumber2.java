import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 1, 0, 1, 99 };
        Solution solution = new Solution();
        int bruteForce = solution.bruteForce(arr);
        System.out.println("Brute Force Single Element is : " + bruteForce);
        int betterApproach = solution.betterApproach(arr);
        System.out.println("Better Approach Single Element is : " + betterApproach);
        int optimalSol = solution.optimalSol(arr);
        System.out.println("Optimal Approach Single Element is : " + optimalSol);
    }

    private static class Solution {
        private int bruteForce(int arr[]) {
            int ans = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            for (Map.Entry<Integer, Integer> val : map.entrySet()) {
                if (val.getValue() == 1) {
                    ans = val.getKey();
                    break;
                }
            }
            return ans;
        }

        private int betterApproach(int arr[]) {
            int ans = 0;
            for (int bitIndex = 0; bitIndex < 32; bitIndex++) {
                int count = 0;
                for (int num : arr) {
                    if ((num & (1 << bitIndex)) != 0)
                        count++;
                }
                if (count % 3 == 1) {
                    ans = ans | (1 << bitIndex);
                }
            }
            return ans;
            // here the problem only one element will appear once rest everything will
            // appear thrice, what we do is comapare 0th bit of all elements, if its
            // divisble by 3 no need to change the ans bit go on till 31st bit..if its
            // not divisible by 3, its known that ans bit should have 1 in that bit field,
            // so comapre each bit till 31
        }

        private int optimalSol(int arr[]) {
            Arrays.sort(arr);
            for (int i = 1; i < arr.length; i = i + 3) {
                if (arr[i] != arr[i - 1])
                    return arr[i - 1];
            }
            return arr[arr.length - 1];
        }

    }
}
