package com.example.odTest;

import java.util.Scanner;

public class ODTest03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        System.out.println( maxSubString(in.nextLine()) );
    }

    public static int maxSubString(String s){
        if(s == null || s.length() ==0){
            return 0;
        }
        int maxLen = 1, currLen = 1, firstDigit = -1, lastLetterIndex = -1, letterCount =0;
        for(int i =1 ; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)){
                letterCount ++;
                if(lastLetterIndex == 1){
                    lastLetterIndex = i;
                }
            }else{
                if(letterCount==1 && firstDigit != -1){
                    int len = i-firstDigit;
                    if(len > maxLen){
                        maxLen =len;
                    }
                    firstDigit = -1;
                }else if(letterCount >1){
                    letterCount --;
                }
            }
            currLen ++;
        }
        if(letterCount ==1&& firstDigit != -1 && lastLetterIndex != -1){
            int len =lastLetterIndex -firstDigit;
            if(len > maxLen){
                maxLen =len;
            }
        }
        return maxLen;
    }
}
