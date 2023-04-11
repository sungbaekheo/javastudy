package baekjoon.silver;

import java.util.Scanner;

public class Move11048 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int[row][col];

        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                arr[r][c] = sc.nextInt();
                if(c == 0 && r>0){
                    arr[r][c]+=arr[r-1][c];
                }
                if(r == 0 && c>0){
                    arr[r][c]+=arr[r][c-1];
                }
                if(r>0 && c>0){
                    arr[r][c]+=Math.max(arr[r-1][c], arr[r][c-1]);
                }
            }
        }
        System.out.println(arr[row-1][col-1]);
    }
}