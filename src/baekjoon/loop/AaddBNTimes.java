package baekjoon.loop;

import java.util.Scanner;

public class AaddBNTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int loop = sc.nextInt();
        for(int i=0; i<loop; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(a + b);
        }
    }
}
