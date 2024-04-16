import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        String str = "abcabcbb";
        Solution solution = new Solution();
        int bruteForce = solution.getBruteForce(str);
        System.out.println(bruteForce);
        int optimalSol = solution.getOptimal(str);
        System.out.println(optimalSol);
    }

    private static class Solution {
        private int getBruteForce(String str) {
            int maxLen = 0;
            for (int i = 0; i < str.length(); i++) {
                HashSet<Character> set = new HashSet<>();
                for (int j = i; j < str.length(); j++) {
                    if (set.contains(str.charAt(j))) {
                        break;
                    }
                    set.add(str.charAt(j));
                }
                maxLen = Math.max(maxLen, set.size());
            }
            return maxLen;
        }

        private int getOptimal(String str) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int maxLen = 0;
            int left = 0;
            int right = 0;
            while (right < str.length()) {
                int len = 0;
                if (!map.containsKey((int) str.charAt(right))) {
                    map.put((int) str.charAt(right), right);
                } else {
                    if (left <= map.get((int) str.charAt(right))) {
                        left = map.get((int) str.charAt(right)) + 1;
                    }
                    map.put((int) str.charAt(right), right);
                }
                len = right - left + 1;
                maxLen = Math.max(maxLen, len);
                right = right + 1;
            }
            return maxLen;
        }

    }
}
// we keep checking if the element have already occured in string by comparing
// it with the map, if there is no repeatation the left will remain same and
// right will anyways increment just find the len = right - left + 1

// if we find the repeating character, the we check at which pos is it found in
// mapping, if the left pointer is less than the found pos, the we have to
// update the left ptr to next of the prev found index, so that there is no
// repeatation, eg : 'z' is at 3 and 'z' is the right index '7', so z is
// repeated left is at 2, to make the window no repeating we have to update the
// left value as prev index + 1, now left = 3 + 1 = 4
// if left is after the repeating index, then we dont need to update the left
// value as the repeating index is not a part of current window