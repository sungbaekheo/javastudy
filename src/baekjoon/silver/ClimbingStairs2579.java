package baekjoon.silver;

import java.util.Scanner;

public class ClimbingStairs2579 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] stair = new int[N+1][2];
		
		for(int i=1; i<=N; i++) {
			int value = sc.nextInt();
			if(i==1) {
				stair[i][1] = value;
			} else {
				stair[i][1] = Math.max(stair[i-2][0], stair[i-2][1]) + value;
			}
			stair[i][0] = value + stair[i-1][1];
		}
		
		System.out.println(Math.max(stair[N][0], stair[N][1]));
	}
}
