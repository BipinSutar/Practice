package com.bipin.practice.leetcode;

public class MedianofTwoSortedArrays_4 {
    public static void main(String[] args) {
        System.out.println(new MedianofTwoSortedArrays_4().findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        boolean isEven = (totalLength & 1) == 0;

        int i = 0;
        int j = 0;

        int half = totalLength / 2;
        int prev = 0;


        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {

                if (i + j == half) {

                    if (isEven) {
                        return (nums1[i] + prev) / 2.0d;
                    }
                    return nums1[i];
                }
                prev = nums1[i];
                i++;

            } else {

                if (i + j == half) {

                    if (isEven) {
                        return (nums2[j] + prev) / 2.0d;
                    }
                    return nums2[j];
                }
                prev = nums2[j];
                j++;


            }


        }
        while (i < nums1.length) {
            if (i + j == half) {

                if (isEven) {
                    return (nums1[i] + prev) / 2.0d;
                }
                return nums1[i];
            }
            prev = nums1[i];
            i++;
        }
        while (j < nums2.length) {
            if (i + j == half) {

                if (isEven) {
                    return (nums2[j] + prev) / 2.0d;
                }
                return nums2[j];
            }
            prev = nums2[j];
            j++;

        }

        return -1;

    }
}
