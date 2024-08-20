import java.util.Arrays;

public class MinNumOfPlatformreqByTrains {
    public static void main(String[] args) {
        int arrival[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        Solution solution = new Solution();
        int minPlatform = solution.getMinPlatforms(arrival, dep);
        System.out.println("The min platform req to maintain all trains are : " + minPlatform);
    }

    private static class Solution {
        private int getMinPlatforms(int arrival[], int dep[]) {
            Arrays.sort(arrival);
            Arrays.sort(dep);
            int maxCount = 1;
            int count = 1;
            int i = 1, j = 0;
            while (i < arrival.length && j < dep.length) {
                if (arrival[i] <= dep[j]) {
                    count++;
                    i++;
                } else {
                    count--;
                    j++;
                }
                maxCount = Math.max(maxCount, count);
            }
            return maxCount;
        }
    }
}
// we sort the arrival and departure time.. initially we keep count that is
// platform in usage to 1 and since one train will there initially.. then we use
// 2 pointers i and j that is in arrival and departure... i will start 1 and j
// will start from 0...since we already kept train has arrived initially so we
// kept count = 1, so i will start from next arrival that is 1... keep checking
// whther the arrival time is smaller or departure time is smaller.. if arrival
// time is smaller that means one more train will come before only so increment
// counter..if departure time is smaller than curArrival then decrement the
// counter as the train will be gone..check in which place we get highest count
// and keep updating.
