package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindingNumber1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] numList = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            numList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numList);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int goal = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(numList, goal, 0, n-1));
        }
    }

    static int binarySearch(int[] numList, int goal, int i, int j){
        int mid = (i+j)/2;
        
        if(i>j){
            return 0;
        }

        if(numList[mid] == goal){
            return 1;
        } else if(numList[mid]>goal){
            return binarySearch(numList, goal, i, mid-1);
        } else {
            return binarySearch(numList, goal, mid+1, j);
        }
    }
}
