package baekjoon.twoDimesionalArray;

import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int[][] matrix1 = new int[a][b];
        int[][] matrix2 = new int[a][b];

        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                matrix1[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                matrix2[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<a; i++){
            for(int j=0; j<b; j++){
                System.out.print(matrix1[i][j] + matrix2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
