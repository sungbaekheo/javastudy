package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GoingDown2096 {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][][] ladder = new int[N+1][3][2];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				int input = Integer.parseInt(st.nextToken());
				int min = ladder[i-1][j][0];
				int max = ladder[i-1][j][1];

				for(int k=-1; k<=1; k++) {
					if(j+k<0 || j+k>=3) {
						continue;
					}
					min = Math.min(min, ladder[i-1][j+k][0]);
					max = Math.max(max, ladder[i-1][j+k][1]);

					ladder[i][j][0] = min+input;
					ladder[i][j][1] = max+input;
				}
			}
		}
		
		int resMin = Integer.MAX_VALUE, resMax = Integer.MIN_VALUE;
		for(int i=0; i<3; i++){
			resMin = Math.min(resMin, ladder[N][i][0]);
			resMax = Math.max(resMax, ladder[N][i][1]); 
		}

		System.out.println(resMax+" "+resMin);
	}
}
