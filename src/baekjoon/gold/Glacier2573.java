package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Glacier2573 {
	static int row;
	static int col;
	static int[][] glacier;
	static int[][] melting;
	static boolean[][] visited;
	static int gCnt = 0;
	static int year = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		row = sc.nextInt();
		col = sc.nextInt();
		glacier = new int[row][col];
		
		for(int r=0; r<row; r++) {
			for(int c=0; c<col; c++) {
				glacier[r][c] = sc.nextInt();
			}
		}
		
		while(gCnt < 2) {
			melting = new int[row][col];
			visited = new boolean[row][col];
			
			int count = 0;
			for(int r=0; r<row; r++) {
				for(int c=0; c<col; c++) {
					if(glacier[r][c] != 0 && !visited[r][c]) {
						BFS(new Position(r, c));
						count++;
					}
				}
			}
			
			if(count == 0) { // 빙산이 다 녹을 때까지 분리되지 않으면
				year = 0;
				break;
			} else {
				meltGlacier();
				gCnt = count;
			}
		}
		
		System.out.println(year);
	}
	
	private static void meltGlacier() {
		year++;
		for(int r=0; r<row; r++) {
			for(int c=0; c<col; c++) {
				if(melting[r][c] != 0) {
					glacier[r][c]-=melting[r][c];
				}
				if(glacier[r][c] <0) {
					glacier[r][c] = 0;
				}
			}
		}
	}

	public static void BFS(Position start) {
		Queue<Position> q = new LinkedList<>();
		q.offer(start);
		visited[start.r][start.c] = true;
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		while(!q.isEmpty()) {
			Position curr = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				if(nr<0 || nr>=row || nc<0 || nc>=col || visited[nr][nc]) {
					continue;
				}
				if(glacier[nr][nc] == 0) {
					melting[curr.r][curr.c]++;
					continue;
				}
				visited[nr][nc] = true;
				q.offer(new Position(nr, nc));
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