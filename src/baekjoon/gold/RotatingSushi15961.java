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
            System.out.println(front+" "+rear);
            cntSushi[sushi[rear]]++;
            int innerMax = 0;

            if(innerMax > k){
                cntSushi[sushi[front]]--;
                front = (front+1)%N;
                cntSushi[sushi[front]]++;
            }
            if(cntSushi[sushi[rear]] > 1){
                while(cntSushi[sushi[rear]]>1){
                    System.out.println(front+" "+rear);
                    cntSushi[sushi[front]]--;
                    front = (front+1)%N;
                    cntSushi[sushi[front]]++;
                    break;
                }
            }
            if(rear==k-2 && front==N-1){
                break;
            }

            innerMax = Math.abs(rear-front)+1;
            if(cntSushi[c] == 0){
                innerMax++;
            }
            max = Math.max(max, innerMax);

            rear = (rear+1)%N;
        }
        System.out.println(max);
    }
}
