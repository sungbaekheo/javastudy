package baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class SevenDwarfs2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dwarfs = new int[9];
        int sum = 0;
        for(int i=0; i<9; i++){
            dwarfs[i] = sc.nextInt();
            sum+=dwarfs[i];
        }
        Arrays.sort(dwarfs);
        int idx1 = 0;
        int idx2 = 0;
        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                if(sum-dwarfs[i]-dwarfs[j] == 100){
                    idx1 = i;
                    idx2 = j;
                }
            }
        }
        for(int i=0; i<9; i++){
            if(i == idx1 || i == idx2){
                continue;
            }
            System.out.println(dwarfs[i]);
        }
    }
}
