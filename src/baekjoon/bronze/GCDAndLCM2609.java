package baekjoon.bronze;

import java.util.Scanner;

public class GCDAndLCM2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = 0;
        for(int i=Math.min(a,b); i>0; i--){
            if(a%i == 0 && b%i == 0){
                gcd = i;
                break;
            }
        }
        int lcm = 0;
        main: for(int i=1; i<=Math.min(a, b); i++){
            for(int j=1; j<=Math.max(a, b); j++){
                if(j*Math.min(a,b)>i*Math.max(a,b)){
                    break;
                }
                if(i*Math.max(a,b) == j*Math.min(a,b)){
                    lcm = i*Math.max(a,b);
                    break main;
                }
            }
        }

        System.out.println(gcd);
        System.out.println(lcm);
        
    }
}
