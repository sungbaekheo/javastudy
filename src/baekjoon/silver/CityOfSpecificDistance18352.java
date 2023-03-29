package baekjoon.silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class CityOfSpecificDistance18352 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // 노드의 수
    int M = sc.nextInt(); // 간선의 수
    int K = sc.nextInt(); // 구하고자 하는 거리
    int X = sc.nextInt(); // 출발 시티
  
    List<Integer>[] cities = new ArrayList[N+1]; // 도시 정보를 담은 그래프
    for(int i=0; i<=N; i++){
      cities[i] = new ArrayList<>(); // 그래프 열을 어레이리스트로 만들어 줌
    }
    for(int i=0; i<M; i++){
      int s = sc.nextInt(); // 앞 노드
      int e = sc.nextInt(); // 뒷 노드
      cities[s].add(e);
    }

    BFS(cities, K, X);
  }

  static void BFS(List<Integer>[] list, int target, int start){
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[list.length]; //박문철2 할 배열
    int[] distance = new int[list.length]; // 출발 도시부터의 거리를 담을 배열
    int count = 0; // 출발지로부터의 거리
    boolean isTrue = false;

    q.offer(start); // 시작 도시 큐에 넣고
    visited[start] = true; // 박문철2
    distance[start] = count;
    while(!q.isEmpty()){
      int curr = q.poll(); // dequeue
      for(int i=0; i<list[curr].size(); i++){ // 현재 도시와 연결된 도시 중
        if(visited[list[curr].get(i)]){ // 방문한 도시가 있다면 건너 뛰기
          continue;
        }
        q.offer(list[curr].get(i)); // 도시 방문
        visited[list[curr].get(i)] = true; // 박문철2
        distance[list[curr].get(i)] = distance[curr]+1; // 거리 배열에 앞 도시까지의 거리+1
      }
    }
    for(int i=0; i<list.length; i++){ // 배열에 K 거리인 도시가 있다면
      if(distance[i] == target){ 
        isTrue = true; // true 로 돌리고
        System.out.println(i); // 출력
      }
    }
    if(!isTrue){ // K 거리인 도시가 없다면
      System.out.println(-1); // -1 출력
    }
    
  }
}
