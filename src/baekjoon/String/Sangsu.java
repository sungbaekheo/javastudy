package baekjoon.String;

import java.util.Scanner;

public class Sangsu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        String temp = String.valueOf(a.charAt(2)) + String.valueOf(a.charAt(1)) + String.valueOf(a.charAt(0));
        a = temp;
        temp = String.valueOf(b.charAt(2)) + String.valueOf(b.charAt(1)) + String.valueOf(b.charAt(0));
        b = temp;
        System.out.println((Integer.parseInt(a) > Integer.parseInt(b))? Integer.parseInt(a) : Integer.parseInt(b));
    }
}
