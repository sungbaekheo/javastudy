package baekjoon.gold;

import java.util.Scanner;

public class RotatingSushi15961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 회전 초밥 개수
        int d = sc.nextInt(); // 회전 초밥 가지 수
        int k = sc.nextInt(); // 연속으로 먹었을 때 할인 적용 되는 수
        int c = sc.nextInt(); // 쿠폰 초밥
        int[] sushi = new int[N]; // 초밥 담을 배열
        int[] cnt = new int[d+1]; // 초밥 종류의 카운팅 배열

        for(int i=0; i<N; i++){
            sushi[i] = sc.nextInt(); // 초밥 정보 입력 받기
        }

        // k 라는 고정된 크기가 있으므로 슬라이딩 윈도우로 접근
        int front = 0; // 앞쪽 인덱스
        int rear = -1; // 뒤쪽 인덱스
        int max = Integer.MIN_VALUE; // 가장 큰 값을 구해야 하므로 최소값으로 선언
        int kinds = 0; // 초밥 종류

        for(int i=0; i<k; i++){ // 맨 처음 슬라이딩 윈도우 선언
            if(cnt[sushi[++rear]] == 0){  // 만약 뒤쪽 인덱스의 초밥이 선택되지 않았었다면
                kinds++; // 종류 수 추가
            }
            cnt[sushi[rear]]++; // 초밥 종류 카운팅 ++
        }

        // 회전초밥처럼 원형으로 접근했음
        while(rear%N != k-2){ // 뒤쪽 포인터가 k-1번째 초밥을 가리키면(이미 k로 rear가 시작하기 때문에 k-1이라면 한바퀴 돌았다는 뜻) 반복 종료
            if(cnt[c] == 0){ // 쿠폰 초밥을 선택하지 않았다면
                max = Math.max(kinds+1, max); // 최종 종류수에 1을 더 더하기
            }
            max = Math.max(kinds, max); // 아니면 걍 종류 저장해 놓은 것과 새로 카운트한 종류 중 최대값

            if(cnt[sushi[front%N]]==1){ // 앞쪽을 뒤로 한칸 옮기는데 카운팅배열의 값이 1이었다면
                kinds--; // 종류 수 하나 줄이고
            }
            cnt[sushi[front%N]]--; // 카운팅 배열 줄임
            front++; // 앞 인덱스++

            rear++; // 뒤쪽 인덱스++
            if(cnt[sushi[rear%N]]==0){ // 뒤쪽 초밥을 전에 선택하지 않았다면
                kinds++; // 종류 추가
            }
            cnt[sushi[rear%N]]++; // 선택한 초밥 카운팅++
        }
        System.out.println(max); // 저장된 최대값 출력
    }
}
