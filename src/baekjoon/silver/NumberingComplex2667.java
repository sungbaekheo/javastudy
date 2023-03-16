package baekjoon.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class NumberingComplex2667 {
    static int size;
    static int[][] village; // 마을 정보 배열
    static boolean[][] visited; // 방문처리 배열
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우 델타배열
    static int[] dc = {0, 0, -1, 1};
    static List<Integer> numList = new ArrayList<>(); // 단지 수가 얼마나 나오든 유연하게 담을 리스트
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        size = Integer.parseInt(br.readLine());
        village = new int[size][size];
        visited = new boolean[size][size];
    
        for(int i=0; i<size; i++){
            char[] row = br.readLine().toCharArray();
            for(int j=0; j<size; j++){
                village[i][j] = row[j] - '0';
            }
        }
    
        int nComplex = 0; // 단지 수
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(village[i][j] == 1 && !visited[i][j]){
                    BFS(i, j);
                    nComplex++; // BFS가 한 번 실행될 때마다 단지 수 증가 처리
                }
            }
        }
        Collections.sort(numList); // 오름차순 정렬
        System.out.println(nComplex);
        for(int i=0; i<nComplex; i++){
            System.out.println(numList.get(i));
        }
    }
    
    static void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r, c}); // 시작점 큐에 입력
        visited[r][c] = true; // 방문처리
        
        int nHome = 0; // 단지에 있는 집의 수
        while(!q.isEmpty()){
            nHome++; 
            int[] point = q.poll();
            for(int d=0; d<4; d++){ // 사방탐색
                int nr = point[0] + dr[d];
                int nc = point[1] + dc[d];
                
                if(nr<0 || nr>=size || nc<0 || nc>=size){ // 배열 범위 이탈하면 리턴
                    continue;
                }
                
                if(village[nr][nc] == 1 && !visited[nr][nc]){ // 집이 있고 방문한 적이 없다면
                    q.add(new int[] {nr, nc}); // 큐에 좌표 넣기
                    visited[nr][nc] = true; // 해당 좌표 방문처리
                }
            }
        }
        numList.add(nHome); // 단지 별 집의 개수 리스트에 추가
    }
}
