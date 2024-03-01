public class CheckIfGivenStringsAreRotationsOfEachOther {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "abcde", str2 = "cdeab";
        System.out.println("Given String Rotated? :" + solution.betterApproach(str1, str2));

    }

    private static class Solution {
        private boolean betterApproach(String str1, String str2) {
            if (str1.length() != str2.length())
                return false;
            if ((str1 + str1).contains(str2)) {
                return true;
            }
            return false;
        }

    }
}
