import java.util.HashMap;

public class IsomorphicString {
    public static void main(String[] args) {
        String str1 = "badc", str2 = "baba";
        Solution solution = new Solution();
        boolean bruteForceSol = solution.betterApproach(str1, str2);
        System.out.println("Brute Force : " + bruteForceSol);
    }

    private static class Solution {
        private boolean betterApproach(String str1, String str2) {
            if (str1.length() != str2.length())
                return false;
            HashMap<Character, Character> map = new HashMap<>();
            for (int i = 0; i < str1.length(); i++) {
                if (map.containsKey(str1.charAt(i))) {
                    if (map.get(str1.charAt(i)) != str2.charAt(i))
                        return false;
                } else {
                    if (map.containsValue(str2.charAt(i)))
                        return false;
                }
                map.put(str1.charAt(i), str2.charAt(i));
            }
            return true;
        }
    }
}
