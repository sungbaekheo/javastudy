package baekjoon.bronze;

import java.util.Scanner;

public class AIClock2530 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        int time = sc.nextInt();

        int temp = 0;
        temp = (s+time)/60;
        s = (s+time)%60;
        time = (m+temp)/60;
        m = (m+temp)%60;
        h = (h+time)%24;

        System.out.println(h+" "+m+" "+s);
    }
}
