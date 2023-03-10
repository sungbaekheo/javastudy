package baekjoon.silver;

import java.util.Scanner;

public class Sequence2491 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int[] seq = new int[len];
        for(int i=0; i<len; i++){
            seq[i] = sc.nextInt();
        }

        int des = 1;
        int in = 1;
        int mDes = 1;
        int mIn = 1;
        for(int i=1; i<len; i++){
            if(seq[i]>=seq[i-1]){
                in++;
            } else {
                in = 1;
            }
            if(seq[i]<=seq[i-1]){
                des++;
            } else {
                des = 1;
            }
            mIn = Math.max(mIn, in);
            mDes = Math.max(mDes, des);
        }
        System.out.println(Math.max(mDes, mIn));
    }
}
