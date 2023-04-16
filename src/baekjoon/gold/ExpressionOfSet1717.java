package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ExpressionOfSet1717 {
    static int[] set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        set = new int[N+1];

        for(int i=0; i<=N; i++){
            set[i] = i;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch(op){
                case 0:
                    union(a, b);
                    break;
                case 1:
                    if(findset(a) == findset(b)){
                        sb.append("YES\n");
                    } else {
                        sb.append("NO\n");
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }

    public static int findset(int num){
        if(num == set[num]){
            return num;
        }
        return findset(set[num]);
    }

    public static void union(int a, int b){
        set[findset(b)] = findset(a);
    }
}
