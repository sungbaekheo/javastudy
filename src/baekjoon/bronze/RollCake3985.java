package baekjoon.bronze;

import java.util.Scanner;

public class RollCake3985 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int lenCake = sc.nextInt();
        int audience = sc.nextInt();

        int[] cake = new int[lenCake];
        for(int i=0; i<lenCake; i++){
            cake[i] = 1;
        }

        int pre = 0;
        int post = 0;
        int lenMax = 0;
        int dishMax = 0;
        for(int t=1; t<=audience; t++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int len = end - start;
            if(len>lenMax){
                lenMax = len;
                pre = t;
            }
            int dish = 0;
            for(int i=start-1; i<=end-1; i++){
                if(cake[i] == 1){
                    dish++;
                    cake[i]--;
                } else{
                    continue;
                }
            }
            if(dish>dishMax){
                dishMax = dish;
                post = t;
            }
        }
        System.out.println(pre+"\n"+post);
    }
}
