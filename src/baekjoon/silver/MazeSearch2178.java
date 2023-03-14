package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Compiler version JDK 11.0.2

public class MazeSearch2178 {
    static int[][] maze; // 미로~
    static boolean[][] visited; // 방문처리용 불리언 배열
    static int row; // 행
    static int col; // 열
    static int[] dr = {-1, 1, 0, 0}; // 델타배열
    static int[] dc = {0, 0, -1, 1}; // 상하좌우
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        maze = new int[row][col];
        visited = new boolean[row][col];
        
        for(int r=0; r<row; r++){
            char[] rowArray = sc.next().toCharArray();
            for(int c=0; c<col; c++){
                maze[r][c] = rowArray[c] - '0'; // 붙어서 입력받으므로 각 인덱스의 캐릭터에서 0을 빼주면 int값
            }
        }
        
        BFS(0, 0); // 너비우선탐색 고고
        
        System.out.println(maze[row-1][col-1]);
    }

    static void BFS(int r, int c){
        Queue<Point> q = new LinkedList<>(); // BFS를 위한 큐
        q.add(new Point(r, c)); // 첫 시작점 넣고
        visited[r][c] = true; // 방문 처리
        while(!q.isEmpty()){ // 큐가 비어있지 않으면
            Point point = q.poll(); // 큐 맨 앞에 있는 좌표 뽑기
            for(int d=0; d<4; d++){
                int nr = point.r + dr[d]; // 상하좌우 탐색하기
                int nc = point.c + dc[d];

                if(nr<0 || nr>=row || nc<0 || nc>=col){ // indexoutofbounds 가 뜨는 좌표는 넘기기
                    continue;
                }
                if(visited[nr][nc] == true || maze[nr][nc] == 0){ // 이미 방문했거나 0인 곳은 패스
                    continue;
                }
                q.add(new Point(nr, nc)); // 방문하지 않았고 1이라면 큐에 넣기
                maze[nr][nc]+=maze[point.r][point.c]; // 이전 장소까지의 거리를 다음장소에 더하기(총 거리가 누적됨)
                visited[nr][nc] = true; // 방문처리
            }
        }
    }
    static class Point{ // 좌표 담을 객체
        int r;
        int c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}