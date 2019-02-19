package com.fromdev.leetcode.solutions;

/**
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * ". 1" => false
 * ".e1" => false
 * "6+1" => false
 * ".-4" => false
 * " -." => false
 * "6ee69" => false
 * " 005047e+6" => true
 * "4e+" => false
 * "2e+60++604" => false
 * " -.7e+0435" => true
 * "4e+" => false
 */
public class IsNumber {


    public static void main(String[] args) {
        IsNumber isNumber = new IsNumber();
        System.out.println(isNumber.isNumber("0"));
        System.out.println(isNumber.isNumber(" 0.1 "));
        System.out.println(isNumber.isNumber("abc"));
        System.out.println(isNumber.isNumber("1 a"));
        System.out.println(isNumber.isNumber("2e10"));
        System.out.println(isNumber.isNumber(" -90e3   "));
        System.out.println(isNumber.isNumber(" 1e"));
        System.out.println(isNumber.isNumber("e3"));
        System.out.println(isNumber.isNumber(" 6e-1"));
        System.out.println(isNumber.isNumber(" 99e2.5 "));
        System.out.println(isNumber.isNumber("53.5e93"));
        System.out.println(isNumber.isNumber(" --6 "));
        System.out.println(isNumber.isNumber("-+3"));
        System.out.println(isNumber.isNumber("95a54e53"));
        System.out.println(isNumber.isNumber("."));
        System.out.println(isNumber.isNumber(" "));
        System.out.println(isNumber.isNumber(". 1"));
        System.out.println(isNumber.isNumber(".e1"));
        System.out.println(isNumber.isNumber("6+1"));
        System.out.println(isNumber.isNumber(" -."));
        System.out.println(isNumber.isNumber("6ee69"));
        System.out.println(isNumber.isNumber(" 005047e+6"));
        System.out.println(isNumber.isNumber("4e+"));
        System.out.println(isNumber.isNumber("2e+60++604"));
        System.out.println(isNumber.isNumber(" -.7e+0435"));
        System.out.println(isNumber.isNumber("4e+"));

    }



    public boolean isNumber(String s) {
        if(s == null) return false;
        s = s.trim();
        final int length = s.length();
        if(length == 0) return false;
        while(length > 1 && s.charAt(0) == ' ') s = s.substring(1,length);
        int signIndex = -1;
        int signAfterExponentIndex = -1;
        int firstNumIndex = -1;
        int dotIndex = -1;
        int exponentIndex = -1;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                return false;
            }
            if(ch == '-' || ch == '+') {
                if ((signIndex == -1 && firstNumIndex == -1 && dotIndex == -1) || (signIndex == -1 && firstNumIndex > -1 && exponentIndex > -1 && i+1 < length)) {
                    signIndex = i;
                    continue;
                } else if (signAfterExponentIndex == -1 && firstNumIndex > -1 && exponentIndex > -1 && i+1 < length) {
                    signAfterExponentIndex = i;
                    continue;
                } else {
                    //too many signs
                    return false;
                }
            }
            if(ch == '.') {
                if(dotIndex == -1 && exponentIndex == -1 && length > 1) {
                    dotIndex = i;
                    continue;
                } else {
                    //too many dots
                    return false;
                }
            }

            if (ch <= '9' && ch >= '0') {
                firstNumIndex = i;
                continue;
            }
            if (ch >= '9' || ch <= '0') {
                if(ch == 'e' ) {
                    if(i == 0 || i+1 >= length || firstNumIndex == -1 || exponentIndex > -1) {
                        return false;
                    }
                    exponentIndex = i;
                } else {
                    return false;
                }
            }

        }
        return firstNumIndex > -1;
    }
}
