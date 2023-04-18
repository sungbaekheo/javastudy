package baekjoon.bronze;

import java.util.Scanner;

public class TestScore5596 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int minkook = 0;
        int mansei = 0;

        for(int i=0; i<4; i++){
            minkook+=sc.nextInt();
        }

        for(int i=0; i<4; i++){
            mansei+=sc.nextInt();
        }

        System.out.println(minkook>=mansei? minkook:mansei);
    }
}
