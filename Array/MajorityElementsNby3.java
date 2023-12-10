//Count the number of majority elements : n/3
// only 2 possibility of elements when condition is n/3

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementsNby3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int arr[] = { 5, 4, 2, 12, 2, 4, 4, 2 };
        List<Integer> brutrForce = solution.bruteForce(arr);
        System.out.println("Majority elements n/3 in given array :");
        for (Integer val : brutrForce) {
            System.out.println(val);
        }
        List<Integer> betterApproach = solution.betterApproach(arr);
        System.out.println("Majority elements n/3 in given array :");
        for (Integer val : betterApproach) {
            System.out.println(val);
        }
        List<Integer> optimal = solution.optimalApproach(arr);
        System.out.println("Majority elements n/3 in given array :");
        for (Integer val : optimal) {
            System.out.println(val);
        }
    }

    private static class Solution {
        private List<Integer> bruteForce(int arr[]) {
            List<Integer> bruteForceList = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                int count = 0;
                if (bruteForceList.isEmpty() || bruteForceList.get(0) != arr[i]) {
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j] == arr[i])
                            count++;
                    }
                }
                if (count > arr.length / 3 && bruteForceList.size() < 2)
                    bruteForceList.add(arr[i]);
            }
            return bruteForceList;
        }

        // Using hashmap
        private List<Integer> betterApproach(int arr[]) {
            List<Integer> betterApproachList = new ArrayList<>();
            Map<Integer, Integer> hashMap = new HashMap<>();
            for (Integer ele : arr) {
                int count = hashMap.getOrDefault(ele, 0);
                hashMap.put(ele, count + 1);
                if (hashMap.get(ele) == (arr.length / 3) + 1) {
                    betterApproachList.add(ele);
                }

                if (betterApproachList.size() > 2)
                    break;
            }
            return betterApproachList;
        }

        // using Boyer Moore’s Voting Algorithm
        private List<Integer> optimalApproach(int arr[]) {
            List<Integer> optimalList = new ArrayList<>();
            // since if its n/3...there can only be 2 elements of majority
            int count1 = 0, count2 = 0, elem1 = Integer.MIN_VALUE, elem2 = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (count1 == 0 && elem2 != arr[i]) {
                    elem1 = arr[i];
                    count1 = 1;
                } else if (count2 == 0 && elem1 != arr[i]) {
                    elem2 = arr[i];
                    count2 = 1;
                } else if (arr[i] == elem1) {
                    count1++;
                } else if (arr[i] == elem2) {
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }
            count1 = 0;
            count2 = 0;
            for (Integer ele : arr) {
                if (elem1 == ele)
                    count1++;
                if (elem2 == ele)
                    count2++;
            }
            if (count1 > arr.length / 3)
                optimalList.add(elem1);
            if (count2 > arr.length / 3)
                optimalList.add(elem2);
            return optimalList;
        }
    }
}