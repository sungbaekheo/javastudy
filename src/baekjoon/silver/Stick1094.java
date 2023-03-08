package baekjoon.silver;

import java.util.Scanner;

public class Stick1094 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int stick = 64;
        int goal = sc.nextInt();
        int count = 0;
        while(goal>0){
            if(stick>goal){
                stick/=2;
            } else {
                count++;
                goal-=stick;
            }
        }
        System.out.println(count);
    }
}
