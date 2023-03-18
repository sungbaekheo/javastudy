package baekjoon.silver;

import java.util.Scanner;

public class RepaintingChessBoard1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] board = new int[n][m];

        for(int r=0; r<n; r++){
            char[] row = sc.next().toCharArray();
            for(int c=0; c<n; c++){
                board[n][m] = row[m]-'0';
            }
        }
        int minCell = Integer.MAX_VALUE;
        for(int i=0; i<n-8+1; i++){
            for(int r=i; r<)
        }
    }
}
