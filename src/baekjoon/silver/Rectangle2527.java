package baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Rectangle2527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<4; t++){
            int[] squares = new int[8];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<8; i++){
                squares[i] = Integer.parseInt(st.nextToken());
            }
            if(squares[0] < squares[6] && squares[2] > squares[4]){
                
            }










        }
        bw.write(sb.toString());
        bw.close();
    }
}
