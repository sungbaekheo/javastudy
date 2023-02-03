package baekjoon.sort;

import java.util.Scanner;

public class RepresentativeNum2587 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numList = new int[5];
        int sum = 0;
        for(int i=0; i<5; i++){
            numList[i] = sc.nextInt();
            sum+=numList[i];
        }

        for(int i=0; i<4; i++){
            int min = numList[i];
            int idx = 0;
            for(int j=i+1; j<5; j++){
                if(numList[j]<min){
                    min = numList[j];
                    idx = j;
                }
            }
            numList[idx] = numList[i];
            numList[i] = min;
        }
        System.out.println(sum/5);
        System.out.println(numList[2]);
    }
}
