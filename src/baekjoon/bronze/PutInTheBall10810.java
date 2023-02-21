package baekjoon.bronze;

import java.util.Scanner;

public class PutInTheBall10810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int round = sc.nextInt();
        int[] arr = new int[size];

        for(int i=0; i<round; i++){
            int start = sc.nextInt()-1;
            int end = sc.nextInt()-1;
            int value = sc.nextInt();

            for(int j=start; j<=end; j++){
                arr[j] = value;
            }
        }

        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
