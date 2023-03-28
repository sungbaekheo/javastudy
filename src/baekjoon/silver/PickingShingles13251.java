package baekjoon.silver;

import java.util.Scanner;

public class PickingShingles13251 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    double [] shingles = new double[N]; // 조약돌 담을 주머니
    double sum = 0; // 전체 조약돌의 개수

    for(int i=0; i<N; i++){
      shingles[i] = sc.nextInt();
      sum += shingles[i];
    }

    int M = sc.nextInt();
    double per = 0;
    for(int i=0; i<N; i++){
      double tempSum = sum; // 시행마다 초기화
      int tempM = M; // 시행마다 초기화
      if(shingles[i] < M){ // 뽑으려는 조약돌의 수보다 적으면 건너 뜀
        continue;
      }
      double temp = 1;
      while(tempM>0){
        temp*=((shingles[i]--/tempSum--)); // 조약돌 뽑으면 조약돌 수와 전체 조약돌 수 1씩 깎기
        tempM--; // 뽑으려는 조약돌 수도 1 깎기
      }
      per+=temp; // 모든 확률 다 더하기
    }
    System.out.println(per);
  }
}
