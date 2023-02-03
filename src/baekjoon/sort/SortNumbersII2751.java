package baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortNumbersII2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> numList = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            numList.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(numList);
        StringBuilder sb = new StringBuilder();
        for(int i:numList){
            sb.append(i+"\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
