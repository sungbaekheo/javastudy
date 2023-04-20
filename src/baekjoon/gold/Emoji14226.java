package baekjoon.gold;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Emoji14226{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<Point> q = new LinkedList<>();
        
        int goal = sc.nextInt(); // 목표 이모티콘 개수
        boolean[][] visited = new boolean[1001][1001]; // 이모티콘 수와 클립보드에 저장된 값을 표현할 방문처리 배열
        
        visited[1][0] = true; // 처음 시작 방문
        q.offer(new Point(1, 0, 0)); // 처음 시작점 1개 이모티콘에서 0개의 클립보드

        while(!q.isEmpty()){ // 큐가 빌 때까지 반복
            Point curr = q.poll();
            if(curr.p == goal){ // 큐에서 뽑은 현재 이모티콘의 값이 목표와 같다면
                System.out.println(curr.task); // 출력하고
                break; // 종료
            }
            if(!visited[curr.p][curr.p]){ // 현재 이모티콘 개수와 이 수만큼 복사한 적이 없으면
                q.offer(new Point(curr.p, curr.p, curr.task+1)); // 복사한다
            }
            
            int next = curr.p + curr.clipBoard; // 복붙하고난 후 이모티콘 개수
            if(next <= 1000 && !visited[next][curr.clipBoard] && curr.clipBoard>0){ // 복붙 후 이모티콘 개수와 클립보드 수의 방문처리 배열에 들른 적이 없고 클립보드가 0보다 크면
                visited[next][curr.clipBoard] = true; // 방문처리 하고
                q.offer(new Point(next, curr.clipBoard, curr.task+1)); // 복붙한 정보 저장
            }
            next = curr.p - 1; // 현재 이모티콘 개수에서 1을 까고 난 후의 개수
            if(next>1 && !visited[next][curr.clipBoard]){ // 1 까고난 후의 수와 클립보드 수의 방문처리 배열에 방문한 적이 없으면
                visited[next][curr.clipBoard] = true; // 방문처리 하고
                q.offer(new Point(next, curr.clipBoard, curr.task+1)); // 1 깎은 위치 정보 저장
            }
        }   
    }

    static class Point{
        int p;
        int clipBoard;
        int task;
        
        public Point(int p, int clipBoard, int task){
            this.p = p;
            this.clipBoard = clipBoard;
            this.task = task;
        }
    }
}