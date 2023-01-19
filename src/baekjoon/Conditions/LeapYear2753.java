package baekjoon.Conditions;

import java.util.Scanner;

public class LeapYear2753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();
        int isLeap = 0;
        if(year%4 == 0){
            if(year%100 == 0){
                if(year%400 == 0){
                    isLeap = 1;
                }
            }else{
                isLeap = 1;
            }
        }
        System.out.println(isLeap);
    }
}
