package baekjoon.gold;

import java.util.Scanner;

public class RotatingSushi15961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();
        int[] sushi = new int[N];
        int[] cntSushi = new int[d+1];

        int front = 0;
        int rear = 0;
        int max = Integer.MIN_VALUE;
        while(true){
            int innerMax = 0;
            if(Math.abs(rear-front)+1 > k){
                cntSushi[front++]--;
            }
            while()
            if(rear==k-2 && front==N-1){
                break;
            }
        }
    }
}
