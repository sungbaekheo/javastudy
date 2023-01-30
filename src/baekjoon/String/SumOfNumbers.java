package baekjoon.String;

import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] number = sc.next().toCharArray();
        int sum = 0;
        for(char c:number){
            sum+=Character.getNumericValue(c);
        }
        System.out.println(sum);
    }
}
