package baekjoon.bronze;

import java.util.Scanner;

public class EscapeFromRectangles1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int answer = 0;

        x = Math.min(x-0, w-x);
        y = Math.min(y-0, h-y);
        answer = Math.min(x, y);

        System.out.println(answer);
    }
}
