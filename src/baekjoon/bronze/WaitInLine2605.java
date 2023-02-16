package baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class WaitInLine2605 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] line = new int[num];
        for(int i=0; i<num; i++){
            line[i] = i+1;
        }
        for(int i=0; i<num; i++){
            int card = sc.nextInt();
            if(card == 0){
                continue;
            } else {
                int[] cpLine = Arrays.copyOfRange(line, i-card,i);
                line[i-card] = line[i];
                for(int j=1; j<=cpLine.length; j++){
                    line[i-card+j] = cpLine[j-1];
                }
            }
        }
        for(int i=0; i<num; i++){
            System.out.print(line[i] + " ");
        }
    }
}
