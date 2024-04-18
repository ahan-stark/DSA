public class NumberOfSubstringsContainingAllThreeChars {
    public static void main(String[] args) {
        String s = "abcabc";
        Solution solution = new Solution();
        int bruteForce = solution.getBruteForce(s);
        System.out.println(bruteForce);
        int optimalSol = solution.getOptimalSol(s);
        System.out.println(optimalSol);
    }

    private static class Solution {
        private int getBruteForce(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                int arr[] = new int[3];
                for (int j = i; j < s.length(); j++) {
                    arr[s.charAt(j) - 97]++;
                    if (arr[0] != 0 && arr[1] != 0 && arr[2] != 0) {
                        count = count + 1;
                    }
                }
            }
            return count;
        }

        private int getOptimalSol(String s) {
            int lastSeen[] = { -1, -1, -1 };
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                lastSeen[s.charAt(i) - 97] = i;
                if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                    int minIndex = Math.min(lastSeen[0], lastSeen[1]);
                    count = count + (Math.min(minIndex, lastSeen[2]) + 1);
                }
            }
            return count;
        }
    }
}
// in the optimal solution we will have array such that it will conatin index of
// prev seen chars, we initialize all with -1, the moment three characters also
// changes from -1, that means we have a window which contains all 3 chars, so
// we get the min index of 3 chars, that min index and current 'i' pointer will
// be the 'all 3 chars window', so left side of that everything can be
// considered as substring of this current window
