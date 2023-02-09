package com.datastucture.arrays;

public class MergeSortedArrays {

    public static void main(String[] args) {

        //new MergeSortedArrays().merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 2);


        //new MergeSortedArrays().merge(new int[]{2, 0}, 1, new int[]{1}, 1);
        //new MergeSortedArrays().merge(new int[]{1}, 1, new int[]{}, 0);
        //new MergeSortedArrays().merge(new int[]{1, 2, 4, 5, 6, 0}, 5, new int[]{3}, 1);
        //new MergeSortedArrays().merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
        new MergeSortedArrays().merge(new int[]{4, 0, 0, 0, 0, 0}, 1, new int[]{1, 2, 3, 5, 6}, 5);
        //new MergeSortedArrays().merge(new int[]{-1, 0, 0, 3, 3, 3, 0, 0, 0}, 6, new int[]{1, 2, 2}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m - 1;
        int p2 = n - 1;
        int i = m + n -1;

        while (p2 >= 0) {

            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i--] = nums1[p1--];
            } else {
                nums1[i--] = nums2[p2--];
            }
        }
    }

}
