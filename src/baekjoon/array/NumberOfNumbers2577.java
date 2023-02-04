package baekjoon.array;

import java.util.Scanner;

public class NumberOfNumbers2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = 1;
        for(int i=0; i<3; i++){
            num*=sc.nextInt();
        }
        char[] number = String.valueOf(num).toCharArray();
        int[] numList = new int[10];

        for(int i=0; i<number.length; i++){
            int idx = Character.getNumericValue(number[i]);
            numList[idx]++;
        }

        for(int i=0; i<10; i++){
            System.out.println(numList[i]);
        }
    }
}
