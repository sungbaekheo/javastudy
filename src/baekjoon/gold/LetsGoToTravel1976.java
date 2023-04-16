package baekjoon.gold;

import java.util.Scanner;

public class LetsGoToTravel1976 {
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] cities = new int[N+1][N+1];
        int[] route = new int[M+1];
        parent = new int[N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                cities[i][j] = sc.nextInt();
            }
        }

        for(int i=1; i<=M; i++){
            route[i] = sc.nextInt();
        }

        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(cities[i][j] == 1){
                    union(i, j);
                }
            }
        }
        int idx = findset(route[1]);
        for(int i=2; i<route.length; i++){
            if(idx != findset(route[i])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static int findset(int a){
        if(a == parent[a]){
            return a;
        }
        return findset(parent[a]);
    }

    public static void union(int a, int b){
        parent[findset(b)] = findset(a);
    }
}
