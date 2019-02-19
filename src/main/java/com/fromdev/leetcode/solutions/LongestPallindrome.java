package com.fromdev.leetcode.solutions;

//Key idea, every time we move to right, we only need to consider
// whether using this new character as tail could produce
// new palindrome string of length (current length +1) or (current length +2)
//103 / 103 test cases passed.
//Status: Accepted
//Runtime: 22 ms
public class LongestPallindrome {

    public static void main(String[] args) {
        LongestPallindrome solution = null;
//        System.out.println(solution.isPallindrome("aaaaaba",0,4));
        System.out.println(solution.longestPalindrome("ccc"));
        System.out.println(solution.longestPalindrome("abab"));
    }
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2) return s;
        int resultStart = 0;
        int resultEnd = 0;
        int lastBiggestPallindromeLength = 0;
        for (int i=0; i < s.length(); i++) {
            int j = i - lastBiggestPallindromeLength ;
            int k = i - lastBiggestPallindromeLength - 1;
            if(isPallindrome(s,j,i)){
                int pallindromeLength = i - j + 1;
                if(pallindromeLength >= lastBiggestPallindromeLength) {
                    lastBiggestPallindromeLength = pallindromeLength;
                    resultStart = j;
                    resultEnd = i;
                }
            }
            if(isPallindrome(s,k,i)){
                int pallindromeLength1 = i - k + 1;
                if(pallindromeLength1 >= lastBiggestPallindromeLength) {
                    lastBiggestPallindromeLength = pallindromeLength1;
                    resultStart = k;
                    resultEnd = i;
                }
            }
        }
        return s.substring(resultStart,resultEnd+1);
    }

    public boolean isPallindrome(String s, int begin, int end) {
        if(begin < 0 ) return false;
        while(begin < end) {
            if(s.charAt(begin) != s.charAt(end)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
