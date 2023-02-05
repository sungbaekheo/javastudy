package baekjoon.sort;

import java.util.Scanner;

public class SortInside1427 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] number = sc.next().toCharArray();
        int[] numbers = new int[10];
        for(char c: number){
            numbers[Character.getNumericValue(c)]++;
        }

        for(int i=9; i>=0; i--){
            while(numbers[i] !=0){
                System.out.print(i);
                numbers[i]--;
            }
        }
    }
}
