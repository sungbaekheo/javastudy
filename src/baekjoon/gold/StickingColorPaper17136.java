package baekjoon.gold;

import java.util.Scanner;

public class StickingColorPaper17136 {
    static int[] papers = {0, 5, 5, 5, 5, 5};
    static int[][] map;
    static int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new int[10][10];
        for(int r=0; r<10; r++){
            for(int c=0; c<10; c++){
                map[r][c] = sc.nextInt();
            }
        }

        min = Integer.MAX_VALUE;

        DFS(0);

        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    private static void DFS(int cnt){
        // 1. 왼쪽 위부터 오른쪽 아래로 탐색하면서
        //    가장 처음으로 색종이를 붙일 수 있는 곳을 찾기
        int sR = -1;
        int sC = -1;
        out: for(int r=0; r<10; r++){
            for(int c= 0; c<10; c++){
                if(map[r][c] == 1){
                    sR = r;
                    sC = c;
                    break out;
                }
            }
        }

        //붙일 곳을 못찾은 경우
        // 모두 0인 상황(다 붙인 경우)
        if(sR == -1 && sC ==-1){
            min = Math.min(min, cnt);
            return;
        }

        // 2. 그지점에서 최대로 몇갈래로 뻗어나갈 수 있는지 찾기
        // 최대로 붙일 수 있는 종이의 크기 찾기
        int max = 5;
        while(max>0){
            boolean isOk = true;
            out: for(int r=0; r<max; r++){
                for(int c=0; c<max; c++){
                    //경계조건 체크
                    // 중간에 0이 있으면 붙일 수 없음
                    if(sR+r >= 10 || sC + c >= 10 || map[sR+r][sC+c] == 0){
                        isOk = false;
                        break;
                    } 
                }
            }
            // 만약에 찾았다면 while문 빠져나오기
            if(isOk){
                break;
            }
            // 못찾았다면 max를 하나 줄이고 다시
            max--;
        }
        // 3. 각 갈래로 DFS 재귀 호출(총 max 개의 길이 있음)
        for(int size=1; size<=max; size++){
            // 해당 크기의 색종이가 있는지 검사
            // 없다면 패스(그 다음 크기의 색종이로 감)
            if(papers[size] == 0){
                continue;
            }
            // 붙일 수 있다면 색종이를 붙이고
            paste(sR, sC, size, 0);
            papers[size]--;
            //DFS
            DFS(cnt+1);

            // 초기화(색종이 떼기)
            paste(sR, sC, size, 1);
            papers[size]++;

        }
    }
    private static void paste(int sR, int sC, int size, int num){
        for(int r=sR; r<sR+size; r++){
            for(int c=sC; c<sC+size; c++){
                map[r][c] = num;
            }
        }
    }
}
