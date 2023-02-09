package baekjoon.bronze;

import java.util.Scanner;

public class SuperMario2851 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mushPoint = 0;
        int minAbs = 100;
        int answer = 0;
        for(int i=0; i<10; i++){
            mushPoint+=sc.nextInt();
            if(minAbs >= Math.abs(100-mushPoint)){
                minAbs = Math.abs(100-mushPoint);
                answer = mushPoint;
            }
        }
        System.out.println(answer);
    }
}
