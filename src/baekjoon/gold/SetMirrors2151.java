package baekjoon.gold;

import java.util.PriorityQueue;
import java.util.Scanner;

public class SetMirrors2151 {
    static int size;
    static char[][] home;
    static boolean[][][] visited;
    
    static int[] dr = {-1, 0, 1, 0}; // 상우하좌
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        home = new char[size][size];

        for(int r=0; r<size; r++){
            home[r] = sc.next().toCharArray();
        }

        for(int r=0; r<size; r++){
            for(int c=0; c<size; c++){
                if(home[r][c] == '#'){
                    BFS(new Position(r, c, 0, 0));
                    return;
                }
            }
        }
    }

    public static void BFS(Position start){
        PriorityQueue<Position> q = new PriorityQueue<>();
        visited = new boolean[size][size][4];
        int r = start.r;
        int c = start.c;
        for(int i=0; i<4; i++){
            q.offer(new Position(r, c, 0, i));
            visited[r][c][i] = true;
        }

        while(!q.isEmpty()){
            Position curr = q.poll();
            visited[curr.r][curr.c][curr.d] = true;

            if(!(curr.r == start.r && curr.c == start.c) && home[curr.r][curr.c] == '#'){
                System.out.println(curr.n);
                return;
            }

            int nr = curr.r + dr[curr.d];
            int nc = curr.c + dc[curr.d];

            if(nr<0 || nr>=size || nc<0 || nc>=size){
                continue;
            }

            if(home[nr][nc] == '*' || visited[nr][nc][curr.d]){
                continue;
            }

            q.offer(new Position(nr, nc, curr.n, curr.d));
            if(home[nr][nc] == '!'){
                q.offer(new Position(nr, nc, curr.n+1, (curr.d+4-1)%4));
                q.offer(new Position(nr, nc, curr.n+1, (curr.d+1)%4));
            }
        }
    }

    static class Position implements Comparable<Position>{
        int r;
        int c;
        int n;
        int d;

        public Position(int r, int c, int n, int d){
            this.r = r;
            this.c = c;
            this.n = n;
            this.d = d;
        }

        public int compareTo(Position o) {
            return this.n - o.n;
        }
    }
}
