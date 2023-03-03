package baekjoon.silver;

import java.util.Arrays;
import java.util.Scanner;

public class ATM11399 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] order = new int[N];
    int[] sumArr = new int[N];
    for(int i=0; i<N; i++){
      order[i] = sc.nextInt();
    }
    Arrays.sort(order);
    sumArr[0] = order[0];
    for(int i=1; i<N; i++){
      sumArr[i] = sumArr[i-1]+order[i];
    }

    int sum = 0;
    for(int i=0; i<N; i++){
      sum+=sumArr[i];
    }
    System.out.println(sum);
  }
}
