package baekjoon.silver;

import java.util.Scanner;

public class MakingBridges1010 {
  static int N;
  static int M;
  static int answer;
  static int[][] dp;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int testCase = sc.nextInt();
    for(int t=0; t<testCase; t++){
      M = sc.nextInt();
      N = sc.nextInt();
      dp = new int[N+1][N+1];
      answer = combination(N, M);
      System.out.println(answer);
    }
  }

  public static int combination(int n, int m){
    if(dp[n][m] > 0){
      return dp[n][m];
    }
    if(m == n || m == 0){
      return dp[n][m] = 1;
    }
    return dp[n][m] = combination(n-1, m-1)+combination(n-1, m);
  }
}
