public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "xzmabbatr";
        Solution solution = new Solution();
        System.out.println(solution.findLongPalindrome(str));
    }

    private static class Solution {
        private String findLongPalindrome(String str) {
            int start = 0, end = 0;
            for (int i = 1; i < str.length(); i++) {
                // we check whether the palindrome is of odd size , also even size
                // if even size then it will comapare.... i, i+1, then i-1 and i+2....then i-2
                // and i+3
                // for odd size we check i, then i+1 and i-1 then i-2 and i+2....
                // we wont be knowing whether the palindrome exists in odd len or even len, so
                // check both also
                int oddLength = findLenOfPalindrome(str, i, i);
                int evenLength = findLenOfPalindrome(str, i, i + 1);
                int maxLen = Math.max(oddLength, evenLength);
                if (maxLen > end - start) {
                    start = i - (maxLen - 1) / 2;
                    end = i + (maxLen) / 2;
                }
            }
            return str.substring(start, end + 1);
        }

        private int findLenOfPalindrome(String str, int start, int last) {
            while (start >= 0 && last < str.length() && str.charAt(start) == str.charAt(last)) {
                start = start - 1;
                last = last + 1;
            }
            return last - start - 1;
        }
    }
}
