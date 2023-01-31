package baekjoon.String;

import java.util.Scanner;

public class StudyingWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String word = sc.next();
        word = word.toLowerCase();
        int[] alphabet = new int[26];
        for(int i=0; i<word.length(); i++){
            alphabet[word.charAt(i) - 'a']++;
        }
        
        boolean isAlone = true;
        int max = 0;
        int idx = 0;
        for(int i=0; i<alphabet.length; i++){
            if(alphabet[i]> max){
                max = alphabet[i];
                idx = i;
            }
        }
        for(int i=0; i<alphabet.length; i++){
            if(i != idx && alphabet[i] == max){
                isAlone = false;
            }
        }
        if(isAlone){
            System.out.println(((String.valueOf((char)((char) idx + 'a'))).toUpperCase()));
        } else{
            System.out.println("?");
        }
    }
}
