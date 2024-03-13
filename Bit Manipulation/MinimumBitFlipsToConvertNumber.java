public class MinimumBitFlipsToConvertNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 7;
        int target = 13;
        int minFlips = solution.minFlipsReq(num, target);
        System.out.println("Minimum bits to be flipped to form the target is  : " + minFlips);
    }

    private static class Solution {
        private int minFlipsReq(int num, int target) {
            int count = 0;
            // if we need to check the min bits to flipped to form that target number, first
            // xor num and target, like bits will become o unlike will become 1, now we have
            // to find the number of 1 in xor'ed val , so that is the min flips needed
            // to check the set bits that is 1 in val of xor'ed, run a loop from 0th bit to
            // 31st bit and check if bits at that position is set or not
            int val = num ^ target;
            for (int i = 0; i < 32; i++) {
                if ((val & (1 << i)) != 0) {
                    count++;
                }
            }
            return count;
        }

    }
}
