package baekjoon.silver;

import java.util.Scanner;

public class Bingo2578 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[][] board = new int[5][5];
        int[][] bingo = new int[5][5];
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                board[i][j] = sc.nextInt();
            }
        }

        main: for(int t=1; t<=25; t++){
            int num = sc.nextInt();
            find: for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    if(board[i][j] == num){
                        bingo[i][j]++;

                        int[] hr = new int[5];
                        int[] vr = new int[5];
                        int[] dia = new int[2];

                        for(int r=0; r<5; r++){
                            int h = 0;
                            int v = 0;
                            for(int c=0; c<5; c++){
                                h+=bingo[r][c];
                                v+=bingo[c][r];
                                if(r==c){
                                    dia[0]+=bingo[r][c];
                                }
                                if(r+c == 4){
                                    dia[1]+=bingo[r][c];
                                }
                            }
                            if(h == 5){
                                hr[r]++;
                            }
                            if(v == 5){
                                vr[r]++;
                            }
                            int icnt = 0;
                            for(int k=0; k<5; k++){
                                if(hr[k] == 1){
                                    icnt++;
                                }
                                if(vr[k] == 1){
                                    icnt++;
                                }
                                if(k<2){
                                    if(dia[k] == 5){
                                        icnt++;
                                    }
                                }
                            }
                            if(icnt >=3){
                                System.out.println(t);
                                break main;
                            }
                        }
                        break find;
                    }
                }
            }
        }
    }
}
