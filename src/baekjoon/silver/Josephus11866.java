package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Josephus11866 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    Queue<Integer> q = new LinkedList<>();

    int len = sc.nextInt();
    int interval = sc.nextInt();
    for(int i=1; i<=len; i++){
      q.add(i);
    }
    sb.append("<");
    while(!q.isEmpty()){
      for(int i=0; i<interval-1; i++){
        q.add(q.poll());
      }
      if(q.size() != 1){
        sb.append(q.poll()+", ");
      } else {
        sb.append(q.poll()+">");
      }
    }
    System.out.println(sb.toString());
  }
}
