package com.fromdev.leetcode.solutions;

public class ZigZag {
    public static void main(String[] args) {
        ZigZag zigZag = new ZigZag();
        System.out.println(zigZag.convert("PAYPALISHIRING", 3));
        System.out.println("PAHNAPLSIIGYIR".equals(zigZag.convert("PAYPALISHIRING", 3)));
        System.out.println("PINALSIGYAHRPI".equals(zigZag.convert("PAYPALISHIRING", 4)));
        System.out.println("AB".equals(zigZag.convert("AB", 1)));

    }

    public String convert(String s, int numRows) {
        if(s == null || s.length() < numRows || numRows < 2) return s;
        StringBuilder rows[] = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        int rowIndex = 0;
        boolean forwardFlag = true;
        for (int i = 0; i < s.length(); i++) {
            if (forwardFlag) {
                rows[rowIndex].append(s.charAt(i));
                rowIndex++;
            } else {
                rows[rowIndex].append(s.charAt(i));
                rowIndex--;
            }
            if(rowIndex <= 0) {
                forwardFlag = true;
            }
            if(rowIndex >= numRows-1) {
                forwardFlag = false;
            }
        }
        StringBuilder result = new StringBuilder(s.length());
        for (StringBuilder stringBuilder : rows) {
            result.append(stringBuilder);
        }
        return result.toString();
    }
}
