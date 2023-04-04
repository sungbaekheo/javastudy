package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MonkeyWhoWannaBeAHorse1600 {
    static int W;
    static int H;
    static int[][] map;
    static boolean[][] visited;
    static int minCnt = Integer.MAX_VALUE;

    static int[] dr = {-1, 1, 0, 0, -1, -2, 2, 1, -1, -2, 2, 1}; // 상하좌우 10, 11, 1, 2, 4, 5, 7, 8시 방향 
    static int[] dc = {0, 0, -1, 1, -2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();

        map = new int[H][W];
        visited = new boolean[H][W];

        for(int r=0; r<H; r++){
            for(int c=0; c<W; c++){
                map[r][c] = sc.nextInt();
            }
        }
        BFS(new Position(0, 0), K);
        DFS(0, 0, K, 0);
        if(minCnt == Integer.MAX_VALUE){
            minCnt = -1;
        }
        System.out.println(minCnt);
    }

    public static void BFS(Position pos, int limit){
        Queue<Position> q = new LinkedList<>();
        q.offer(pos);
        visited[pos.r][pos.c] = true;

        while(!q.isEmpty()){
            Position curr = q.poll();

            for(int d=0; d<12; d++){
                int nr = curr.r+dr[d];
                int nc = curr.c+dc[d];
    
                if(nr<0 || nr>=H || nc<0 || nc>=W || visited[nr][nc]){
                    continue;
                }
                if(map[nr][nc] == 1){
                    continue;
                }
    
                if(d<4){
                    visited[nr][nc] = true;
                    q.offer(new Position(nr, nc));
                } else{
                    if(limit>0){
                        visited[nr][nc] = true;
                        q.offer(new Position(nr, nc));
                        limit--;
                    }
                }
            }
        }
    }

    public static void DFS(int r, int c, int limit, int cnt){
        if(minCnt<cnt){
            return;
        }

        if(r == H-1 && c == W-1){
            minCnt = Math.min(minCnt, cnt);
            return;
        }

        visited[r][c] = true; 
        if(map[r][c] == 1){
            return;
        }
        for(int d=0; d<12; d++){
            int nr = r+dr[d];
            int nc = c+dc[d];

            if(nr<0 || nr>=H || nc<0 || nc>=W || visited[nr][nc]){
                continue;
            }

            if(d<4){
                DFS(nr, nc, limit, cnt+1);
                visited[nr][nc] = false;
            } else{
                if(limit>0){
                    DFS(nr, nc, limit-1, cnt+1);
                    visited[nr][nc] = false;
                }
            }
        }
    }

    static class Position {
        int r;
        int c;

        public Position(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
