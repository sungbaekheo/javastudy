package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();

        int subin = sc.nextInt();
        int sister = sc.nextInt();
        int[] visited = new int[100001];

        visited[subin] = 1;
        q.offer(subin);

        while(!q.isEmpty()){
            int curr = q.poll();

            if(curr == sister){
                System.out.println(visited[curr]-1);
                break;
            }

            if(curr-1>=0 && visited[curr-1] == 0){
                visited[curr-1] = visited[curr]+1;
                q.offer(curr-1);
            }
            if(curr+1<=100000 && visited[curr+1] == 0){
                visited[curr+1] = visited[curr]+1;
                q.offer(curr+1);
            }
            if(curr*2<=100000 && visited[curr*2] == 0){
                visited[curr*2] = visited[curr]+1;
                q.offer(curr*2);
            }   
        }
    }
}