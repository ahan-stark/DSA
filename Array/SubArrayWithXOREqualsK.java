import java.util.HashMap;

public class SubArrayWithXOREqualsK {
    public static void main(String[] args) {
        int arr[] = { 4, 2, 2, 6, 4 };
        int k = 6;
        Solution solution = new Solution();
        // Brute Force
        int bruteSol = solution.bruteForce(arr, k);
        System.out.println("Brute Force Solution : " + bruteSol);
        // Optimal Solution
        int optimalSolution = solution.optimalSol(arr, k);
        System.out.println("Optimal Soluton : " + optimalSolution);
    }

    private static class Solution {
        private int bruteForce(int arr[], int k) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                int xor = 0;
                for (int j = i; j < arr.length; j++) {
                    xor = xor ^ arr[j];
                    if (xor == k)
                        count++;
                }
            }
            return count;
        }

        private int optimalSol(int arr[], int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            // By default if we get k = 6 at arr[0] we must say thats also valid so in
            // advance add 0 in hashmap
            map.put(0, 1);
            int xor = 0;
            for (int i = 0; i < arr.length; i++) {
                xor = xor ^ arr[i];
                int remXORinMap = xor ^ k;
                if (map.containsKey(remXORinMap)) {
                    count = count + map.get(remXORinMap);
                    map.put(xor, map.getOrDefault(xor, 0) + 1);
                } else {
                    map.put(xor, map.getOrDefault(xor, 0) + 1);
                }
            }
            return count;
        }
    }
}
