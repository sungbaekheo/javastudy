package baekjoon.gold;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class LiningUp2252 {
    static int N;
    static int M;
    static int[] degree;
    static List<Integer>[] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
    
        degree = new int[N+1];
        graph = new ArrayList[N+1];
    
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
    
        for(int i=0; i<M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph[start].add(end);
            degree[end]++;
        }

        topologicalSort();
    }

    public static void topologicalSort(){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(degree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr+" ");
            for(int i:graph[curr]){
                degree[i]--;
                if(degree[i] == 0){
                    q.offer(i);
                }
            }
        }
    }
}
