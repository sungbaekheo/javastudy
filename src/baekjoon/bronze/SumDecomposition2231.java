package baekjoon.bronze;

import java.util.Scanner;

public class SumDecomposition2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int answer = 0;
        for(int i=0; i<num; i++){
            int temp = i;
            char[] nums = String.valueOf(i).toCharArray();
            for(char c : nums){
                temp+= c-'0';
            }

            if(temp == num){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
