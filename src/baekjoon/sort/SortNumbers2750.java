package baekjoon.sort;

import java.util.Scanner;

public class SortNumbers2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];

        for(int i=0; i<n; i++){
            array[i] = sc.nextInt();
        }

        for(int i=1; i<n; i++){
            int temp = array[i];
            int j = i-1;
            while(j>=0 && array[j]>temp){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
        for(int i=0; i<n; i++){
            System.out.println(array[i]);
        }
    }
}
