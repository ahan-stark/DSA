public class StringPalindrome {
    public static void main(String[] args) {
        String s = "madam";
        System.out.println(checkPalindrome(s, 0));
    }

    private static boolean checkPalindrome(String s, int i) {
        if (i >= s.length())
            return true;
        if (s.charAt(i) != s.charAt(s.length() - i - 1))
            return false;
        else
            return checkPalindrome(s, i + 1);
    }
}
