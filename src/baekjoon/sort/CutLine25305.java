package baekjoon.sort;

import java.util.Scanner;

public class CutLine25305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] scoreList = new int[n];

        for(int i=0; i<n; i++){
            scoreList[i] = sc.nextInt();
        }

        for(int i=0; i<k; i++){
            int max = scoreList[i];
            int idx = 0;
            for(int j=i+1; j<n; j++){
                if(scoreList[j]>max){
                    max = scoreList[j];
                    idx = j;
                }
            }
            scoreList[idx] = scoreList[i];
            scoreList[i] = max;
        }

        System.out.println(scoreList[k-1]);


    }
}
