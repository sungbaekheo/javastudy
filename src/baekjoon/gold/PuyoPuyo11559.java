package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PuyoPuyo11559 {
    static char[][] map = new char[12][6];
    static char[][] copiedMap = new char[12][6];
    static boolean[][] visited;
    static int popped;
    static int chain = 0;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int r=0; r<12; r++){
            map[r] = br.readLine().toCharArray();
        }

        while(true){
            popped = 0;

            copyMap();
            visited = new boolean[12][6];

            for(int r=11; r>=0; r--){
                for(int c=5; c>=0; c--){
                    if(copiedMap[r][c] != '.' && !visited[r][c]){
                        BFS(new Position(r, c));
                    }
                }
            }

            if(popped == 0){
                break;
            } else {
                gravity();
            }
            chain++;
        }
        System.out.println(chain);
    }

    public static void gravity(){
        for(int c=0; c<6; c++){
            Queue<Character> gravity = new LinkedList<>();
            for(int r=11; r>=0; r--){
                if(copiedMap[r][c] != '.'){
                    gravity.offer(copiedMap[r][c]);
                }
            }
            for(int r=11; r>=0; r--){
                if(!gravity.isEmpty()){
                    map[r][c] = gravity.poll();
                } else {
                    map[r][c] = '.';
                }
            }
        }
    }

    public static void copyMap(){
        for(int r=0; r<12; r++){
            for(int c=0; c<6; c++){
                copiedMap[r][c] = map[r][c];
            }
        }
    }

    public static void BFS(Position start){
        Queue<Position> q = new LinkedList<>();
        boolean[][] pVisited = new boolean[12][6];
        q.offer(start);
        visited[start.r][start.c] = true;
        pVisited[start.r][start.c] = true;
        char color = map[start.r][start.c];

        int cnt = 0;

        while(!q.isEmpty()){
            Position curr = q.poll();
            cnt++;
            for(int d=0; d<4; d++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(nr<0 || nr>=12 || nc<0 || nc>=6){
                    continue;
                }

                if(copiedMap[nr][nc] == color && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    pVisited[nr][nc] = true;
                    q.offer(new Position(nr, nc));
                }
            }
        }
        if(cnt>=4){
            popped++;
            
            for(int r=11; r>=0; r--){
                for(int c=5; c>=0; c--){
                    if(pVisited[r][c] && copiedMap[r][c] == color){
                        copiedMap[r][c] = '.';
                    }
                }
            }
        }
    }

    static class Position{
        int r;
        int c;

        public Position(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
