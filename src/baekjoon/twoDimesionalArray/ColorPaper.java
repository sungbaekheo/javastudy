package baekjoon.twoDimesionalArray;

import java.util.Scanner;

public class ColorPaper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nPaper = sc.nextInt();

        int[][] matrix = new int[100][100];
        int area = 0;
        for(int t=0; t<nPaper; t++){
            int c = sc.nextInt();
            int r = sc.nextInt();
            for(int i=10; i>0; i--){
                for(int j=0; j<10; j++){
                    if(matrix[100-(i+r)][j+c] == 0){
                        matrix[100-(i+r)][j+c] = 1;
                        area++;
                    }else{
                        continue;
                    }
                }
            }
        }
        System.out.println(area);
    }
}
