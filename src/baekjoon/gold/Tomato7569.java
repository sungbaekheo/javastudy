package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato7569 {
  static int[][][] basket; // 토마토 박스~
  static int z; // 층
  static int x; // 가로
  static int y; // 세로
  static int[] dr = {-1, 1, 0, 0, 0, 0}; // 델타배열 상하좌우위아래
  static int[] dc = {0, 0, -1, 1, 0, 0};
  static int[] dh = {0, 0, 0, 0, 1, -1};
  static int days = 0; // 토마토가 다 익기까지 걸리는 일수
  static Queue<Point> q = new LinkedList<>(); // 큐
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    y = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    z = Integer.parseInt(st.nextToken());

    basket = new int[z][x][y];

    for(int h=0; h<z; h++){
      for(int r=0; r<x; r++){
        st = new StringTokenizer(br.readLine());
        for(int c=0; c<y; c++){
          basket[h][r][c] = Integer.parseInt(st.nextToken());
        }
      }
    }

    for(int h=0; h<z; h++){
      for(int r=0; r<x; r++){
        for(int c=0; c<y; c++){
          if(basket[h][r][c] == 1){ // 익어있는 토마토가 여러 개로 시작할 수 있기 때문에
            q.add(new Point(h, r, c)); // 익은 토마토는 모두 큐에 한꺼번에 때려 넣기
          }
        }
      }
    }

    BFS(); // 토마토 익히기

    main: for(int h=0; h<z; h++){
      for(int r=0; r<x; r++){
        for(int c=0; c<y; c++){
          if(basket[h][r][c] == 0){ // 익히는 과정이 모두 끝난 후에 안 익은 토마토가 있다면
            days = -1;
            break main;
          }
          days = days>basket[h][r][c]? days:basket[h][r][c]; // 최대값 구하기
        }
      }
    }
    if(days == -1){
      System.out.println(days);
    } else {
      System.out.println(days-1);  
    }
  }

  static void BFS(){
    while(!q.isEmpty()){
      Point p = q.poll();
      for(int d=0; d<6; d++){
        int nh = p.z + dh[d];
        int nr = p.x + dr[d];
        int nc = p.y + dc[d];

        if(nh<0 || nh>=z || nr<0 || nr>=x || nc<0 || nc>=y){ // 범위 이탈 방지
          continue;
        }

        if(basket[nh][nr][nc] == 0){
          basket[nh][nr][nc] = basket[p.z][p.x][p.y]+1; // 퍼져나가는 모양대로 이전 토마토 + 1 하면 해당 일수 알 수 있음
          q.add(new Point(nh, nr, nc)); // 익은 토마토 큐에 넣기
        }
      }
    }
  }

  static class Point{ // 토마토 좌표 클래스로 선언
    int z;
    int x;
    int y;
    public Point(int z, int x, int y){
      this.z = z;
      this.x = x;
      this.y = y;
    }
  }
}
