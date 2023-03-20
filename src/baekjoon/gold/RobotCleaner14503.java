package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class RobotCleaner14503 {
  static int row; // 세로 길이
  static int col; // 가로 길이
  static int dir; // 방향
  static int cleaned = 0;
  static int[][] room; // 방 정보 배열
  
  static int[] dr = {-1, 0, 1, 0}; // 사방탐색을 위한 델타배열
  static int[] dc = {0, 1, 0, -1}; // 북 동 남 서 순서
  
   public static void main(String args[]) throws IOException{ 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    row = Integer.parseInt(st.nextToken());
    col = Integer.parseInt(st.nextToken());
    room = new int[row][col];
    
    st = new StringTokenizer(br.readLine());
    int cr = Integer.parseInt(st.nextToken()); // 로봇청소기 출발 위치
    int cc = Integer.parseInt(st.nextToken()); // 로봇청소기 출발 위치
    dir = Integer.parseInt(st.nextToken()); // 시작 방향
    
    for(int r=0; r<row; r++){
      st = new StringTokenizer(br.readLine());
      for(int c=0; c<col; c++){
        room[r][c] = Integer.parseInt(st.nextToken());
      }
    }
    
    DFS(cr, cc); // 깊이우선 탐색으로 진행
    System.out.println(cleaned);
   }
   
   static void DFS(int cr, int cc){
     if(room[cr][cc] == 0){ // 청소가 안 된 구역이면
       room[cr][cc] = 2; // 2로 청소완료 표시
       cleaned++; // 청소한 구역 하나 추가
     }
     
     boolean cleanable = false; // boolean으로 청소 가능 불가능 판단
     for(int d=0; d<4; d++){ // 사방탐색하면서
       int nr = cr + dr[d];
       int nc = cc + dc[d];
       if(room[nr][nc] == 0){ // 만약 청소할 수 있는 곳이 있다면
         cleanable = true; // true로 돌리고
         break;
       }
     }
     
     if(cleanable){ // 청소할 수 있다면
       dir = (dir+3)%4; // 반시계 90도 돌고
       int nr = cr + dr[dir];
       int nc = cc + dc[dir];
       if(room[nr][nc] == 0){ // 해당 방향 앞이 청소할 수 있다면
        DFS(nr, nc); // 한 칸 전진
       } else {
        DFS(cr, cc); // 청소할 수 없다면 제자리 다시 입력
       }
     } else { // 청소할 수 없다면
      dir = (dir+2)%4; // 반대방향으로 한 칸 후퇴
      int nr = cr + dr[dir];
      int nc = cc + dc[dir];
      if(room[nr][nc] == 1){ // 뒤쪽으로 빼는데 벽이면 청소 끝
        return;
      } else { // 벽이 아니라면
        DFS(nr, nc); // 그 좌표에서 다시 사방탐색을 위한 깊이우선탐색 진행
      }
     }
   }
 }