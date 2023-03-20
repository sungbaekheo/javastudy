package baekjoon.silver;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class OrganicCabbage1012 {
  static int row;
  static int col;
  static int[][] field;
  static boolean[][] visited;
  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testCase = sc.nextInt();
    for(int t=0; t<testCase; t++){
      col = sc.nextInt();
      row = sc.nextInt();
      int nCabbage = sc.nextInt();
      field = new int[row][col];
      visited = new boolean[row][col];

      for(int i=0; i<nCabbage; i++){
        int c = sc.nextInt();
        int r = sc.nextInt();
        field[r][c] = 1;
      }

      int answer = 0;
      for(int r=0; r<row; r++){
        for(int c=0; c<col; c++){
          if(field[r][c] == 1 && !visited[r][c]){
            BFS(r, c);
            answer++;
          }
        }
      }
      System.out.println(answer);
    }
  }

  static void BFS(int r, int c){
    Queue<Point> q = new LinkedList<>();
    q.add(new Point(r, c));
    visited[r][c] = true;

    while(!q.isEmpty()){
      Point point = q.poll();
      for(int d=0; d<4; d++){
        int nr = point.x + dr[d];
        int nc = point.y + dc[d];
        if(nr<0 || nr>=row || nc<0 || nc>=col){
          continue;
        }
        if(field[nr][nc] == 1 && !visited[nr][nc]){
          q.add(new Point(nr,nc));
          visited[nr][nc] = true;
        }
      }
    }
  }

  static class Point{
    int x;
    int y;
    public Point(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
}
