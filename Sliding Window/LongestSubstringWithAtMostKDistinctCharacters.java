import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aaabbccdd";
        int k = 2;
        int bruteForce = solution.getBruteForce(s, k);
        System.out.println(bruteForce);
        int optimalSol = solution.getOptimal(s, k);
        System.out.println(optimalSol);
    }

    private static class Solution {
        private int getBruteForce(String s, int k) {
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                HashMap<Character, Integer> map = new HashMap<>();
                for (int j = i; j < s.length(); j++) {
                    map.put(s.charAt(j), map.getOrDefault(map.get(s.charAt(j)), 0) + 1);
                    if (map.size() <= k) {
                        maxLen = Math.max(maxLen, j - i + 1);
                    } else {
                        break;
                    }
                }
            }
            return maxLen;
        }

        private int getOptimal(String s, int k) {
            int left = 0, right = 0, maxLen = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            while (right < s.length()) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                if (map.size() <= k) {
                    maxLen = Math.max(maxLen, right - left + 1);
                } else {
                    while (map.size() > k) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                        if (map.get(s.charAt(left)) == 0) {
                            map.remove(s.charAt(left));
                        }
                        left = left + 1;
                    }
                }
                right = right + 1;
            }
            return maxLen;
        }
    }
}
