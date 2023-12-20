package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class LeetCode0006 {

    @Test
    public void test() {
        System.out.println(convert1("PAYPALISHIRING", 3));
        System.out.println(convert1("A", 2));
        System.out.println(convert1("ABCDE", 4));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length(), row = len / (2 * numRows - 2) * numRows + numRows;
        char[][] chars = new char[row][numRows];
        int index = 0;
        char[] chars1 = s.toCharArray();
        for (int i = 0; i < row; i++) {
            if (index < len) {
                if (i % (numRows - 1) == 0) {
                    for (int j = 0; j < numRows; j++) {
                        if (index < len) {
                            chars[i][j] = chars1[index++];
                        } else {
                            break;
                        }
                    }
                } else {
                    chars[i][numRows - i % (numRows - 1) - 1] = chars1[index++];
                }
            } else {
                break;
            }
        }
        String result = new String();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < row; j++) {
                if (chars[j][i] != 0) {
                    result += chars[j][i];
                }
            }
        }
        return result;
    }

    public String convert1(String s, int numRows) {
        if(numRows <2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == numRows - 1 || i == 0) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder str : rows) {
            result.append(str);
        }
        return result.toString();
    }
}
