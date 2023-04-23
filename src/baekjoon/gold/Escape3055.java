package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Escape3055 {
    static int row;
    static int col;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Position> floodedPoint = new LinkedList<>();

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        row = sc.nextInt();
        col = sc.nextInt();

        map = new char[row][col];
        visited = new boolean[row][col];

        for(int r=0; r<row; r++){
            map[r] = sc.next().toCharArray();
        }

        Position start = null;

        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(map[r][c] == '*'){
                    floodedPoint.offer(new Position(r, c, 0,false));
                } else if(map[r][c] == 'S'){
                    start = new Position(r, c, 0, true);
                }
            }
        }

        BFS(start);
    }

    public static void BFS(Position start){
        Queue<Position> q = new LinkedList<>();
        while(!floodedPoint.isEmpty()){
            Position f = floodedPoint.poll();
            q.offer(f);
            visited[f.r][f.c] = true;
        }

        q.offer(start);
        visited[start.r][start.c] = true;

        while(!q.isEmpty()){
            Position curr = q.poll();

            if(curr.s && map[curr.r][curr.c] == 'D'){
                System.out.println(curr.d);
                return;
            }

            for(int d=0; d<4; d++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(nr<0 || nr>=row || nc<0 || nc>=col){
                    continue;
                }

                if(map[nr][nc] == 'X' || visited[nr][nc]){
                    continue;
                }

                if(map[nr][nc] == 'D' && !curr.s){
                    continue;
                }

                visited[nr][nc] = true;
                q.offer(new Position(nr, nc, curr.d+1, curr.s));
            }
        }
        System.out.println("KAKTUS");
    }

    static class Position{
        int r;
        int c;
        int d;
        boolean s;

        public Position(int r, int c, int d, boolean s){
            this.r = r;
            this.c = c;
            this.d = d;
            this.s = s;
        }
    }
}
