import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementsUsing2arr {
    public static void main(String[] args) {
        int nums1[] = { 4, 1, 2 };
        int nums2[] = { 1, 3, 4, 2 };
        Solution solution = new Solution();
        int optimalSol[] = solution.optimalSol(nums1, nums2);
        System.out.println("Optimal Solution : ");
        for (int val : optimalSol) {
            System.out.println(val);
        }
    }

    // solved using monotonic approach
    private static class Solution {
        private int[] optimalSol(int nums1[], int nums2[]) {
            HashMap<Integer, Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = nums2.length - 1; i >= 0; i--) {
                if (stack.isEmpty()) {
                    stack.push(nums2[i]);
                    map.put(nums2[i], -1);
                } else if (stack.peek() > nums2[i]) {
                    map.put(nums2[i], stack.peek());
                    stack.push(nums2[i]);
                } else {
                    while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                        stack.pop();
                    }
                    if (stack.isEmpty())
                        map.put(nums2[i], -1);
                    else
                        map.put(nums2[i], stack.peek());
                    stack.push(nums2[i]);
                }
            }
            int ans[] = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                ans[i] = map.get(nums1[i]);
            }
            return ans;
        }
    }
}
// find the next greater elem of nums2 and for each of nums2 val, put nums2 val
// and its next greater elem in HashMap, then iterate through nums1 and for each
// val of nums1, get the map.get() of nums1 val , it wil get the value from
// hashmap the corresponding next greater element
