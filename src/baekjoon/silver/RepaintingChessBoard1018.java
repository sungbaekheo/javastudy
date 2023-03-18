package baekjoon.silver;

import java.util.Scanner;

public class RepaintingChessBoard1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] board = new char[n][m];
        char[][] copiedBoard;

        for(int r=0; r<n; r++){
            board[r] = sc.next().toCharArray();
        }

        int minCell = Integer.MAX_VALUE;
        for(int i=0; i<n-8+1; i++){
            for(int j=0; j<m-8+1; j++){
                for(int k=0; k<2; k++){
                    copiedBoard = copyBoard(n, m, board);
                    int count = 0;
                    for(int r=i; r<i+8; r++){
                        for(int c=j; c<j+8; c++){
                            if(r==i && c==j){
                                if(k == 0 && copiedBoard[r][c] == 'B'){
                                    copiedBoard[r][c] = 'W';
                                    count++;
                                } else if(k == 1 && copiedBoard[r][c] == 'W'){
                                    copiedBoard[r][c] = 'B';
                                    count++;
                                }
                            }
                            if(c>j && copiedBoard[r][c] == copiedBoard[r][c-1]){
                                if(copiedBoard[r][c-1] == 'B'){
                                    copiedBoard[r][c] = 'W';
                                } else {
                                    copiedBoard[r][c] = 'B';
                                }
                                count++;
                            }
                            if(r>i && copiedBoard[r][j] == copiedBoard[r-1][j]){
                                if(copiedBoard[r-1][j] == 'B'){
                                    copiedBoard[r][j] = 'W';
                                } else {
                                    copiedBoard[r][j] = 'B';
                                }
                                count++;
                            }
                        }
                    }
                    minCell = minCell>count? count:minCell;
                }
            }
        }
        System.out.println(minCell);
    }

    static char[][] copyBoard(int n, int m, char[][] board){
        
        char[][] copiedBoard = new char[n][m];
        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                copiedBoard[r][c] = board[r][c];
            }
        }
        return copiedBoard;
    }
}
