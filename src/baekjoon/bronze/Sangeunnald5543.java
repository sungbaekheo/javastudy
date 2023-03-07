package baekjoon.bronze;

import java.util.Scanner;

public class Sangeunnald5543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int burger = 2000;
        int coke = 2000;

        for(int i=0; i<3; i++){
            burger = Math.min(burger, sc.nextInt());
        }
        for(int i=0; i<2; i++){
            coke = Math.min(coke, sc.nextInt());
        }

        System.out.println(burger+coke-50);
    }
}
