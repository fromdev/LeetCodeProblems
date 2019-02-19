package com.fromdev.leetcode.solutions;

public class StringToInteger {
    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.myAtoi("42"));
        System.out.println(stringToInteger.myAtoi("   -42"));
        System.out.println(stringToInteger.myAtoi("4193 with words"));
        System.out.println(stringToInteger.myAtoi("words and 987"));
        System.out.println(stringToInteger.myAtoi("-91283472332"));
        System.out.println(stringToInteger.myAtoi("3.14159"));
        System.out.println(stringToInteger.myAtoi("+1"));
        System.out.println(stringToInteger.myAtoi("+-1"));
        System.out.println(stringToInteger.myAtoi("  -0012a42"));
        System.out.println(stringToInteger.myAtoi("   +0 123"));
        System.out.println(stringToInteger.myAtoi("2147483648"));
        System.out.println(stringToInteger.myAtoi("-   234"));
        System.out.println(stringToInteger.myAtoi("0-1"));
        System.out.println(stringToInteger.myAtoi("123-"));

    }
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int number = 0;
        boolean negativeSign = false;
        int signIndex = -1;
        int firstDigitIndex = -1;
        boolean overflow = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                if(firstDigitIndex > -1 || signIndex > -1) {
                    break;
                } else {
                    continue;
                }
            }else if (ch == '.') {
                break;
            } else if (ch == '-') {
                if(signIndex == -1 && firstDigitIndex == -1) {
                    negativeSign = true;
                    signIndex = i;
                } else {
                    break;
                }
            } else if (ch == '+') {
                if(signIndex == -1  && firstDigitIndex == -1) {
                    signIndex = i;
                } else {
                    break;
                }
            } else if (ch <= '9' && ch >= '0') {
                final int num = ch - '0';
                int numTimesTen = number * 10 + num;
                if(((numTimesTen -num)/10) != number || numTimesTen < number) {
                    overflow = true;
                    break;
                }
                number = numTimesTen;
                if(firstDigitIndex == -1) {
                    firstDigitIndex = i;
                }
            } else if((ch >= '9' || ch <= '0')) {
                //invalid char found before number
                break;
            }
        }
        if(overflow) {
            if(negativeSign) {
                number = Integer.MIN_VALUE;
            } else {
                number = Integer.MAX_VALUE;
            }
        } else {
            number = (negativeSign) ? number * -1 : number;
        }
        return number;

    }

}
