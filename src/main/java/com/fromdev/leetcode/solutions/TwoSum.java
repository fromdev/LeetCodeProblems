package com.fromdev.leetcode.solutions;

import java.util.Arrays;

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
        int[] result = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.asList(result));
    }
    public int[] twoSum(int[] nums, int target) {
        int[] result = {};
        if(nums == null || nums.length ==0 ) return result;

        int current = 0;
        while(current+1 < nums.length) {
            if(target == nums[current] + nums[current+1]){
                return new int[]{nums[current] , nums[current+1]};
            }
        }
        return result;
    }
}
