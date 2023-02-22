package baekjoon.bronze;

import java.util.Scanner;

public class RightTriangle4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            if(a == 0 && b == 0 && c == 0){
                break;
            }
            if(a*a + b*b == c*c){
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
