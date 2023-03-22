package baekjoon.silver;

import java.util.Scanner;

public class MovieDirectorShome1436 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int goal = sc.nextInt();
    int count = 0;
    int current = 666;
    while(count != goal){
      String curr = String.valueOf(current);
      if(curr.contains("666")){
        count++;
      }
      current++;
    }
    System.out.println(current-1);
  }
}
