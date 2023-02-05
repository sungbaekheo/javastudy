package baekjoon.Conditions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Scale2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] scale = br.readLine().split(" ");

        String type = "mixed";
        if(Integer.parseInt(scale[0]) == 1){
            for(int i=0; i<7; i++){
                if(Integer.parseInt(scale[i])-Integer.parseInt(scale[i+1]) == -1){
                    type = "ascending";
                }else{
                    type = "mixed";
                    break;
                }
            }
        } else if(Integer.parseInt(scale[0]) == 8){
            for(int i=0; i<7; i++){
                if(Integer.parseInt(scale[i])-Integer.parseInt(scale[i+1])== 1){
                    type = "descending";
                }else{
                    type = "mixed";
                    break;
                }
            }
        }
        System.out.println(type);
    }
}
