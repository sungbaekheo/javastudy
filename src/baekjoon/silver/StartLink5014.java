package baekjoon.silver;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class StartLink5014 {
  static int total;
  static int[] floors;
   public static void main(String[] args){
     Scanner sc = new Scanner(System.in);
     
     total = sc.nextInt();
     int start = sc.nextInt();
     int end = sc.nextInt();
     int up = sc.nextInt();
     int down = sc.nextInt();
     
     floors = new int[total+1];
     
     if((Math.abs(start-end)%Math.abs(up-down) !=0)
     || (start>end && down == 0)
     || (start<end && up == 0)){
      System.out.println("use the stairs");
     } 

     BFS(start, end, up, down); 
     System.out.println(floors[end]);
   }
   
   static void BFS(int s, int e, int u, int d){
     Queue<Integer> q = new LinkedList<>();
     q.add(s);
     int count = 0;
     while(!q.isEmpty()){
       int curr = q.poll();
       if(floors[curr] == 0){
         floors[curr] = count;
       }
       if(curr == e){
         return;
       }
       if(e > curr && curr-d>=1){
         q.add(curr+u);
       } else if(e < curr && curr+u<=total) {
         q.add(curr-d);
       }
       count++;
     }
   }
 }