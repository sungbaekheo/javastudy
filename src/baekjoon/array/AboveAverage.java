package baekjoon.array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class AboveAverage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] scores = new int[n];
            double avg = 0;
            for(int j=0; j<n; j++){
                scores[j] = Integer.parseInt(st.nextToken());
                avg+=scores[j];
            }
            avg = avg/n;
            int count = 0;
            for(int j=0; j<scores.length; j++){
                if(scores[j] > avg){
                    count++;
                }
            }
            bw.write(String.format("%.3f", (double) count/n*100.0));
            bw.write("%\n");
        }
        bw.close();
    }
}