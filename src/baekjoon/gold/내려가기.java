package baekjoon.gold;

import java.util.Scanner;

public class 내려가기 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][][] ladder = new int[N+1][3][2];
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<3; j++) {
				int input = sc.nextInt();
				for(int k=-1; k<=1; k++) {
					if(j+k<0 || j+k>=3) {
						continue;
					}
					ladder[i][j][0] = Math.min(ladder[i-1][j][0], ladder[i-1][j+k][0])+input;
				}
			}
		}
		
		
	}
}
