package baekjoon.silver;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class StartLink5014{
  static int total; // 층
  static int[] floors; // 층별 도착하기까지 최소 횟수
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    total = sc.nextInt();
    int start = sc.nextInt();
    int end = sc.nextInt();
    int up = sc.nextInt();
    int down = sc.nextInt();
    
    floors = new int[total+1];
    
    BFS(start, end, up, down);   
  }   
  
  static void BFS(int s, int e, int u, int d){
    Queue<Integer> q = new LinkedList<>();
    q.add(s); // 시작 층 큐에 넣고
    floors[s] = 1; // 방문처리 겸 횟수 입력
    while(!q.isEmpty()){
      int curr = q.poll();
      if(curr == e){ // 현재 층이 목표 층이면
        System.out.println(floors[curr]-1); // 저장된 회수에서 1을 빼고 출력
        return;
      }
      if(curr+u<=total && floors[curr+u] == 0){ // 더 이상 위로 갈 수 없을 때가 아니거나 방문한 적이 없으면
        q.add(curr+u); // 위로 간 경우의 층 큐에 넣기
        floors[curr+u] = floors[curr]+1; // 방문 처리 겸 횟수 입력
      }
      if(curr-d>0 && floors[curr-d] == 0) { // 더 이상 아래로 내려갈 수 없을 때가 아니거나 방문하지 않았다면
        q.add(curr-d); // 아래로 간 경우의 층 큐에 넣기
        floors[curr-d] = floors[curr]+1; // 방문 처리 겸 횟수 입력
      }
    }
    System.out.println("use the stairs"); // 큐가 다 빌 때까지 목표층에 도달하지 못하면 출력
  }
}