package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AvoidingFood1743{
    static int row; // 행
    static int col; // 열
    static int[][] aisle; // 통로 그래프
    static boolean[][] visited; // 방문처리 배열
    static int biggest = 0; // 가장 큰 쓰레기더미

    static int[] dr = {-1, 1, 0, 0}; // 상하좌우 델타배열
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        row = sc.nextInt();
        col = sc.nextInt();
        int nFood = sc.nextInt(); // 음식물의 수

        aisle = new int[row+1][col+1]; // 좌표가 1부터 시작하므로 +1씩해줌
        visited = new boolean[row+1][col+1];

        for(int n=0; n<nFood; n++){ // 음식물 수만큼
            int r = sc.nextInt();
            int c = sc.nextInt();
            aisle[r][c] = 1; // 음식물이 존재하는 곳을 1로 표기
        }

        for(int r=1; r<=row; r++){
            for(int c=1; c<=col; c++){
                if(aisle[r][c] == 1 && !visited[r][c]){ // 1이고 방문한 적이 없으면
                    visited[r][c] =true; // 방문처리 하고
                    BFS(new Position(r, c)); // 그 지점에서 너비우선탐색 시작
                }
            }
        }
        System.out.println(biggest); // 최대값 출력

    }

    public static void BFS(Position start){
        Queue<Position> q = new LinkedList<>();
        q.offer(start); // 처음 시작점 넣고 큐에

        int size = 0; // 음식물 수
        while(!q.isEmpty()){ // 큐가 빌 때까지
            Position curr = q.poll(); // 가장 먼저 들어온 좌표를 꺼내서 현재 지점으로 표기
            size++; // 음식물 수 카운트
            for(int d=0; d<4; d++){ // 상하좌우 탐색
                int nr = curr.r+dr[d];
                int nc = curr.c+dc[d];

                if(nr<1 || nr>row || nc<1 || nc>col){ // 그래프 경계를 벗어나면
                    continue;
                }
                if(!visited[nr][nc] && aisle[nr][nc] == 1){ // 방문한 적이 없고 음식물이 있으면
                    visited[nr][nc] = true; // 방문처리 하고
                    q.offer(new Position(nr, nc)); // 큐에 쏙

                }
            }
        }
        biggest = Math.max(biggest, size); // 카운트된 음식물 수와 저장되어 있던 최대값 비교해서 최대값 저장
    }

    static class Position { // 좌표 클래스
        int r; // 행
        int c; // 열

        public Position(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

}