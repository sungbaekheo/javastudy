package baekjoon.array;

import java.util.Scanner;

public class Counting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numList = new int[sc.nextInt()];
        for(int i=0; i<numList.length; i++){
            numList[i] = sc.nextInt();
        }
        int num = sc.nextInt();
        int count = 0;
        for(int i=0; i<numList.length; i++){
            if(numList[i] == num){
               count++; 
            }
        }
        System.out.println(count);
    }
}
