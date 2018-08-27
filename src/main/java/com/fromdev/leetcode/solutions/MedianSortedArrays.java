package com.fromdev.leetcode.solutions;

import java.util.Arrays;

public class MedianSortedArrays {

    public static void main(String[] args) {
        MedianSortedArrays solution = new MedianSortedArrays();
        int num1[] = {1,3};
        int num2[] = {2};
        System.out.println(solution.findMedianSortedArrays(num1,num2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int all [] = new int[nums1.length + nums2.length];
        System.arraycopy(nums1,0,all,0,nums1.length);
        System.arraycopy(nums2,0,all,nums1.length,nums2.length);
        Arrays.sort(all);
      //  printArray(all);
        double median = (all.length % 2 == 0) ? (all[all.length / 2 - 1] + all[(all.length / 2)]) / 2.0d : all[all.length/2];
        return median;
    }


    private void printArray(int[] arr) {
        for(int i: arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }
}
