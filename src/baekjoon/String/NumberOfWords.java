package baekjoon.String;

import java.util.Scanner;

public class NumberOfWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine();
        int count = 1;
        if(sentence.charAt(0) == ' '){
            count--;
        }
        if(sentence.charAt(sentence.length()-1) == ' '){
            count--;
        }
        for(int i=0; i<sentence.length(); i++){
            if(sentence.charAt(i) == ' '){
                count++;
            };
        }
        System.out.println(count);
    }
}
