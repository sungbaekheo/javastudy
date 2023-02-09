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
            char type = '0';
            for(int i=0; i<8; i++){
                squares[i] = Integer.parseInt(st.nextToken());
            }
            if((squares[2] < squares[4] || squares[3] < squares[5]) ||
            (squares[6]<squares[0] || squares[1] > squares[7])) {
                type = 'd';
            } else if(squares[0] == squares[6] && squares[3] == squares[5] ||
            squares[0] == squares[6] && squares[1] == squares[7] ||
            squares[2] == squares[4] && squares[3] == squares[5] ||
            squares[2] == squares[4] && squares[1] == squares[7]){
                type = 'c';
            } else if(squares[2] == squares[4]||squares[0] == squares[6]||squares[3] == squares[5]||squares[1] == squares[7]) {
                type = 'b';
            } else {
                type = 'a';
            }
            sb.append(type+"\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
