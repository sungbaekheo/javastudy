package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SetMirrors2151 {
    static int size;
    static char[][] home;
    static boolean[][][] visited;
    static Position[] doors = new Position[2];
    static int nMirror;
    static int minNum;
    static int[] dr = {-1, 0, 1, 0}; // 상우하좌
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();
        home = new char[size][size];

        for(int r=0; r<size; r++){
            home[r] = sc.next().toCharArray();
        }

        nMirror = 0;
        int doorCnt = 0;
        for(int r=0; r<size; r++){
            for(int c=0; c<size; c++){
                if(home[r][c] == '#'){
                    int dir = 0;
                    if(r == 0){
                        dir = 2;
                    } else if(r == size-1){
                        dir = 0;
                    } else if(c == 0){
                        dir = 1;
                    } else if(c == size-1){
                        dir = 3;
                    }
                    doors[doorCnt++] = new Position(r, c, 0, dir);
                } else if(home[r][c] == '!'){
                    nMirror++;
                }
            }
        }
        visited = new boolean[size][size][nMirror+1];

        BFS(doors[0]);

        System.out.println(minNum);
    }

    public static void BFS(Position start){
        Queue<Position> q = new LinkedList<>();
        q.offer(start);
        visited[start.r][start.c][start.n] = true;

        minNum = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Position curr = q.poll();
            
            if(curr.n>=minNum){
                continue;
            }

            if(curr.r == doors[1].r && curr.c == doors[1].c){
                minNum = Math.min(minNum, curr.n);
            }

            int nr = curr.r + dr[curr.d];
            int nc = curr.c + dc[curr.d];

            if(nr<0 || nr>=size || nc<0 || nc>=size){
                continue;
            }

            if(home[nr][nc] == '*' || visited[nr][nc][curr.n]){
                continue;
            }

            if(home[nr][nc] == '!' && curr.n<nMirror){
                visited[nr][nc][curr.n+1] = true;
                visited[nr][nc][curr.n] = true;
                q.offer(new Position(nr, nc, curr.n+1, (curr.d+4-1)%4));
                q.offer(new Position(nr, nc, curr.n+1, (curr.d+1)%4));
                q.offer(new Position(nr, nc, curr.n, curr.d));
            } else if(home[nr][nc] == '.'){
                visited[nr][nc][curr.n] = true;
                q.offer(new Position(nr, nc, curr.n, curr.d));
            } else{
                visited[nr][nc][curr.n] = true;
                q.offer(new Position(nr, nc, curr.n, curr.d));
            }
        }
    }

    static class Position {
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
    }
}
