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
        int count = 0;
        for(int i=0; i<len; i++){
            int f = 0;
            int p = len-1;
            while(f < p){
                if(numList[i] == numList[f]+numList[p]){
                    if(f != i && p != i){
                        count++;
                        break;
                    } else if(f == i){
                        f++;
                    } else if(p == i){
                        p--;
                    }
                } else if(numList[f]+numList[p]>numList[i]){
                    p--;
                } else{
                    f++;
                }
            }
        }
        System.out.println(count);
    }
}
