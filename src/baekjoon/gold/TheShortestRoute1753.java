package baekjoon.gold;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TheShortestRoute1753 {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int V = sc.nextInt();
        int E = sc.nextInt();

        List<Node>[] nodes = new ArrayList[V+1];
        boolean[] visited = new boolean[V+1];
        int[] dist = new int[V+1];
        int start = sc.nextInt();

        for(int i=1; i<=V; i++){
            nodes[i] = new ArrayList<>();
        }

        for(int i=1; i<=V; i++){
            if(i == start){
                continue;
            }
            dist[i] = INF;
        }

        for(int i=0; i<E; i++){
            int u = sc.nextInt();
            int n = sc.nextInt();
            int w = sc.nextInt();

            nodes[u].add(new Node(n, w));
        }

        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int node = curr.node;
            
            if(visited[node]){
                continue;
            }
            visited[node] = true;

            for(int i=0; i<nodes[node].size(); i++){
                Node tmp = nodes[node].get(i);
                if(dist[tmp.node]>tmp.weight+dist[node]){
                    dist[tmp.node] = tmp.weight+dist[node];
                    pq.offer(new Node(tmp.node, dist[tmp.node]));
                }
            }
        }

        for(int i=1; i<=V; i++){
            if(visited[i]){
                System.out.println(dist[i]);
            } else {
                System.out.println("INF");
            }
        }
    }

    static class Node implements Comparable<Node> {
        int node;
        int weight;

        public Node(int node, int weight){
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

    }
}
