package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WallBreaker2206 {
	static int[][] map;
	static boolean[][][] visited;
	static int N, M;
	static int min;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M][2]; // 상태 2개 (벽을 부쉈거나, 안 부쉈거나)
		
		for(int r=0; r<N; r++) {
			String ln = sc.next();
			for(int c=0; c<M; c++) {
				map[r][c] = ln.charAt(c) - '0';
			}
		}
		
		// bfs 탐색
		min = Integer.MAX_VALUE;
		BFS();
		// 결과 출력
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}
	
	public static void BFS() {
		// 1. 큐를 만들고
		Queue<Position> q = new LinkedList<>();
		// 2. 시작 정점을 방문처리 후에 넣은 후
		visited[0][0][0] = true;
		q.offer(new Position(0, 0, 0, 1));
		// 3. while문
		while(!q.isEmpty()) {
			Position curr = q.poll();
			
			if(curr.r == N-1 && curr.c == M-1) {
				min = Math.min(curr.dist, min);
			}
			
			for(int d=0; d<4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];
				
				// 경계조건
				if(nr<0 || nr>=N || nc<0 || nc>=M) {
					continue;
				}
				
				// 1. 벽이 아닌 경우
				if(map[nr][nc] == 0 && !visited[nr][nc][curr.cnt]) {
					visited[nr][nc][curr.cnt] = true;
					q.offer(new Position(nr, nc, curr.cnt, curr.dist+1));
				}
				// 2. 벽인 경우
				if(map[nr][nc] == 1 && curr.cnt == 0 && !visited[nr][nc][curr.cnt+1]) {
					visited[nr][nc][curr.cnt+1] = true;
					q.offer(new Position(nr, nc, curr.cnt+1, curr.dist+1));
				}
			}
		}
	}
	
	static class Position {
		int r;
		int c;
		int cnt;
		int dist;
		
		public Position(int r, int c, int cnt, int dist) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dist = dist;
		}
	}
}
