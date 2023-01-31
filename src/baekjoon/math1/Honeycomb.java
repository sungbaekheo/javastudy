package baekjoon.math1;

import java.util.Scanner;

public class Honeycomb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 1;
        int border = 1;
        while(n > border){
            border+=count*6;
            count++;
        }
        System.out.println(count);
    }
}