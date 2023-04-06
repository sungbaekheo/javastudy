package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ADayForTheFullMoon1194 {
	static int row;
	static int col;
	static char[][] maze;
	static boolean[][][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		row = sc.nextInt();
		col = sc.nextInt();
		maze = new char[row][col];
		visited = new boolean[row][col][64];
		
		Position start = null;
		
		for(int r=0; r<row; r++) {
			String ln = sc.next();
			for(int c=0; c<col; c++) {
				maze[r][c] = ln.charAt(c);
				if(maze[r][c] == '0') {
					start = new Position(r, c, 0, 0);
				}
			}
		}
		BFS(start);	
	}
	
	public static void BFS(Position start) {
		Queue<Position> q = new LinkedList<>();
		q.offer(start);
		visited[start.r][start.c][start.key] = true;
		
		while(!q.isEmpty()) {
			Position curr = q.poll();
			if(maze[curr.r][curr.c] == '1') {
				System.out.println(curr.dist);
				return;
			}
			
			for(int d=0; d<4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if(nr<0 || nr>=row || nc<0 || nc>=col || visited[nr][nc][curr.key]) {
					continue;
				}
				
				if(maze[nr][nc] == '#') {
					continue;
				}
				
				if(maze[nr][nc]>='a' && maze[nr][nc]<='f') {
					int key = curr.key | (1<<(maze[nr][nc]-'a'));					
					if(!visited[nr][nc][key]) {
						visited[nr][nc][key] = true;
						visited[nr][nc][curr.key] = true;
						q.offer(new Position(nr, nc, curr.dist+1, key));
					}
					
				} else if(maze[nr][nc]>='A' && maze[nr][nc]<='F') {
					if((curr.key & (1<<(maze[nr][nc]-'A'))) > 0) {
						visited[nr][nc][curr.key] = true;
						q.offer(new Position(nr, nc, curr.dist+1, curr.key));
					}
					
				} else {
					visited[nr][nc][curr.key] = true;
					q.offer(new Position(nr, nc, curr.dist+1, curr.key));
				}
			}
		}
		System.out.println(-1);
	}
	
	static class Position {
		int r;
		int c;
		int dist;
		int key;
		
		public Position(int r, int c, int dist, int key) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.key = key;
		}
	}
}
