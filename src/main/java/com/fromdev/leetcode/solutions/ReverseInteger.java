package com.fromdev.leetcode.solutions;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println( reverseInteger.reverse(123));
        System.out.println( reverseInteger.reverse(123456789));
        System.out.println( reverseInteger.reverse(Integer.MAX_VALUE));
        System.out.println( reverseInteger.reverse(Integer.MIN_VALUE));
        System.out.println( reverseInteger.reverse(-123));
//        System.out.println(Integer.MAX_VALUE % 10);
//        System.out.println(Integer.MIN_VALUE % 10);
    }

    public int reverse(int input) {
        int output = 0;
        int max = Integer.MAX_VALUE / 10;
        int maxReminder = Integer.MAX_VALUE % 10;
        int minReminder = Integer.MIN_VALUE % 10;
        int min = Integer.MIN_VALUE / 10;

        while(input != 0) {
            int reminder = input % 10;
            if(output > max || (output == Integer.MAX_VALUE && reminder > maxReminder)) return 0;
            if(output < min || (output == Integer.MIN_VALUE && reminder < minReminder)) return 0;

            output = output * 10 + reminder;
            input = input/10;
        }
        return output;
    }
}
