package baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class SwapingBasket10811{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int round = sc.nextInt();

        int[] basket = new int[size];

        for(int i=0; i<size; i++){
            basket[i] = i+1;
        }

        for(int i=0; i<round; i++){
            int start = sc.nextInt()-1;
            int end = sc.nextInt()-1;
            int[] copied = Arrays.copyOfRange(basket, start, end+1);
            for(int j=start; j<=end; j++){
                basket[j] = copied[end-j];
            }
        }
        for(int i:basket){
            System.out.print(i+" ");
        }
    }
}