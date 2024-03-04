// Calculate the beauty by finding the frequency of each character and then finding the difference between the frequencies of the most frequent and least frequent characters.
// Add up the beauty of all substrings to get the sum.

public class SumOfBeautyOfAllSubstring {
    public static void main(String[] args) {
        String str = "aabcb";
        Solution solution = new Solution();
        int ans = solution.betterApproach(str);
        System.out.println("Sum of beauty : " + ans);
    }

    private static class Solution {
        private int betterApproach(String str) {
            int ans = 0;
            // below logic will get you all the possible substrings
            for (int i = 0; i < str.length(); i++) {
                for (int j = i; j < str.length(); j++) {
                    ans = ans + findMaxMin(str.substring(i, j + 1));
                }
            }
            return ans;
        }

        private int findMaxMin(String str) {
            // i have to find the most repeated character in string
            // and least repeated character in string
            // take the string , initialize a temp array
            // add the characters in temp array
            // get max and min of all the stored characters
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int temp[] = new int[26];
            for (int i = 0; i < str.length(); i++) {
                temp[str.charAt(i) - 97]++;
            }
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] > 0) {
                    max = Math.max(max, temp[i]);
                    min = Math.min(min, temp[i]);
                }
            }
            return max - min;
        }
    }
}
