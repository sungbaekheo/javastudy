package baekjoon.loop;

import java.util.Scanner;

public class TestCaseAaddB2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int i=1; i<=testCase; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.printf("Case #%d: %d + %d = %d\n", i, a, b, a+b);
        }
    }
}
