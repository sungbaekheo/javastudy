package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CuttingTrees2805{
   public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st = new StringTokenizer(br.readLine());
     
     int N = Integer.parseInt(st.nextToken());
     int goal = Integer.parseInt(st.nextToken());
     int[] trees = new int[N];
     int min = 0;
     int max = Integer.MIN_VALUE;

     st = new StringTokenizer(br.readLine());
     for(int i=0; i<N; i++){
       trees[i] = Integer.parseInt(st.nextToken());
       max = trees[i]>max? trees[i]:max;
     }
     
     while(min<=max){
      int mid = (min+max)/2;
      long sum = 0;

      for(int i=0; i<N; i++){
        if(trees[i] > mid){
          sum+=trees[i]-mid;
        }
      }
      if(sum>=goal){
        min = mid+1;
      } else {
        max = mid-1;
      }
     }
     System.out.println(min-1);
   }
 }