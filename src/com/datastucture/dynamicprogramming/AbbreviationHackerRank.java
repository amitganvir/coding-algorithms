package com.datastucture.dynamicprogramming;

import java.util.Arrays;

public class AbbreviationHackerRank {

    public static void main(String[] args) {
        System.out.println(abbreviationv2("ETAUMPZFGJVEUUBFDIMJPMOCRQXMMMYPUKFRJLCXOCLMUMMUHQNKIAZSKHRLPNhRRPmNIBNCHRZBYWAPUNMDFGPDKQUBZYPEIZILJEHNZGHSNSRZACYCKQSSFHEDYCMVAovcuyjahwtmgcctvjqnpgwrurwnmbifbtyqyuoafezegpecjgmkwfstjwlkromioak", "ETAUMPZFGJVEUUBFDIMJPMOCRQXMMMYPUKFRJLCXOCLMUMMUHQNKIAZSKHRLPNRRPNIBNCHRZBYWAPUNMDFGPDKQUBZYPEIZILJEHNZGHSNSRZACYCKQSSFHEDYCMVA"));
    }

    public static String abbreviationv2(String a, String b) {
        int[] charARepArray = new int[128];
        for (int i = 0; i < a.length(); i++) {
            charARepArray[a.charAt(i)] += 1;
        }

        for (int i = 0; i < b.length(); i++) {

            char bChar = b.charAt(i);

            if (charARepArray[bChar] > 0 || charARepArray[Character.toLowerCase(bChar)] > 0) {
                if (charARepArray[bChar] > 0) {
                    charARepArray[bChar] -= 1;
                } else {
                    charARepArray[Character.toLowerCase(bChar)] -= 1;
                }
            } else {
                return "NO";
            }
        }

        for (int i = 0; i < charARepArray.length; i++) {
            if (Character.isUpperCase(i) && charARepArray[i] > 0) {
                return "NO";
            }
        }

        return "YES";
    }
}
