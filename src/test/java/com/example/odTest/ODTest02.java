package com.example.odTest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ODTest02 {

    public  void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
    public  void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }
    @Test
    public void Test(){

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String> words = new ArrayList<>();
        for(int i = 0; i <n; i++){
            words.add(sc.nextLine());
        }
        System.out.println(findWords(words, sc.nextLine()));
    }

    public static int findWords(List<String> words, String chars){
        int res =0, wordIndex = 0, charIndex = 0;
        boolean isMastered = true;
        while(wordIndex <words.size() && charIndex < chars.length()){
            if(chars.charAt(charIndex) == '?'){
                isMastered &= (charIndex == chars.length()-1)||(chars.charAt(charIndex+1)  == '?');
            }else{
                if(charIndex < words.get(wordIndex).length()) {
                    isMastered &= chars.charAt(charIndex) == words.get(wordIndex).charAt(charIndex);
                }
            }
            if(isMastered){
                res ++;
                charIndex ++;
                wordIndex ++;
            }else{
                charIndex ++;
            }
        }
        return res;
    }


}
