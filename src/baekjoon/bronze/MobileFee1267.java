package baekjoon.bronze;

import java.util.Scanner;

public class MobileFee1267 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Y = 0;
        int M = 0;
        for(int i=0; i<N; i++){
            int t = sc.nextInt();
            Y+=t%30 == 0? (t/30+1)*10:t/30*10;
            M+=t%60 == 0? (t/60+1)*15:t/60*15;
        }

        if(Y<M){
            System.out.println("Y "+Y);
        } else if(Y == M){
            System.out.println("Y M "+Y);
        } else{
            System.out.println("M "+M);
        }
    }
}
