package com.fromdev.leetcode.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*

https://leetcode.com/problems/two-sum/description/

 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

*/



public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
//        int[] result = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] result = twoSum.twoSumBruteForce(new int[]{3,2,4}, 6);
        String display = (result.length > 1) ? result[0] + " " + result[1] : "None";
        System.out.println(display);
    }
    public int[] twoSumBruteForce(int[] nums, int target) {
        int[] result = {};
        if(nums == null || nums.length ==0 ) return result;

        int first = 0;

        while(first >= 0 && first < nums.length -1) {
            int second = first+1;
            while( second > 0 && second < nums.length) {
                int sum = nums[first] + nums[second];
                if (sum == target) {
                    return new int[]{first, second};
                }
                second++;
            }
            first++;
        }

        return result;
    }

    public int[] twoSumTwoPassHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSumOnePassHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
