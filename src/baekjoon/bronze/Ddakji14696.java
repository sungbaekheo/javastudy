package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Ddakji14696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int rounds = Integer.parseInt(br.readLine());
        for(int r=0; r<rounds; r++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] a = new int[5]; 
            for(int i=0; i<num; i++){
                a[Integer.parseInt(st.nextToken())]++;
            }
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            int[] b = new int[5];
            for(int i=0; i<num; i++){
                b[Integer.parseInt(st.nextToken())]++;
            }
            String result = "D";
            for(int i=4; i>=0; i--){
                if(a[i]>b[i]){
                    result = "A";
                    break;
                } else if(b[i]>a[i]){
                    result = "B";
                    break;
                }
            }
            sb.append(result+"\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
