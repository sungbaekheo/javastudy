package baekjoon.silver;

import java.util.*;

 // Compiler version JDK 11.0.2

public class MazeSearch2178 {
    static int[][] maze;
    static boolean[][] visited;
    static int row;
    static int col;
    static int minRoute = Integer.MAX_VALUE;
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
        int route = 0;
        DFS(0, 0, route);
        BFS(0, 0);
        
        System.out.println(minRoute);
    }

    static void DFS(int r, int c, int route){
    
        if(r<0 || r>=row || c<0 || c>=col || maze[r][c] == 0){
            return;
        }
        if(visited[r][c] == true){
            return;
        }
    
        visited[r][c] = true;
        route++;
    
        if(r == row-1 && c == col-1){
            minRoute = minRoute<route? minRoute:route;
            return;
        }
        DFS(r-1, c, route);
        DFS(r+1, c, route);
        DFS(r, c-1, route);
        DFS(r, c+1, route);
    }

    static void BFS(int r, int c){
        Queue<Integer> q = new LinkedList<>();
        if(r<0 || r>=row || c<0 || c>=col || maze[r][c] == 0){
            return;
        }
    }
}
