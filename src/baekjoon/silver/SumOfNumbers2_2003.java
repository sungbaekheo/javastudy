package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfNumbers2_2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] numArr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int front = 0;
		int rear = 0;
		int sum = numArr[front];
		int count = 0;
		
		while(rear<=N-1) {
			if(sum == M) {
				count++;
				sum-=numArr[front++];
				sum+=numArr[++rear];
			} else if(sum<M) {
				sum+=numArr[++rear];
			} else {
				sum-=numArr[front++];
			}
		}
		
		System.out.println(count);
	}
}
