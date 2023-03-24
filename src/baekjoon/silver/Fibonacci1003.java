package baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

 // Compiler version JDK 11.0.2

public class Fibonacci1003 {
  static int[] dp = new int[41];
   public static void main(String[] args) throws IOException { 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    dp[0] = 0;
    dp[1] = 1;
       
    for(int i=2; i<41; i++){
      dp[i] = dp[i-1] + dp[i-2];
    }

    int testCase = Integer.parseInt(br.readLine());
    for(int i=0; i<testCase; i++){
      int num = Integer.parseInt(br.readLine());
        
      if(num == 0){
        sb.append(1+" "+0+"\n");
      } else if(num == 1){
        sb.append(0+" "+1+"\n");
      } else {
        sb.append(dp[num-1]+" "+dp[num]+"\n");
      }
    }
    bw.write(sb.toString());
    bw.close();
   }
 }

