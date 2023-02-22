package baekjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

public class K1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size*size+1];
    
        for(int r=1; r<=size; r++){
            for(int c=1; c<=size; c++){
                arr[(c-1)+(r-1)*size] = r*c;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
