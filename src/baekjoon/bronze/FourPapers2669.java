package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FourPapers2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] board = new int[101][101];
        int area = 0;
        for(int t=0; t<4; t++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int _x = Integer.parseInt(st.nextToken());
            int _y = Integer.parseInt(st.nextToken());

            for(int i=x; i<_x; i++){
                for(int j=y; j<_y; j++){
                    int p = board[i][j];
                    if(p == 1){
                        continue;
                    } else {
                        board[i][j] = 1;
                        area++;
                    }
                }
            }
        }
        System.out.println(area);
    }
}
