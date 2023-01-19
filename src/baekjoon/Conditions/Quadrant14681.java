package baekjoon.Conditions;

import java.util.Scanner;

public class Quadrant14681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int quadrant = 0;
        if(num1 > 0){
           quadrant =  (num2 > 0) ? 1 : 4; 
        }else{
            quadrant = (num2 > 0) ? 2 : 3;
        }
        System.out.println(quadrant);
    }
}
