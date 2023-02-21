package baekjoon.bronze;

import java.util.Scanner;

public class ChangeBall10813 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int round = sc.nextInt();
        int[] arr = new int[size];

        for(int i=0; i<size; i++){
            arr[i] = i+1;
        }
        for(int i=0; i<round; i++){
            int p1 = sc.nextInt()-1;
            int p2 = sc.nextInt()-1;
            swap(arr, p1, p2);
        }

        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
    }

    static void swap(int[] arr, int a, int b){
        int temp = 0;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
