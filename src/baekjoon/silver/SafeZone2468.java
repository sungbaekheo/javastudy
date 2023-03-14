package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SafeZone2468 {
    static int[][] area; // 역역 배열
    static boolean[][] visited; // 방문처리 배열
    static int size; // 영역 크기
    static int rainH; // 강수량
    static int maxZone = 0; // 안전 영역이 최대인 수
    static int nZone; // 강수량 별 안전 영역 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        size = Integer.parseInt(br.readLine());
        area = new int[size][size];

        int max = 0; // 강수량 최대값
        for(int r=0; r<size; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<size; c++){
                area[r][c] = Integer.parseInt(st.nextToken());
                max = max>area[r][c]? max:area[r][c];
            }
        }

        for(int i=0; i<=max; i++){ // 강수량 반복
            rainH = i;
            visited = new boolean[size][size];
            nZone = 0;
            for(int r=0; r<size; r++){ // 영역을 돌면서 안전한 영역을 찾으면 DFS 실행
              for(int c=0; c<size; c++){
                if(visited[r][c] == false && area[r][c] > rainH){ // 방문하지 않았고 안전한 영역이면
                  DFS(r, c);
                  nZone++; // 영역 수 추가
                }
              }
            }
            maxZone = maxZone>nZone? maxZone:nZone;
        }
        System.out.println(maxZone);
        
    }

    static void DFS(int r, int c){
        if(r<0 || r>= size || c<0 || c>=size){ // 배열 범위 이탈 방지
          return;
        }
        if(visited[r][c] == true || area[r][c] <= rainH){ // 방문했거나 안전한 영역이 아니면 끝내기
          return;
        }
        visited[r][c] = true; // 방문 처리
        DFS(r-1, c);
        DFS(r+1, c);
        DFS(r, c-1);
        DFS(r, c+1);
    }
}
