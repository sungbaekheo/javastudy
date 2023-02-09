package baekjoon.silver;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberChaining2635 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        
        int count = 0;
        for(int i=num; i>num/2; i--){
            if(num>=0){
                count++;
                System.out.print(num+" ");
            }
        }
    }
}
