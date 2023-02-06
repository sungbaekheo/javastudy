package baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class HumanComputerInteraction16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        char[] str = br.readLine().toCharArray();
        int qNum = Integer.parseInt(br.readLine());
        int[][] aMatrix = new int[26][str.length+1];
        for(int i=0; i<26; i++){
            for(int j=1; j<str.length+1; j++){
                if((i+'a') == str[j-1]){
                    aMatrix[i][j]++;
                }
                aMatrix[i][j]+=aMatrix[i][j-1];
            }
        }

        for(int q=0; q<qNum; q++){
            st = new StringTokenizer(br.readLine());
            char alphabet = st.nextToken().charAt(0);
            int startPoint = Integer.parseInt(st.nextToken());
            int endPoint = Integer.parseInt(st.nextToken());
            sb.append(aMatrix[alphabet-'a'][endPoint+1] - aMatrix[alphabet-'a'][startPoint]+"\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
