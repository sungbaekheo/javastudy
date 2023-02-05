package baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statistics2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Integer> numList = new ArrayList<>();
        int sum = 0;
        int max = -4000;
        int min = 4000;
        int mode = 0;
        int[] counter = new int[8001];
        for(int i=0; i<n; i++){
            numList.add(Integer.parseInt(br.readLine()));
            sum+=numList.get(i);
            counter[numList.get(i)+4000]++;
            if(numList.get(i)>max){
                max = numList.get(i);
            }
            if(numList.get(i)<min){
                min = numList.get(i);
            }
        }
        Collections.sort(numList);
        int iMax = 0;
        for(int i=0; i<counter.length; i++){
            if(counter[i]>iMax){
                iMax = counter[i];
            }
        }
        int count = 0;
        for(int i=0; i<counter.length; i++){
            if(counter[i] == iMax){
                count++;
                mode = i-4000;
                if(count == 2){
                    break;
                }
            }
        }
        double avg = Math.round((double) sum/n);
        int mid = numList.get(n/2);
        int range = max - min;

        sb.append(String.format("%.0f",avg)+"\n"+mid+"\n"+mode+"\n"+range);
        bw.write(sb.toString());
        bw.close();
    }
}
