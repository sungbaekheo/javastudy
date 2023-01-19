package baekjoon.Conditions;

import java.util.Scanner;

public class CompareTwoNumbers1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println((num1 > num2)? ">" : (num1 < num2)? "<" : "==");
    }
}
