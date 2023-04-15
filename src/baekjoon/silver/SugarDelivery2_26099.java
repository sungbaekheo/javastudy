package baekjoon.silver;

import java.math.BigInteger;
import java.util.Scanner;

public class SugarDelivery2_26099 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long answer = 0;

        while(N%5 !=0){
            N-=3;
            answer++;
        }

        if(N<0){
            System.out.println(-1);
        } else {
            System.out.println(N/5 + answer);
        }
    }
}
