package baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SortNumberIII10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] numList = new int[n];
        int max = 0;
        for(int i=0; i<n; i++){
            numList[i] = Integer.parseInt(br.readLine());
            if(numList[i]>max){
                max = numList[i];
            }
        }
        int[] counter = new int[max+1];
        for(int i=0; i<numList.length; i++){
            counter[numList[i]]++;
        }
        for(int i=1; i<counter.length; i++){
            counter[i]+=counter[i-1];
        }
        int[] sortedNumList = new int[n];
        for(int i=numList.length-1; i>=0; i--){
            sortedNumList[--counter[numList[i]]] = numList[i];
        }
        for(int i:sortedNumList){
            sb.append(i+"\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
