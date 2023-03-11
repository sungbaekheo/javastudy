package baekjoon.silver;

import java.util.Scanner;

public class TheNumberOfConnectedElement11724{
  static boolean[] visited; // 방문처리 할 배열
  static int[][] graph; // 그래프 표현할 배열
  static int size; // 그래프 배열의 크기
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    size = sc.nextInt();
    int N = sc.nextInt(); // 간선의 개수

    graph = new int[size+1][size+1];
    visited = new boolean[size+1];

    for(int i=0; i<N; i++){
      int r = sc.nextInt();
      int c = sc.nextInt();
      graph[r][c] = graph[c][r] = 1; // 그래프 간선 연결
    }

    int connected = 0; // 연결되어 있는 덩어리 개수
    for(int i=1; i<size+1; i++){
      if(visited[i] == false){ // 방문하지 않았다면
        connected++; // 덩어리 개수 하나 추가
        DFS(i);
      }
    }
    System.out.println(connected);
  }

  static void DFS(int i){
    if(visited[i] == true){ // 방문했다면 재귀 종료
      return;
    } else {
      visited[i] = true; // 방문처리
      for(int j=1; j<size+1; j++){
        if(graph[i][j] == 1){ // 연결되어 있다면 탐색 계속
          DFS(j);
        }
      }
    }
  }
}