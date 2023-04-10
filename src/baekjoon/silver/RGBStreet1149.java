package baekjoon.silver;

import java.util.Scanner;

public class RGBStreet1149 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] dp = new int[N+1][3];
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<3; j++) {
				int input = sc.nextInt();
				dp[i][j] = input + Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]);
			}
		}
		
		int answer = dp[N][0];
		for(int i=0; i<3; i++) {
			answer = Math.min(dp[N][i], answer);
		}
		
		System.out.println(answer);
	}
}
