// At a lemonade stand,each lemonade costs $5.Customers are standing in a queue to buy from you and order one at a time(in the order specified by bills).
// Each customer will only buy one lemonade and pay with either a $5,$10,or $20 bill.
// You must provide the correct change to each customer so that the net transaction is that the customer pays $5.

public class LemonadeProblem {
    public static void main(String[] args) {
        int money[] = { 5, 5, 5, 10, 20 };
        Solution solution = new Solution();
        System.out.println("Is it possible that everyone can buy lemonades : " + solution.findIfPossible(money));
    }

    private static class Solution {
        private boolean findIfPossible(int bills[]) {
            int fiveCount = 0;
            int tenCount = 0;
            for (int money : bills) {
                if (money == 5) {
                    fiveCount++;
                } else if (money == 10) {
                    if (fiveCount == 0)
                        return false;
                    else {
                        tenCount++;
                        fiveCount--;
                    }
                } else {
                    if (tenCount > 0 && fiveCount > 0) {
                        tenCount--;
                        fiveCount--;
                    } else if (fiveCount >= 3) {
                        fiveCount = fiveCount - 3;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }

    }
}
