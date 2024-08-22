public class NumberComplement {
    public static void main(String[] args) {
        int num = 5;
        Solution solution = new Solution();
        int res = solution.getComplementNumber(num);
        System.out.println("Complement of " + num + " is " + res);
    }

    private static class Solution {
        private int getComplementNumber(int num) {
            int res = 0;
            int i = 0;
            while (num > 0) {
                if ((num & 1) == 0) {
                    res = (res | 1 << i);
                }
                num = num >> 1;
                i++;
            }
            return res;
        }
    }
}
//we check if the bit is set..if it is set then we have to add 0 to it.. but initailly
//res = 0 so each and evry bit will be set to 0
//so if the particular bit is not set then we have to add 0 to that bit position
//in res.. we keep i pointer so that we can change the i-th bit pos in res
//now we say we have 101 - > 5 so after we check 101 & 001 that is whther its set or not
//we then have to move for next bit in num.. we cant move using any loop or anything so
//we need to shift that bit outside that is after 101 it becomes 010.. num is right shifted once
