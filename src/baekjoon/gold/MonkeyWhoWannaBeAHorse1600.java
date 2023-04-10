package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MonkeyWhoWannaBeAHorse1600 {
	static int K;
	static int row;
	static int col;
	static int[][] map;
	static boolean[][][] visited;
	
	static int[] dr = {-1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dc = {0, 0, -1, 1, -2, -1, 1, 2, 2, 1, -1, -2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		visited = new boolean[row][col][K+1];
		
		for(int r=0; r<row; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<col; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		BFS(new Position(0, 0, 0, 0));
		
	}
	
	public static void BFS(Position start) {
		Queue<Position> q = new LinkedList<>();
		q.offer(start);
		visited[start.r][start.c][start.jump] = true;
		
		while(!q.isEmpty()) {
			Position curr = q.poll();
			
			if(curr.r == row-1 && curr.c == col-1) {
				System.out.println(curr.dist);
				return;
			}
			
			for(int d=0; d<4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if(nr<0 || nr>=row || nc<0 || nc>=col) {
					continue;
				}
				
				if(visited[nr][nc][curr.jump] || map[nr][nc] == 1) {
					continue;
				}
				visited[nr][nc][curr.jump] = true;
				q.offer(new Position(nr, nc, curr.dist+1, curr.jump));
			}	
			if(curr.jump == K){
					continue;
			}
			for(int d=4; d<12; d++){
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if(nr<0 || nr>=row || nc<0 || nc>=col) {
					continue;
				}
				
				if(visited[nr][nc][curr.jump+1] || map[nr][nc] == 1) {
					continue;
				}
				visited[nr][nc][curr.jump+1] = true;
				q.offer(new Position(nr, nc, curr.dist+1, curr.jump+1));
			}
		}
		System.out.println(-1);
	}
	
	static class Position {
		int r;
		int c;
		int dist;
		int jump;
		
		public Position(int r, int c, int dist, int jump) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.jump = jump;
		}
	}
}
