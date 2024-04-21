public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String bruteForce = solution.getBruteForce(s, t);
        System.out.println(bruteForce);
        String optimalApproach = solution.getOptimalApproach(s, t);
        System.out.println(optimalApproach);
    }

    private static class Solution {
        private String getBruteForce(String s, String t) {
            int index = 0;
            int minLen = s.length();
            for (int i = 0; i < s.length(); i++) {
                int hash[] = new int[256];
                for (int m = 0; m < t.length(); m++) {
                    hash[t.charAt(m)]++;
                }
                int count = 0;
                for (int j = i; j < s.length(); j++) {
                    if (hash[s.charAt(j)] > 0) {
                        count = count + 1;
                        hash[s.charAt(j)]--;
                    }
                    if (count == t.length()) {
                        if (j - i + 1 < minLen) {
                            index = i;
                            minLen = j - i + 1;
                        }
                        break;
                    }
                }
            }
            return s.substring(index, index + minLen);
        }

        private String getOptimalApproach(String s, String t) {
            int count = 0;
            int right = 0, left = 0;
            int minLen = s.length() + 1;
            int minIndex = 0;
            int hash[] = new int[256];
            for (int i = 0; i < t.length(); i++) {
                hash[t.charAt(i)]++;
            }
            while (right < s.length()) {
                if (hash[s.charAt(right)] > 0) {
                    count = count + 1;
                }
                hash[s.charAt(right)]--;
                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minIndex = left;
                        minLen = right - left + 1;
                    }
                    hash[s.charAt(left)]++;
                    if (hash[s.charAt(left)] > 0) {
                        count = count - 1;
                    }
                    left = left + 1;
                }
                right = right + 1;
            }
            return s.substring(minIndex, minIndex + minLen);
        }

    }
}
// in the optimal approach, we will have a hash arr with 'l' str chars with
// value incremented, then we check hash[s.right] if it is more than zero then
// its known that is present in 'l' str also, make count = count + 1, now
// decrement that hash[s.right]--, when the count == l.length() that means we
// have the substr with all the elements from the 'l' string so we increment the
// starting index and change the min Len, once we have count == l.length, we
// have to change the window, so now we have to move the left, while moving the
// right we had decremented , now whle moving in left we have to increment to
// increment the hash[left]++, if the hash[left] > 0, that means we had
// considered it already , so decrement the count = count - 1;
