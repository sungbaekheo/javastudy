package baekjoon.silver;

import java.util.Scanner;

public class Virus2606{
    static int[][] graph;
    static boolean[] visited;
    static int infected = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
    
        int coms = sc.nextInt();
        int edge = sc.nextInt();
    
        graph = new int[coms+1][coms+1];
        visited = new boolean[coms+1];
    
        for(int i=0; i<edge; i++){
            int f = sc.nextInt();
            int r = sc.nextInt();
            
            graph[f][r] = graph[r][f] = 1;
        }
        
        DFS(1);
        
        System.out.println(infected);
    }
    
    static void DFS(int host){
        if(visited[host]){
            return;
        }
        
        visited[host] = true;
        if(host != 1){
            infected++;
        }
        
        for(int i=0; i<graph[host].length; i++){
            if(graph[host][i] == 1){
                DFS(i);
            }
        }
    }
}