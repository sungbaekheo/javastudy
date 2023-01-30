package baekjoon.array;

import java.util.Scanner;

public class NotSubmited {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numList = new int[31];

        for(int i=0; i<28; i++){
            numList[sc.nextInt()]++;
        }

        for(int i=1; i<=30; i++){
            if(numList[i] == 0){
                System.out.println(i);
            }
        }
    }
}
