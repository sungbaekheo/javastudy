/*
구간 합 구하기
백준 온라인저지 11659번, 실버III

수 N개가 주어졌을 때 i번째 수까지의 합 구하기

1번째 줄에 수의 개수 N (1<= N <= 100,000), 합을 구해야 하는 횟수 M (1 <= M <= 100,000)
2번째 줄에 N개의 수 각 수는 1,000보다 작거나 같은 자연수
3번째 줄부터 M개의 줄에 합을 구해야하는 구간 i와 j 주어짐
*/

/*
1. N개의 수를 입력받음과 동시에 합배열 생성
2. 구간 i~j가 주어지면 구간 합을 구하는 공식으로 정답 출력
*/

/*
PseudoCode
숫자 개수 N, 질의 개수 M 선언
for(숫자 개수만큼 반복){
    합 배열 생성하기(S[i] = S[i-1]+A[i]);
}
for(질의 개수만큼 반복하기){
    질의 범위 받기(i~j);
    구간 합 출력하기(s[j]-s[i-1]);
}
*/

package algorithm.datastructure.sumrange;

import java.util.Scanner;

public class SumRange {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int nNum = sc.nextInt();
        int nQ = sc.nextInt();
        int[] numArray = new int[nNum+1];
        for(int i=1; i<=nNum; i++){
            numArray[i] = numArray[i-1] + sc.nextInt();
        }
        for(int i=0; i<nQ; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(numArray[end]-numArray[start-1]);
        }
    }
    
}
