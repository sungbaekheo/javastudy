package baekjoon.silver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StoragePolygon2304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nPolygon = sc.nextInt();
        int[][] pillars = new int[nPolygon][2];
        
        for(int i=0; i<nPolygon; i++){
            pillars[i][0] = sc.nextInt();
            pillars[i][1] = sc.nextInt();
        }

        Arrays.sort(pillars, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int maxIdx = 0;
        int max = 0;
        for(int i=0; i<pillars.length; i++){
            if(pillars[i][1]>max){
                max = pillars[i][1];
                maxIdx = i;
            }
        }
        int area = pillars[maxIdx][1];
        int maxIdxTemp = maxIdx;
        while(true){
            int inMaxIdx = maxIdxTemp;
            int inMax = 0;
            for(int i=0; i<inMaxIdx; i++){
                if(pillars[i][1]>inMax){
                    inMax = pillars[i][1];
                    maxIdxTemp = i;
                }
            }
            area+=(pillars[inMaxIdx][0]-pillars[maxIdxTemp][0])*pillars[maxIdxTemp][1];
            if(inMaxIdx == 0){
                break;
            }
        }
        maxIdxTemp = maxIdx;
        while(true){
            int inMaxIdx = maxIdxTemp;
            int inMax = 0;
            for(int i=inMaxIdx+1; i<pillars.length; i++){
                if(pillars[i][1]>inMax){
                    inMax = pillars[i][1];
                    maxIdxTemp = i;
                }
            }
            area+=(pillars[maxIdxTemp][0]-pillars[inMaxIdx][0])*pillars[maxIdxTemp][1];
            if(inMaxIdx == pillars.length-1){
                break;
            }
        }
        System.out.println(area);
    }

}
