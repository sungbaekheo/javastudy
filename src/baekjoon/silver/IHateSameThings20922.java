package baekjoon.silver;

import java.util.Scanner;

public class IHateSameThings20922 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 수열의 길이
        int K = sc.nextInt(); // 겹칠 수 있는 수의 개수

        int[] seq = new int[N]; // 수열을 저장할 배열
        int[] cntArr = new int[100001]; // 부분수열에 존재하는 수를 카운트할 배열

        for(int i=0; i<N; i++){
            seq[i] = sc.nextInt(); // 배열에 수 채워 넣기
        }

        int front = 0; // 앞 포인터
        int rear = 0; // 뒤 포인터
        int length = 1; // 초기 길이 어차피 하나 이상의 수열이니까 1로 초기화

        while(rear<N){ // rear가 N에 도달할 때까지
            cntArr[seq[rear]]++; // rear가 가리키는 수의 카운터 1 증가 시키기
            while(cntArr[seq[rear]]>K){ // 만약 rear가 가리키는 수가 K보다 크다면
                cntArr[seq[front++]]--; // K보다 작아질 때까지 front를 뒤로 당기기
            }
            rear++; // rear는 계속 오른쪽으로 이동
            length = Math.max(length, rear-front); // 수열의 길이는 rear-front 이고 현재 저장된 최대 길이보다 길다면 대체
        }
        System.out.println(length); // 최장 부분 수열의 길이 출력
    }
}