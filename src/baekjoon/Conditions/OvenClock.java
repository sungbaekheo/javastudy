package baekjoon.Conditions;

import java.util.Scanner;

public class OvenClock {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int min = sc.nextInt();
        int times = sc.nextInt();
        min+=times;

        System.out.printf("%d %d", (hour+min/60)%24, min%60);
    }
}
