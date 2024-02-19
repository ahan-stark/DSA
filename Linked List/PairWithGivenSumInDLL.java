//the given DLL is sorted
public class PairWithGivenSumInDLL {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        int sum = 5;
        DoubleNode head = new DoubleNode(arr[0]);
        DoubleNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            DoubleNode temp = new DoubleNode(arr[i]);
            cur.next = temp;
            temp.prev = cur;
            cur = cur.next;
        }
        // brute force solution
        System.out.println("Brute Force ");
        solution.bruteForce(head, sum);
        // optiaml solution
        System.out.println("Optimal Solution ");
        solution.optimalSol(head, sum);

    }

    private static class Solution {
        private void bruteForce(DoubleNode head, int sum) {
            DoubleNode temp1 = head;
            while (temp1 != null) {
                DoubleNode temp2 = temp1.next;
                while (temp2 != null && temp1.data + temp2.data <= sum) {
                    if (temp1.data + temp2.data == sum) {
                        System.out.println(temp1.data + " : " + temp2.data);
                    }
                    temp2 = temp2.next;
                }
                temp1 = temp1.next;
            }
        }

        private void optimalSol(DoubleNode head, int sum) {
            // as the given DLL is sorted we keep on pointer at start and the other pointer
            // at last , if the sum of 2 pointers is greater, we move the last pointer
            // backwards, if the sum is lesser, then we move the first pointer towards right
            DoubleNode front = head;
            DoubleNode last = head;
            while (last.next != null) {
                last = last.next;
            }
            // we stop traversing when the last cross the front
            while (front.data < last.data) {
                if (front.data + last.data == sum) {
                    System.out.println(front.data + " : " + last.data);
                    front = front.next;
                    last = last.prev;
                }
                if (front.data + last.data < sum) {
                    front = front.next;
                }
                if (front.data + last.data > sum)
                    last = last.prev;
            }
        }

    }

    private static class DoubleNode {
        int data;
        DoubleNode prev;
        DoubleNode next;

        DoubleNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}
