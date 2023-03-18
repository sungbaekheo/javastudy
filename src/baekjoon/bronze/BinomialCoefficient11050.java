package baekjoon.bronze;

import java.util.Scanner;

public class BinomialCoefficient11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int answer = 1;
        for(int i=n; i>=1; i--){
            answer*=i;
        }
        for(int i=n-k; i>=1; i--){
            answer/=i;
        }
        for(int i=k; i>=1; i--){
            answer/=i;
        }

        System.out.println(answer);
    }
}
