package baekjoon.loop;

import java.util.Scanner;

public class AddCycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int initial = sc.nextInt();
        String num = String.valueOf(initial);
        if(initial < 10){
            num = "0"+num;
        }
        int cycle = 0;
        int numSum = 100;
        while(initial != numSum){
            char[] number = num.toCharArray();
            int temp = Integer.parseInt(String.valueOf(number[0])) + Integer.parseInt(String.valueOf(number[1]));
            num = String.valueOf(number[1])+(temp%10);
            numSum = Integer.parseInt(num);
            cycle++;
        }
        System.out.println(cycle);
    }
}
