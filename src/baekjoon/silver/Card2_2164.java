package baekjoon.silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Card2_2164 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Queue<Integer> q = new LinkedList<>();

    int n = sc.nextInt();
    for(int i=1; i<=n; i++){
      q.add(i);
    }

    while(!(q.size() == 1)){
      q.poll();
      q.add(q.poll());
    }
    System.out.println(q.poll());
  }
}
