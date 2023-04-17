package baekjoon.gold;

import java.util.Scanner;

public class SubTotal1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수열의 길이
        int S = sc.nextInt(); // 조건이 되는 합

        int[] arr = new int[N+1]; // 수열을 저장할 배열

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt(); // 수열 입력
        }

        int front = 0; // 앞 포인터
        int rear = 0; // 뒷 포인터
        int minLen = Integer.MAX_VALUE; // 최소값을 int의 최대값으로 선언
        int sum = arr[rear]; // 처음 합은 맨 처음 항
        while(rear<N){ // rear가 N보다 작을 동안
            if(sum<S){ // 합이 S보다 작으면
                sum+=arr[++rear]; // rear를 한 칸 뒤로 이동하고 누적합
            } else { // 합이 S보다 크거나 같으면
                int len = rear-front+1; // 길이를 재고
                minLen = Math.min(minLen, len); // 최소길이를 비교하여 업데이트
                sum-=arr[front++]; // front 포인터를 뒤로 당겨 다시 합을 줄임
            }
        }
        if(minLen == Integer.MAX_VALUE){ // S 이상이 되는 합을 못 구했다면
            System.out.println(0); // 0 출력
        } else { // 그렇지 않다면
            System.out.println(minLen); // 최소 길이 출력
        }
    }
}
