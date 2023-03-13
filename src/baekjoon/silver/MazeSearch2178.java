package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Compiler version JDK 11.0.2

public class MazeSearch2178 {
    static int[][] maze;
    static boolean[][] visited;
    static int row;
    static int col;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        maze = new int[row][col];
        visited = new boolean[row][col];
        
        for(int r=0; r<row; r++){
            char[] rowArray = sc.next().toCharArray();
            for(int c=0; c<col; c++){
                maze[r][c] = rowArray[c] - '0';
            }
        }
        
        BFS(0, 0);
        
        System.out.println(maze[row-1][col-1]);
    }

    static void BFS(int r, int c){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r, c));
        visited[r][c] = true;
        while(!q.isEmpty()){
            Point point = q.poll();
            for(int d=0; d<4; d++){
                int nr = point.r + dr[d];
                int nc = point.c + dc[d];

                if(nr<0 || nr>=row || nc<0 || nc>=col){
                    continue;
                }
                if(visited[nr][nc] == true || maze[nr][nc] == 0){
                    continue;
                }
                q.add(new Point(nr, nc));
                maze[nr][nc]+=maze[point.r][point.c];
                visited[nr][nc] = true;
            }
        }
    }
    static class Point{
        int r;
        int c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}