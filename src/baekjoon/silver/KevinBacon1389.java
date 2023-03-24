package baekjoon.silver;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

 // Compiler version JDK 11.0.2

public class KevinBacon1389 {
  static int[][] graph;
  static int[] visited;
  static int N;
  static int answer = 0;
  static int min = Integer.MAX_VALUE;
   public static void main(String[] args){ 
    Scanner sc = new Scanner(System.in);
    
    N = sc.nextInt();
    int M = sc.nextInt();
    graph = new int[N+1][N+1];
    
    for(int i=0; i<M; i++){
      int r = sc.nextInt();
      int c = sc.nextInt();
      graph[r][c] = graph[c][r] = 1;
    }
    
    for(int i=1; i<=N; i++){
      visited = new int[N+1];
      BFS(i);
    }  
    System.out.println(answer);
   }
   
   public static void BFS(int n){
     Queue<Integer> q = new LinkedList<>();
     q.offer(n);
     visited[n] = 1;
     while(!q.isEmpty()){
       int i = q.poll();
       for(int j=1; j<=N; j++){
         if(graph[i][j] == 1 && visited[j] == 0){
           q.offer(j);
           visited[j] = visited[i]+1;
         }
       }
     }
     
     int tempSum = 0;
     for(int i=1; i<=N; i++){
       tempSum += visited[i] - 1;
     }
     if(tempSum < min){
       min = tempSum;
       answer = n;
     }
   }
 }