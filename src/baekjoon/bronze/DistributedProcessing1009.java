package baekjoon.bronze;

import java.util.Scanner;

public class DistributedProcessing1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int testCase = sc.nextInt();
        int[][] td = {{10}, {1}, {2,4,8,6}, {3, 9, 7, 1}, {4,6},
                    {5}, {6}, {7, 9, 3, 1}, {8, 4, 2, 6}, {9, 1}
                    };
        
        for(int t=0; t<testCase; t++){
            int i = sc.nextInt()%10;
            int j = sc.nextInt();
            System.out.println(td[i][(j-1)%td[i].length]);
        }

    }
}