// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000 

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "MCMXCIV";
        int numerical = solution.betterApproach(str);
        System.out.println("Roman value : " + str + " to numerical : " + numerical);
    }

    private static class Solution {
        private int betterApproach(String str) {
            int res = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('M', 1000);
            map.put('D', 500);
            map.put('C', 100);
            map.put('L', 50);
            map.put('X', 10);
            map.put('V', 5);
            map.put('I', 1);
            int prev = 0;
            for (int i = str.length() - 1; i >= 0; i--) {
                int val = map.get(str.charAt(i));
                if (val < prev) {
                    res = res - val;
                } else {
                    res = res + val;
                }
                prev = val;
            }
            return res;
        }

    }
}
