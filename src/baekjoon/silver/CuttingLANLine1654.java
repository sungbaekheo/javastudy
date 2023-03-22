package baekjoon.silver;

import java.util.Scanner;

public class CuttingLANLine1654 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt();
    int goal = sc.nextInt();
    int[] lines = new int[N];

    long min = 0;
    long max = 0;
    for(int i=0; i<N; i++){
      lines[i] = sc.nextInt();
      max = max>lines[i]? max:lines[i];
    }

    max++;
    while(min < max){
      long mid = (min+max)/2;
      long count = 0;

      for(int i=0; i<N; i++){
        count+=lines[i]/mid;
      }

      if(count < goal){
        max = mid;
      } else {
        min = mid+1;
      }
    }

    System.out.println(min-1);
  }
}
