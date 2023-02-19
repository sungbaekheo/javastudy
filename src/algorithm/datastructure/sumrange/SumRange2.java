/*
 * Do it 알고리즘 코딩테스트 자바편
 * 자료구조 - 구간합
 * BOJ 11660번 구간합 구하기 2
 * 
 * 
 * 2차원 배열의 구간합을 구하여 필요한 구간의 합만을 출력하기
 */

package algorithm.datastructure.sumrange;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SumRange2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int size = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[size+1][size+1];
        for(int i=1; i<=size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=size; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sumBoard = new int[size+1][size+1];
        for(int i=1; i<=size; i++){
            for(int j=1; j<=size; j++){
                sumBoard[i][j] = board[i][j]+sumBoard[i][j-1]+sumBoard[i-1][j]-sumBoard[i-1][j-1];
            }
        }
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            bw.write(sumBoard[x2][y2]-sumBoard[x1-1][y2]-sumBoard[x2][y1-1]+sumBoard[x1-1][y1-1]+"\n");
        }
        bw.close();
    }
}
