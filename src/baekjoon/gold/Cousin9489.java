package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cousin9489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){ // 0 0을 입력받기 전까지 반복
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 노드의 개수
            int target = Integer.parseInt(st.nextToken()); // 사촌을 구해야 하는 노드 번호
            int[] tree = new int[N+1]; // 노드 저장할 트리 배열
            int[] parent = new int[N+1]; // 각 노드별 부모정보를 저장할 부모 배열
            
            parent[0] = -1; // 0번째 인덱스는 걍 -1로 둠
            int count = 0; // 사촌의 수

            if(N == 0 && target == 0){
                break; // 0 0을 입력받으면 반복 종료
            }

            st = new StringTokenizer(br.readLine());

            int pIdx = 0; // 1차이가 나지 않을 때마다 올릴 부모노드 인덱스 변수
            int targetP = 0; // 타겟의 부모 인덱스
            int parentP = 0; // 타겟의 조부모 인덱스

            for(int i=1; i<=N; i++){ // 노드의 수만큼 반복
                int now = Integer.parseInt(st.nextToken()); // 노드
                tree[i] = now; // 노드 저장
                if(i>1){ // 1보다 크고
                    if(now - tree[i-1] != 1){ // 앞서 입력받은 노드와 1차이가 아니라면
                        pIdx++; // 부모를 바꾸고
                    }
                    parent[i] = pIdx; // 해당 노드의 부모 정보 입력
                }
                if(now == target){ // 입력받은 값이 목표 타겟이면
                    targetP = pIdx; // 타겟의 부모 인덱스 저장
                    parentP = parent[pIdx]; // 타겟의 조부모 인덱스 저장
                }
            }

            for(int i=1; i<=N; i++){ // 전체 쭈욱 순회
                // 부모가 같지 않고 조부모가 같은 동일한 레벨의 사촌들이면
                if(parent[i] != targetP && parent[parent[i]] == parentP){
                    count++; // 카운트해줌
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}