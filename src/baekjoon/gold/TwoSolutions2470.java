package baekjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSolutions2470 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 입력될 수의 개수

        int[] arr = new int[N]; // 수를 저장할 배열

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt(); // 값 저장
        }

        Arrays.sort(arr); // 0에 가까워지는 것을 찾기 위함으로 정렬 수행

        int front = 0; // 앞 포인터
        int rear = N-1; // 뒷 포인터
        int diff = Integer.MAX_VALUE; // 일단 차이를 최대값으로 선언해놓음

        int smaller = 0; // 왼쪽 값
        int bigger = 0; // 오른쪽 값

        while(front < rear){ // 앞 포인터가 뒤 포인터보다 작을 동안
            int sum = arr[front] + arr[rear]; // 두 포인터가 위치한 곳의 합
            if(Math.abs(sum)<diff){ // 그 합의 절대값이 저장된 최소차이값보다 작으면
                diff = Math.abs(sum); // 최소값 업데이트
                smaller = arr[front]; // 왼쪽값 업데이트
                bigger = arr[rear]; // 오른쪽값 업데이트
            }

            if(sum<0){ // 앞이 음수이면
                front++; // 앞포인터를 땡겨서 양수 쪽으로 올림
            } else { // 반대라면
                rear--; // 뒷포인터를 당겨서 음수 쪽으로 내림
            }
        }

        System.out.println(smaller+" "+bigger);
    }
}
