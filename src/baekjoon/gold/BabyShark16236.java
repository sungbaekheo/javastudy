package baekjoon.gold;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BabyShark16236 {
    static int size;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        map = new int[size][size];
        Position start = null;

        for(int r=0; r<size; r++){
            for(int c=0; c<size; c++){
                map[r][c] = sc.nextInt();
                if(map[r][c] == 9){
                    start = new Position(r, c, 0);
                }
            }
        }
        BFS(start);
        System.out.println(answer);
    }
    private static void BFS(Position start) {
        int babyShark = 2;
        int count = 0;
        while(true){
            visited = new boolean[size][size];
            dist = new int[size][size];
            Queue<Position> distQ = new LinkedList<>();
            PriorityQueue<Position> preys = new PriorityQueue<>();
    
            distQ.offer(start);
            visited[start.r][start.c] = true;

            while(!distQ.isEmpty()){
                Position curr = distQ.poll();
                for(int d=0; d<4; d++){
                    int nr = curr.r + dr[d];
                    int nc = curr.c + dc[d];
                    
                    if(nr<0 || nr>=size || nc<0 || nc>=size || map[nr][nc]>babyShark){
                        continue;
                    }

                    if(!visited[nr][nc]){
                        visited[nr][nc] = true;
                        dist[nr][nc] = dist[curr.r][curr.c] + 1;
                        distQ.offer(new Position(nr, nc, dist[nr][nc]));

                        if(map[nr][nc]<babyShark && map[nr][nc]>0){
                            preys.offer(new Position(nr, nc, dist[nr][nc]));
                        }
                    }
                }
            }

            if(!preys.isEmpty()){
                map[start.r][start.c] = 0;
                start = preys.poll();
                answer+=dist[start.r][start.c];
                map[start.r][start.c] = 0;
                count++;
            } else {
                break;
            }
            
            if(count == babyShark){
                babyShark++;
                count = 0;
            }
        }
    }

    static class Position implements Comparable<Position> {
        int r;
        int c;
        int d;

        public Position(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }

        public int compareTo(Position o) {
            if(this.d == o.d){
                if(this.r == o.r){
                    return this.c - o.c;
                }
                return this.r - o.r;
            }
            return this.d - o.d;
        }
    }
}