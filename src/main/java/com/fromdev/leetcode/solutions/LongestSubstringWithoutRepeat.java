package com.fromdev.leetcode.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeat {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeat solution = new LongestSubstringWithoutRepeat();
//        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
        System.out.println(solution.lengthOfLongestSubstring("a"));
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("au"));
        System.out.println(solution.lengthOfLongestSubstring("aub"));

    }
//sliding window
    public int lengthOfLongestSubstring2(String s) {
        if (s == null) return 0;
        if(s.length()==1) return 1;
        char[] chars = s.toCharArray();
        Map<Character, Integer> charIndexMap = new HashMap<Character, Integer>(chars.length);
        int longestCounter = 0;
        int rightPointer = 0;
        for (int leftPointer=0;leftPointer<chars.length && rightPointer < chars.length ;) {
            char ch = chars[rightPointer];
            Integer curCharLastIndex = charIndexMap.get(ch);
            if (curCharLastIndex != null && curCharLastIndex > leftPointer) {
                leftPointer++;
            } else {
                charIndexMap.put(ch,rightPointer);
                rightPointer++;
                longestCounter = Math.max(rightPointer - leftPointer ,  longestCounter);
            }
        }
        return longestCounter;
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        int n = s.length();
        if(n==1) return 1;

        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet();
        int ans = 0, leftPointer = 0, rightPointer = 0;
        while (leftPointer < n && rightPointer < n) {
            // try to extend the range [leftPointer, rightPointer]
            if (!set.contains(chars[rightPointer])){
                set.add(chars[rightPointer]);
                rightPointer++;
                ans = Math.max(ans, rightPointer - leftPointer);
            }
            else {
                set.remove(chars[leftPointer++]);
            }
        }
        return ans;
    }
}
