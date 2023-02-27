package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Josephus1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();

        int nPeople = sc.nextInt();
        int interval = sc.nextInt();

        for(int i=1; i<=nPeople; i++){
            q.offer(i);
        }

        sb.append("<");
        while(!q.isEmpty()){
            for(int i=0; i<interval-1; i++){
                q.offer(q.poll());
            }
            sb.append(q.poll());
            if(q.size() != 0){
                sb.append(", ");
            } else {
                sb.append(">");
            }
        }
        System.out.println(sb.toString());
    }
}