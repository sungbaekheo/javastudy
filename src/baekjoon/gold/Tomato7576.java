package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Tomato7576 {
  static int row;
  static int col;
  static int[][] box;
  static Queue<Point> q = new LinkedList<>();
  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, -1, 1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    col = Integer.parseInt(st.nextToken());
    row = Integer.parseInt(st.nextToken());
    box = new int[row][col];
    for(int r=0; r<row; r++){
      st = new StringTokenizer(br.readLine());
      for(int c=0; c<col; c++){
        box[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    for(int r=0; r<row; r++){
      for(int c=0; c<col; c++){
        if(box[r][c] == 1){
          q.offer(new Point(r, c));
        }
      }
    }

    BFS();
    int answer = 0;
    main: for(int r=0; r<row; r++){
      for(int c=0; c<col; c++){
        box[r][c]--;
        if(box[r][c] == -1){
          answer = -1;
          break main;
        }
        answer = Math.max(answer, box[r][c]);
      }
    }

    System.out.println(answer);

  }

  static void BFS(){
    while(!q.isEmpty()){
      Point curr = q.poll();
      for(int d=0; d<4; d++){
        int nr = curr.r + dr[d];
        int nc = curr.c + dc[d];
        if(nr<0 || nr>=row || nc<0 || nc>=col || box[nr][nc] != 0){
          continue;
        }
        q.offer(new Point(nr, nc));
        box[nr][nc] = box[curr.r][curr.c] + 1;
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
