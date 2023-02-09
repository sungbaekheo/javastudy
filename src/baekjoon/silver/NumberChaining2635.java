package baekjoon.silver;

import java.util.Scanner;

public class NumberChaining2635 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int maxCount = 0;
        String answer = "";
        for(int i=num; i>num/2; i--){
            int initialNum = num;
            int numberChain = i;
            int count = 0;
            String numList = "";
            while(initialNum >= 0){
                numList += initialNum+" ";
                int temp = initialNum-numberChain;
                initialNum = numberChain;
                numberChain = temp;
                count++;
            }
            if(count>maxCount){
                maxCount = count;
                answer = numList;
            }
            if(count<maxCount){
                break;
            }
        }
        System.out.println(maxCount);
        System.out.println(answer);
    }
}