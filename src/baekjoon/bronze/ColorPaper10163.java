package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ColorPaper10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[][] board = new int[1001][1001];
        int nPaper = Integer.parseInt(br.readLine());
        int[] countList = new int[nPaper+1];

        for(int t=1; t<=nPaper; t++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            for(int i=x; i<x+width; i++){
                for(int j=y; j<y+height; j++){
                    board[i][j] = t;
                }
            }
        }
        for(int i=0; i<1001; i++){
            for(int j=0; j<1001; j++){
                countList[board[i][j]]++;
            }
        }
        for(int i=1; i<=nPaper; i++){
            sb.append(countList[i]+"\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
