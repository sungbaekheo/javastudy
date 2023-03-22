package baekjoon.silver;

import java.util.Scanner;

public class PrimeNumber1929 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int start = sc.nextInt();
    int end = sc.nextInt();

    for(int i=start; i<=end; i++){
      boolean isPrime = true;
      for(int j=2; j<=Math.sqrt(i)+1; j++){
        if(i == 1 || i%j == 0){
          isPrime = false;
          break;
        }
      }
      if(i == 2){
        isPrime = true;
      }
      if(isPrime){
        System.out.println(i);
      }
    }
  }
}
