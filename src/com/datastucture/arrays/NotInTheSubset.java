package com.datastucture.arrays;

public class NotInTheSubset {

    public static void main(String[] args) {
        NotInTheSubset notInTheSubset = new NotInTheSubset();
        notInTheSubset.minPositiveNumberNotSumOfSubset(new int[]{1,2,3,10});
    }

    public int minPositiveNumberNotSumOfSubset(int[] arr) {
        int target = 1; // Initialize result

        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i] > target){
                return target;
            }
            else{
                target+=arr[i];
            }
        }

        System.out.println(target);

        return target;

    }
}
