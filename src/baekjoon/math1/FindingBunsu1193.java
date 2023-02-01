package baekjoon.math1;

import java.util.Scanner;

public class FindingBunsu1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int count = 1;
        int sum = 0;
        while(true){
            sum+=count;
            if(sum >= num){
                break;
            }
            count++;
        }
        int abs = Math.abs(sum-num);
        if((count&1)==0){
            System.out.println((count-abs)+"/"+(1+abs));
        } else{
            System.out.println((1+abs)+"/"+(count-abs));
        }
    }
}
