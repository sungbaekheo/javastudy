package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class RobotCleaner14503 {
  static int row;
  static int col;
  static int dir;
  static int cleaned = 0;
  static int[][] room;
  
  static int[] dr = {-1, 0, 1, 0};
  static int[] dc = {0, 1, 0, -1};
  
   public static void main(String args[]) throws IOException{ 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    row = Integer.parseInt(st.nextToken());
    col = Integer.parseInt(st.nextToken());
    room = new int[row][col];
    
    st = new StringTokenizer(br.readLine());
    int cr = Integer.parseInt(st.nextToken());
    int cc = Integer.parseInt(st.nextToken());
    dir = Integer.parseInt(st.nextToken());
    
    for(int r=0; r<row; r++){
      st = new StringTokenizer(br.readLine());
      for(int c=0; c<col; c++){
        room[r][c] = Integer.parseInt(st.nextToken());
      }
    }
    
    DFS(cr, cc);
    System.out.println(cleaned);
   }
   
   static void DFS(int cr, int cc){
     if(room[cr][cc] == 0){
       room[cr][cc] = 2;
       cleaned++;
     }
     
     boolean cleanable = false;
     for(int d=0; d<4; d++){
       int nr = cr + dr[d];
       int nc = cc + dc[d];
       if(room[nr][nc] == 0){
         cleanable = true;
         break;
       }
     }
     
     if(cleanable){
       dir = (dir+3)%4;
       int nr = cr + dr[dir];
       int nc = cc + dc[dir];
       if(room[nr][nc] == 0){
        DFS(nr, nc);
       } else {
        DFS(cr, cc);
       }
     } else {
      dir = (dir+2)%4;
      int nr = cr + dr[dir];
      int nc = cc + dc[dir];
      if(room[nr][nc] == 1){
        return;
      } else {
        DFS(nr, nc);
      }
     }
   }
 }