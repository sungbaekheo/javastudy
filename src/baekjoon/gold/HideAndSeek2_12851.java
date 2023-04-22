package baekjoon.gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek2_12851 {
    static int[] visited = new int[100001];
    static int sis;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int subin = sc.nextInt();
        sis = sc.nextInt();

        BFS(new Position(subin, 0));

    }

    public static void BFS(Position start){
        Queue<Position> q = new LinkedList<>();
        q.offer(start);
        visited[start.p] = start.sec;

        int fastest = Integer.MAX_VALUE;
        int cntWay = 0;
        while(!q.isEmpty()){
            Position curr = q.poll();
            if(curr.sec <= fastest){
                if(curr.p == sis){
                    fastest = curr.sec;
                    cntWay++;
                }
                if(curr.p-1>=0 && (visited[curr.p-1] == 0 || visited[curr.p-1] == curr.sec+1)){
                    visited[curr.p-1] = curr.sec+1;
                    q.offer(new Position(curr.p-1, curr.sec+1));
                }

                if(curr.p+1<=100000 && (visited[curr.p+1] == 0 || visited[curr.p+1] == curr.sec+1)){
                    visited[curr.p+1] = curr.sec+1;
                    q.offer(new Position(curr.p+1, curr.sec+1));
                }
                if(curr.p*2<=100000 && (visited[curr.p*2] == 0 || visited[curr.p*2] == curr.sec+1)){
                    visited[curr.p*2] = curr.sec+1;
                    q.offer(new Position(curr.p*2, curr.sec+1));
                }
            }
        }
        System.out.println(fastest);
        System.out.println(cntWay);
    }

    static class Position{
        int p;
        int sec;

        public Position(int p, int sec){
            this.p = p;
            this.sec = sec;
        }
    }
}
