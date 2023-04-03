package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BabyShark16236 {
    static int size;
    static int[][] field;
    static int[][] dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        size = sc.nextInt();
        field = new int[size][size];
        dist = new int[size][size];
        visited = new boolean[size][size];
        Position start = null;
        
        for(int r=0; r<size; r++){
            for(int c=0; c<size; c++){
                field[r][c] = sc.nextInt();
                if(field[r][c] == 9){
                    start = new Position(r, c);
                }
            }
        }

        BFS(start);
        
    }

    public static void BFS(Position start) {
        Queue<Position> q = new LinkedList<>();
        q.offer(start);
        visited[start.r][start.c] = true;
        int babyShark = 2;
        Position nearest = null;
        while(!q.isEmpty()){
            Position curr = q.poll();
            for(int d=0; d<4; d++){
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if(nr<0 || nr>=size || nc<0 || nc>=size){
                    continue;
                }
            }
        }
    }
    
    static class Position {
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
