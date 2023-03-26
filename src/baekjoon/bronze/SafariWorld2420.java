package baekjoon.bronze;

import java.util.Scanner;

public class SafariWorld2420 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextInt();
        long M = sc.nextInt();

        System.out.println(Math.abs(N-M));
    }
}
