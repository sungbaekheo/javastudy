/*
 * 백준 온라인 저지 1546번, 브론즈 I
 * 
 * 세준이는 기말고사를 망쳐서 점수를 조작해 집에 가져가기로 결심했다.
 * 자기 점수 중 최댓값을 고르고 그 값을 M이라고 할 때, 모든 점수를 점수/M*100으로 고쳤다
 * 최고점이 70점, 수학 점수가 50점이라면 수학 점수는 50/70*100이므로 71.43점이다
 * 세준이의 새로운 성적 평균을 구하는 프로그램을 작성하시오
 * 
 * 1번째 줄에 시험을 본 과목의 개수 N
 * N <= 1000
 * 2번째 줄에 세준이의 현재 성적이 주어짐
 * 0 <= 성적 <= 100, 적어도 한 개의 값은 0보다 큼
 * 
 * 1번째 줄에 새로운 평균을 출력
 * 
 * 변환 점수의 평균을 구하는 식(점수가 A, B, C인 경우)
 * (A / M * 100 + B / M * 100 + C / M * 100) / 3 = (A + B + C) * 100 / M / 3
 */

/*
 * 점수를 1차원 배열에 저장한다.
 * 배열을 탐색하며 최고 점수와 점수의 총합을 구한다.
 * 공식을 사용해 다시 계산한 점수의 평균값을 출력한다.
 * 
 */

/*
 * Pseudo Code
 * 변수 N에 과목의 수 입력 받기
 * 길이가 N인 1차원 배열 A[] 선언하기
 * for(A[]길이만큼 반복){
 *      A[i]에 각 점수 저장하기
 * }
 * for(A[] 길이만큼 반복){
 *      최고점은 변수 max에, 합은 변수 sum에 저장하기
 * }
 * sum * 100 / max / N 출력하기
 */

package algorithm.datastructure.arrayandlist;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] scoreArray = new int[N];
        int max = 0;
        int sum = 0;

        for(int i = 0; i < scoreArray.length; i++){
            scoreArray[i] = sc.nextInt();
        }

        for(int i = 0; i < scoreArray.length; i++){
            if(scoreArray[i] > max){
                max = scoreArray[i];
            }
            sum+=scoreArray[i];
        }
        System.out.println(sum * 100.0 / max / N);
    }
    
}
