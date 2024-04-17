//find the longest repeating substr such that k replacement is allowed

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String str = "AABABBA";
        Solution solution = new Solution();
        int k = 2;
        int bruteForce = solution.getBruteForce(str, k);
        System.out.println(bruteForce);
        int betterApproach = solution.getBetterApproach(str, k);
        System.out.println(betterApproach);
    }

    private static class Solution {
        private int getBruteForce(String s, int k) {
            int maxLen = 0;
            for (int i = 0; i < s.length(); i++) {
                int majorityElemCount = 0;
                int len = 0;
                HashMap<Character, Integer> map = new HashMap<>();
                for (int j = i; j < s.length(); j++) {
                    map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                    majorityElemCount = Math.max(majorityElemCount, map.get(s.charAt(j)));
                    len = j - i + 1;
                    if (len - majorityElemCount <= k) {
                        maxLen = Math.max(maxLen, len);
                    } else {
                        break;
                    }
                }
            }
            return maxLen;
        }

        private int getBetterApproach(String s, int k) {
            int left = 0, right = 0, maxLen = 0, majorityELemCount = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            while (right < s.length()) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
                majorityELemCount = Math.max(majorityELemCount, map.get(s.charAt(right)));
                while ((right - left + 1) - majorityELemCount > k) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    majorityELemCount = 0;
                    for (Map.Entry<Character, Integer> val : map.entrySet()) {
                        majorityELemCount = Math.max(majorityELemCount, val.getValue());
                    }
                    left = left + 1;
                }
                if ((right - left + 1) - majorityELemCount <= k) {
                    maxLen = Math.max(maxLen, right - left + 1);
                }
                right = right + 1;
            }
            return maxLen;
        }

    }
}
// in the brute force approach what we are doing is, we take a substring and
// maintain a majorityElemCount , so that if we get len of subArr and know which
// is the majorityElementCount, then the changes which we have to make 'k' will
// be the minority of elements that is len - majorityELemCount, so if (len -
// majorityElemCount) <= k that means we can make these k changes and consider
// it to be maximum repeating substring

// in the better approach also we do the same technique as bruteforce , but we
// use two pointer sliding window method, where in if in case len : (right -
// left + 1) - majorityELem becomes less than k, then we have to update the left
// pointer untill (right - left + 1) - majorityELem becomes less than k becomes
// false, so while doing we have to make sure we are moving the window while
// moving we have to update(that is decrement) the occuring times of left
// Character in map and then calculate majorityElement, bcz as the sliding
// window is changing we are also moving left pointer so we have to decrement
// that