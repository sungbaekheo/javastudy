package baekjoon.silver;

import java.util.Scanner;

public class MakeItOne1463{
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		
		for(int i=2; i<=N; i++) {
			int min = Integer.MAX_VALUE;
			
			min = Math.min(min, dp[i-1]+1);
			if(i%2 == 0) {
				min = Math.min(min, dp[i/2]+1);
			}
			if(i%3 == 0) {
				min = Math.min(min, dp[i/3]+1);
			}
			dp[i] = min;
		}
		System.out.println(dp[N]);
	}
}