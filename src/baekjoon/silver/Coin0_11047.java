package baekjoon.silver;

import java.util.Scanner;

public class Coin0_11047 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] coins = new int[N];
    int K = sc.nextInt();
    for(int i=0; i<N; i++){
      coins[i] = sc.nextInt();
    }

    int nCoin = 0;

    for(int i=coins.length-1; i>=0; i--){
      nCoin+=K/coins[i];
      K%=coins[i];
      if(K == 0){
        break;
      }
    }
    System.out.println(nCoin);
  }
}