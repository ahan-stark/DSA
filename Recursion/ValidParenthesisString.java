
// Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

// The following rules define a valid string:

// Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// Any right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
// '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
public class ValidParenthesisString {
    public static void main(String[] args) {
        String str1 = "((**))";
        String str2 = "((*))*(";
        Solution solution = new Solution();
        System.out.println(str1 + "is valid ? : " + solution.isValid(str1));
        System.out.println(str2 + "is valid ? : " + solution.isValid(str2));
        ;

    }

    private static class Solution {
        private boolean isValid(String str) {
            int count = 0;
            int index = 0;
            return check(index, str, count);
        }

        private boolean check(int index, String str, int count) {
            if (count < 0)
                return false;
            if (index == str.length()) {
                return count == 0 ? true : false;
            }
            if (str.charAt(index) == '(') {
                return check(index + 1, str, count + 1);
            }
            if (str.charAt(index) == ')') {
                return check(index + 1, str, count - 1);
            } else {
                if (check(index + 1, str, count + 1) == true)
                    return true;
                if (check(index + 1, str, count - 1) == true)
                    return true;
                if (check(index + 1, str, count) == true)
                    return true;
                else
                    return false;
            }

        }

    }
}

// if(count < 0) we check..))((.. the count at end will be 0..but it will be
// invalid.. so the moment count goes below 0 that means its not valid
// we use recursion backtracking to generate all the possible values... when *
// comes we check all the possibilties to obtain the valid string...
// * has 3 values either it will be ( so increment the count..or it will be ) so
// decrement the counter... ort empty so dont do anything.
