package baekjoon.math1;

import java.util.Scanner;

public class BreakEvenPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fixed = sc.nextInt();
        int product = sc.nextInt();
        int price = sc.nextInt();

        if(product >= price){
            System.out.println(-1);
        }else{
            System.out.println(fixed/(price-product)+1);
        }
    }
}
