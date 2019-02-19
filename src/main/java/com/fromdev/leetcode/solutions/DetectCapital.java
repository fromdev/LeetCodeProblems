package com.fromdev.leetcode.solutions;

/**
 * "USA" true
 * "Google" true
 *  google true
 *  "gooGle false
 *
 *  Success
 * Details
 * Runtime: 19 ms, faster than 36.18% of Java online submissions for Detect Capital.
 * Memory Usage: 38 MB, less than 100.00% of Java online submissions for Detect Capital.
 *
 */
public class DetectCapital {
    public static void main(String[] args) {
        DetectCapital detectCapital = new DetectCapital();
        System.out.println(detectCapital.detectCapitalUse("USA"));
        System.out.println(detectCapital.detectCapitalUse("Google"));
        System.out.println(detectCapital.detectCapitalUse("google"));
        System.out.println(detectCapital.detectCapitalUse("gooGle"));

    }
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        boolean isFirstLetterCap = (len > 0 && isCapital(word.charAt(0)));
        boolean isSecondLetterCap = (len > 1 && isCapital(word.charAt(1)));
        if((!isFirstLetterCap && isSecondLetterCap )) return false;
        boolean allcaps = isSecondLetterCap;
        for (int i=2;i < len ; i++) {
            char ch = word.charAt(i);
            if(isLower(ch) && allcaps) {
                return false;
            }

            if(isCapital(ch) && !allcaps) {
                return false;
            }
        }
        return true;
    }

    private boolean isLower(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public boolean isCapital(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
}
