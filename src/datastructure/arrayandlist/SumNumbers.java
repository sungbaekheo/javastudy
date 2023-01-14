/*
 * 백준 온라인 저지 11720번, 브론즈 II
 * 
 *  N 개의 숫자가 공백 없이 써 있다. 이 숫자를 모두 합해 출력하는 프로그램을 작성하시오.
 * 
 * 1번째 줄에 숫자의 개수 N(1 <= N <= 100), 2번째 줄에 숫자 N개가 공백 없이 주어진다.
 * 
 * 입력으로 주어진 숫자 N개의 합을 출력한다.
 * 
 * N의 범위가 1부터 100까지이므로 값을 int형, long형과 같은 숫자형으로 담을 수 없다.
 * 문자열 형태로 입력값을 받은 후 이를 문자 배열로 변환하고, 문자 배열값을 순서대로 읽으면서 숫자형으로 변환하여 더해야 한다.
 * 1234 -> "1234" -> { '1', '2', '3', '4' } -> 1 + 2 + 3 + 4 = 10
 * 
 */

/*
 * Pseudo Code
 * 1. 숫자의 개수만큼 입력받은 값을 String형으로 저장합니다.
 * 2. String형으로 입력받은 값을 char[]형으로 변환합니다.
 * 3. 인덱스 0부터 끝까지 배열을 탐색하며 각 값을 정수형으로 변환하고 결괏값에 더하여 누적합니다.
 */

 package datastructure.arrayandlist;

import java.util.Scanner;

public class SumNumbers {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nNum = sc.nextInt();
        String inputNumber = sc.next();
        char[] numArray = inputNumber.toCharArray();
        int sum = 0;
        for(int i = 0; i < nNum; i++){
            sum += numArray[i] - '0';
        }
        System.out.println(sum);

     }
 }
 