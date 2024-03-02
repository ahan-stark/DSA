// If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
public class AtoI {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "-4193 with words";
        int val = solution.betterApproach(str);
        System.out.println("String : " + str + " converted to integer : " + val);
    }

    private static class Solution {
        private int betterApproach(String str) {
            int i = 0;
            int sign = 1;
            int result = 0;
            while (i < str.length() && str.charAt(i) == ' ')
                i = i + 1;
            if (i >= str.length())
                return 0;
            if (str.charAt(i) == '-') {
                sign = -1;
                i = i + 1;
            } else if (str.charAt(i) == '+') {
                sign = 1;
                i = i + 1;
            }
            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                int val = str.charAt(i) - 48;
                if (result > Integer.MAX_VALUE / 10)
                    return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                // Integer.MAX_VALUE = 2147483647 , so if i divide by 10 it will be 214748364 ,
                // if i add more than 7 , it will be overflow
                else if (result == Integer.MAX_VALUE / 10 && val > 7)
                    return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                else
                    result = result * 10 + val;
                i++;
            }
            return result * sign;
        }
    }
}
