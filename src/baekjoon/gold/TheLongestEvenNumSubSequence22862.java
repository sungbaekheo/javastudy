package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheLongestEvenNumSubSequence22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 주어지는 수열의 길이
        int K = Integer.parseInt(st.nextToken()); // 제거할 수 있는 홀수의 개수
        int[] seq = new int[N]; // 수열을 담을 배열
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){ // 수열 입력 받기
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int front = 0; // 투 포인터 중 앞 포인터
        int rear = 0; // 뒷 포인터
        int maxLen = 0; // 최장 짝수 수열의 길이
        int Kcnt = K; // 부분 수열 내 홀 수 개수 카운트

        while(rear<N){ // 뒷 포인터가 맨 끝부분에 도달할 때까지
            if(seq[rear++]%2 != 0){ // 만약 홀수를 만난다면
                Kcnt--; // 허용된 홀수 개수에서 1만큼 차감
            }
            while(Kcnt == -1){ // 허용된 개수보다 작아졌다면 다시 허용 범위로 돌아올 때까지
                if(seq[front++] %2 != 0){ // 홀수를 만날 때까지 앞 포인터 당기기
                    Kcnt++; // 홀수를 만나면 홀수 카운트 1 증가 시키고 그 뒤로 포인터 옮기기 
                }
            }
            maxLen = Math.max(maxLen, rear-front-K+Kcnt);
            // 맨 끝 포인터와 맨 앞 포인터의 차에 최대 제거 가능한 홀수 수만큼 제외하고 Kcnt값이 남았으면 더해줌
        }
        System.out.println(maxLen);
    }
}
