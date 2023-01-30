package baekjoon.array;

import java.util.Scanner;

public class MaxNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numList = new int[9];
        int max = 0;
        int idx = 0;

        for(int i=0; i<9; i++){
            numList[i] = sc.nextInt();
        }
        for(int i=0; i<9; i++){
            if(numList[i]>max){
                max = numList[i];
                idx = i;
            }
        }

        System.out.println(max);
        System.out.println(idx+1);
    }
}
