package baekjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

public class Good1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int[] numList = new int[len];
        for(int i=0; i<len; i++){
            numList[i] = sc.nextInt();
        }
        Arrays.sort(numList);
        for(int i:numList){
            System.out.print(i+" ");
        }
        System.out.println();
        int count = 0;
        for(int i=2; i<len; i++){
            int f = 0;
            int p = 1;
            while(true){
                if(numList[i] == numList[f]+numList[p]){
                    count++;
                    System.out.println(numList[i] + " " + f + " " + p);
                    break;
                } else if(numList[f]+numList[p]<numList[i] && p<i){
                    p++;
                } else if(numList[f]+numList[p]>numList[i] && f<p-1){
                    f++;
                    p = f+1;
                } else{
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
