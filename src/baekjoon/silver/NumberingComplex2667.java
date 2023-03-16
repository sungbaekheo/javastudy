package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

<<<<<<< HEAD
public class NumberingComplex2667 {
    static int size;
    static int[][] village;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Integer> numList = new ArrayList<>();
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        size = Integer.parseInt(br.readLine());
        village = new int[size][size];
        visited = new boolean[size][size];
    
        for(int i=0; i<size; i++){
            char[] row = br.readLine().toCharArray();
            for(int j=0; j<size; j++){
                village[i][j] = row[j] - '0';
            }
        }
    
        int nComplex = 0;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(village[i][j] == 1 && !visited[i][j]){
                    BFS(i, j);
                    nComplex++;
                }
            }
        }
        Collections.sort(numList);
        System.out.println(nComplex);
        for(int i=0; i<nComplex; i++){
            System.out.println(numList.get(i));
        }
    }
    
    static void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c});
        visited[r][c] = true;
        
        int nHome = 0;
        while(!q.isEmpty()){
            nHome++;
            int[] point = q.poll();
            for(int d=0; d<4; d++){
                int nr = point[0] + dr[d];
                int nc = point[1] + dc[d];
                
                if(nr<0 || nr>=size || nc<0 || nc>=size){
                    continue;
                }
                
                if(village[nr][nc] == 1 && !visited[nr][nc]){
                    q.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        numList.add(nHome);
    }
}
=======
 // Compiler version JDK 11.0.2

public class NumberingComplex2667{
  static int size;
  static int[][] village;
  static boolean[][] visited;
  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};
  static List<Integer> numList = new ArrayList<>();
   public static void main(String args[]) throws IOException { 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    size = Integer.parseInt(br.readLine());
    village = new int[size][size];
    visited = new boolean[size][size];
    
    for(int i=0; i<size; i++){
      char[] row = br.readLine().toCharArray();
      for(int j=0; j<size; j++){
        village[i][j] = row[j] - '0';
      }
    }
    
    int nComplex = 0;
    for(int i=0; i<size; i++){
      for(int j=0; j<size; j++){
        if(village[i][j] == 1 && !visited[i][j]){
          BFS(i, j);
          nComplex++;
        }
      }
    }
    Collections.sort(numList);
    System.out.println(nComplex);
    for(int i=0; i<nComplex; i++){
      System.out.println(numList.get(i));
    }
   }
   
   static void BFS(int r, int c){
     Queue<int[]> q = new LinkedList<>();
     q.add(new int[] {r, c});
     visited[r][c] = true;
     
     int nHome = 0;
     while(!q.isEmpty()){
       nHome++;
       int[] point = q.poll();
       for(int d=0; d<4; d++){
         int nr = point[0] + dr[d];
         int nc = point[1] + dc[d];
         
         if(nr<0 || nr>=size || nc<0 || nc>=size){
           continue;
         }
         
         if(village[nr][nc] == 1 && !visited[nr][nc]){
           q.add(new int[] {nr, nc});
           visited[nr][nc] = true;
         }
       }
     }
     numList.add(nHome);
   }
 }
>>>>>>> 8a127ed72b88a365f69f97743adb73f61aad38e0
