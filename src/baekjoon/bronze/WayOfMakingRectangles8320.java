package baekjoon.bronze;

import java.util.Scanner;

public class WayOfMakingRectangles8320 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int count = 0;
        for(int i=1; i<=num; i++){
            for(int j=1; j<=Math.sqrt(i); j++){
                if(i%j == 0){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
