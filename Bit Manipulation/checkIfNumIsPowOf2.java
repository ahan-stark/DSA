public class checkIfNumIsPowOf2 {
    public static void main(String[] args) {
        int num = 32;
        Solution solution = new Solution();
        boolean bruteForce = solution.bruteForce(num);
        System.out.println(num + " is a power of 2 : " + bruteForce);
        boolean optimalApproach = solution.optimalApproach(num);
        System.out.println(num + " is a power of 2 : " + optimalApproach);
    }

    private static class Solution {
        private boolean bruteForce(int num) {
            // if its a power of 2, there will be only one single 1 bit in entire binary
            // format
            String binaryVal = convertToBinary(num);
            int count = 0;
            for (int i = 0; i < binaryVal.length(); i++) {
                if (binaryVal.charAt(i) == '1')
                    count++;
            }
            return count == 1 ? true : false;
        }

        private boolean optimalApproach(int num) {
            // we know that if its 2 power there will be only be 1 single in entire binary
            // so if we get num - 1 it will be one 0 and entire 1 in binary
            return (num & num - 1) == 0 ? true : false;
        }

        private String convertToBinary(int num) {
            String ans = "";
            while (num > 1) {
                int rem = num % 2;
                ans = ans + rem;
                num = num / 2;
            }
            ans = ans + num;
            return reverse(ans);
        }

        private String reverse(String str) {
            StringBuilder reversed = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                reversed.append(str.charAt(i));
            }
            return reversed.toString();
        }
    }
}
