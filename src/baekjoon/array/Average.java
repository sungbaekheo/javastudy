package baekjoon.array;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];
        int max = 0;

        for(int i=0; i<n; i++){
            scores[i] = sc.nextInt();
            if(scores[i]>max){
                max = scores[i];
            }
        }
        double sum = 0;
        for(int i=0; i<n; i++){
            sum+=((double) scores[i]/max*100);
        }

        System.out.println(sum/n);
    }
}
