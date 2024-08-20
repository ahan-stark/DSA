import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NMeetingsInOneRoom {
    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        Solution solution = new Solution();
        int maxMeetings = solution.getMaxMeetingsPossible(start, end);
        System.out.println("Max meetings possible is : " + maxMeetings);

    }

    private static class Solution {
        private int getMaxMeetingsPossible(int[] start, int[] end) {
            List<Pairs> list = new ArrayList<>();
            for (int i = 0; i < start.length; i++) {
                list.add(new Pairs(start[i], end[i]));
            }
            list.sort(new Comparator<Pairs>() {
                @Override
                public int compare(Pairs a, Pairs b) {
                    return a.end - b.end;
                }
            });
            // initially first meeting will happen
            int count = 1;
            int lastEnd = list.get(0).end;
            for (int i = 1; i < start.length; i++) {
                if (list.get(i).start > lastEnd) {
                    count++;
                    lastEnd = list.get(i).end;
                }
            }

            return count;
        }

        private static class Pairs {
            int start;
            int end;

            public Pairs(int start, int end) {
                this.start = start;
                this.end = end;
            }

        }

    }
}
// To maximize the number of possible meetings, we first sort the meetings by
// their end times. We start by scheduling the first meeting and set the last
// ending time to this meeting's end time. As we go through the sorted list, if
// a meeting's start time is later than the last ending time, we schedule it,
// increment the count, and update the last ending time to the end time of this
// meeting.