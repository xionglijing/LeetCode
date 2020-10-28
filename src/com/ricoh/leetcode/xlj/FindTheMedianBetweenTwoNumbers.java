package com.ricoh.leetcode.xlj;

import java.util.Arrays;

/**
 * 寻找两数组中的中位数
 */
public class FindTheMedianBetweenTwoNumbers {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < 0 || nums1.length > 1000 || nums2.length < 0 || nums2.length > 1000) {
            throw new IndexOutOfBoundsException();
        }
        if (nums1.length == 0 && nums2.length == 1) {
            return nums2[0];
        }
        if (nums1.length == 1 && nums2.length == 0) {
            return nums1[0];
        }
        int sum = 0;
        int[] newNum = new int[nums1.length + nums2.length];

        for (int i = 0; i < newNum.length; i++) {
            if (i < nums1.length) {
                newNum[i] = nums1[i];
            } else {
                newNum[i] = nums2[nums2.length - newNum.length + i];
            }
        }
        Arrays.sort(newNum);
        int length = nums1.length + nums2.length;
        if ((length + 1)%2 == 0) {
            return newNum[length / 2];
        } else {
            return (newNum[length / 2] + newNum[length / 2 -1]) / 2.0;
        }
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums1 = {0,0,0,0,0};
        int[] nums2 = {-1,0,0,0,0,0,1};
        System.out.println(findMedianSortedArrays(nums1,nums2));
        System.out.println(System.currentTimeMillis() - start);
    }
}
