public class ValidAnagram {
    public static void main(String[] args) {
        String str1 = "aacc", str2 = "ccaa";
        Solution solution = new Solution();
        boolean betterApproach = solution.betterApproach(str1, str2);
        System.out.println("Are the strings Anagram? : " + betterApproach);

    }

    private static class Solution {
        private boolean betterApproach(String str1, String str2) {
            int arr[] = new int[26];
            for (int i = 0; i < str1.length(); i++) {
                arr[str1.charAt(i) - 97]++;
            }
            for (int i = 0; i < str2.length(); i++) {
                arr[str2.charAt(i) - 97]--;
            }
            for (int i = 0; i < 26; i++) {
                if (arr[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
