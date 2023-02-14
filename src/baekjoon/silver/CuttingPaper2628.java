package baekjoon.silver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CuttingPaper2628 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int w = sc.nextInt();
        int h = sc.nextInt();
        int t = sc.nextInt();
        int[] width = new int[w+1];
        int[] height = new int[h+1];
    
        for(int i=0; i<t; i++){
            if(sc.nextInt() == 0){
                height[sc.nextInt()]++;
            }else{
                width[sc.nextInt()]++;
            }
        }

        int idx = 0;
        int maxW = 0;
        for(int i=0; i<width.length; i++){
            int len = 0;
            if(width[i] == 0 && i != width.length-1){
                continue;
            }else{
                len = i-idx;
                idx = i;
                if(len>maxW){
                    maxW = len;
                }
            }
        }
        idx = 0;
        int maxH = 0;
        for(int i=0; i<height.length; i++){
            int len = 0;
            if(height[i] == 0 && i != height.length-1){
                continue;
            }else{
                len = i-idx;
                idx = i;
                if(len>maxH){
                    maxH = len;
                }
            }
        }
        System.out.println(maxW*maxH);
    }
}
