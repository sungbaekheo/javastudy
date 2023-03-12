package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFSAndBFS1260 {
    static int[][] graph;
    static boolean[] visited;
    static int vertext;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        vertext = sc.nextInt();
        int edge = sc.nextInt();
        int start = sc.nextInt();

        graph = new int[vertext+1][vertext+1];
        visited = new boolean[vertext+1];

        for(int i=0; i<edge; i++){
            int c = sc.nextInt();
            int n = sc.nextInt();
            graph[c][n] = 1;
            graph[n][c] = 1 ;
        }

        DFS(start);
        System.out.println();
        visited = new boolean[vertext+1];
        BFS(start);

    }

    static void DFS(int node){
        if(visited[node] == true){
            return;
        }
        System.out.print(node+" ");
        visited[node] = true;
        for(int i=1; i<=vertext; i++){
            if(graph[node][i] == 1){
                DFS(i);
            }
        }
    }

    static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int cNode = q.poll();
            System.out.print(cNode+" ");
            for(int i=0; i<=vertext; i++){
                if(graph[cNode][i] == 1 && visited[i] == false){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
