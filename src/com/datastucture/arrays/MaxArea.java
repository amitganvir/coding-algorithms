package com.datastucture.arrays;

public class MaxArea {

    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {

        int volume = 0;
        int startIndex = 0;
        int endIndex = height.length - 1;

        while (startIndex < endIndex) {

            int currentHeight = Math.min(height[startIndex], height[endIndex]);
            int width = endIndex - startIndex;

            volume = Math.max(volume, currentHeight * width);

            if (height[startIndex] < height[endIndex]) {
                startIndex++;
            } else {
                endIndex--;
            }
        }

        return volume;
    }

}
