package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SafeZone2468 {
    static int[][] area;
    static boolean[][] visited;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        size = Integer.parseInt(br.readLine());
        area = new int[size][size];

        int max = 0;
        for(int r=0; r<size; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<size; c++){
                area[r][c] = Integer.parseInt(st.nextToken());
                max = max>area[r][c]? max:area[r][c];
            }
        }

        for(int i=1; i<=max; i++){
            visited = new boolean[size][size];
            DFS(0, 0, i);
        }
        

        
    }

    static void DFS(int r, int c, int rainH){
        
    }
}
