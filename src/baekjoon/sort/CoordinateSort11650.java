package baekjoon.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CoordinateSort11650 {
    public static void main(String[] args) {
        Scanner 스캔 = new Scanner(System.in);

        int 수 = 스캔.nextInt();
        
        int[][] 좌표배열 = new int[수][2];

        for(int ㄱ=0; ㄱ<수; ㄱ++){
            좌표배열[ㄱ][0] = 스캔.nextInt();
            좌표배열[ㄱ][1] = 스캔.nextInt();
        }

        Arrays.sort(좌표배열, new Comparator<int[]>(){
            public int compare(int[] 원소1, int[] 원소2){
                if(원소1[0] == 원소2[0]){
                    return 원소1[1] - 원소2[1];
                } else {
                    return 원소1[0] - 원소2[0];
                }
            }
        });

        for(int[] ㅇ : 좌표배열){
            System.out.println(ㅇ[0] + " " + ㅇ[1]);
        }
    }
}
