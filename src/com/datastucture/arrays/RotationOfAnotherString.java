package com.datastucture.arrays;

import java.util.TreeSet;

public class RotationOfAnotherString {

    public static void main(String[] args) {
        System.out.println(solve("uznkazlhidbwgu", "bwguuznkazlhid"));
    }

    private static boolean solve(String firstString, String secondString) {

        if (firstString == null || secondString == null || firstString.length() != secondString.length()) {
            return false;
        }

        String shiftedString = secondString;
        for (int i = 0; i < firstString.length(); i++) {
            shiftedString = shiftByOne(shiftedString);
            if (shiftedString.equals(firstString)) {
                return true;
            }
        }


        return false;
    }

    private static String shiftByOne(String shiftString) {
        return shiftString.substring(1) + shiftString.charAt(0);
    }
}
