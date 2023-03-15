package baekjoon.silver;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class DegreeCalculation2644{
  static int[][] graph; // 촌수를 나타낼 그래프 배열
  static int[] degree; // 주어진 사람으로부터으 촌수를 나타내는 배열
   public static void main(String args[]){ 
    Scanner sc = new Scanner(System.in);
    
    int num = sc.nextInt();
    graph = new int[num+1][num+1];
    degree = new int[num+1];

    int from = sc.nextInt(); // 시작점
    int to = sc.nextInt(); // 끝점
    
    int edge = sc.nextInt();
    for(int i=0; i<edge; i++){
      int r = sc.nextInt();
      int c = sc.nextInt();
      
      graph[r][c] = graph[c][r] = 1; // 무방향성 그래프 입력
    }
    
    BFS(from, to);
  }
   static void BFS(int from, int to){
     Queue<Integer> q = new LinkedList<>();
     q.add(from);

     while(!q.isEmpty()){
       int curr = q.poll();
       for(int i=1; i<graph[curr].length; i++){
         if(graph[curr][i] != 0 && degree[i] == 0){ // 연결되어 있고 촌수배열에 입력이 비어 있다면
          degree[i] = degree[curr]+1; // 촌수 입력해주고
          if(i == to){ // 끝점과 만난다면
            System.out.println(degree[to]); // 해당 촌수 출력
            return;
          }
          q.add(i);
         }
       }
     }
     System.out.println(-1); // 큐가 다 빌 때까지 돌았는데 촌수가 안 나온다면 -1 출력
   } 
 }