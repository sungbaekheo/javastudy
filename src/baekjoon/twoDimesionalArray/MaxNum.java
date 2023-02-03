package baekjoon.twoDimesionalArray;

import java.util.Scanner;

public class MaxNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matrix = new int[9][9];

        int maxNum = 0;
        int maxR = 0;
        int maxC = 0;

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                matrix[i][j] = sc.nextInt();
                if(matrix[i][j] >= maxNum){
                    maxNum = matrix[i][j];
                    maxR = j+1;
                    maxC = i+1;
                }
            }
        }

        System.out.println(maxNum);
        System.out.println(maxC +" "+ maxR);




    }
}
