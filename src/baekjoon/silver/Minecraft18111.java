package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Minecraft18111 {
   public static void main(String[] args) throws IOException { 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int row = Integer.parseInt(st.nextToken());
    int col = Integer.parseInt(st.nextToken());
    int blocks = Integer.parseInt(st.nextToken());
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int time = Integer.MAX_VALUE;
    int floor = 0;
    
    int[][] land = new int[row][col];
    for(int r=0; r<row; r++){
      st = new StringTokenizer(br.readLine());
      for(int c=0; c<col; c++){
        land[r][c] = Integer.parseInt(st.nextToken());
        max = max>land[r][c]? max:land[r][c];
        min = min<land[r][c]? min:land[r][c];
      }
    }
    
    for(int i=min; i<=max; i++){
      int tempT = 0;
      int tempB = blocks;
      for(int r=0; r<row; r++){
        for(int c=0; c<col; c++){      
          int n = Math.abs(i-land[r][c]);
          if(land[r][c] < i){
            tempT+=n;
            tempB-=n;
          } else {
            tempT+=n*2;
            tempB+=n;
          }
        }       
      }
      if(tempB<0){
        continue;
      }
      if(tempT<=time){
        time = tempT;
        floor = i;
      }
    }
    System.out.println(time+" "+floor);
   }
 }