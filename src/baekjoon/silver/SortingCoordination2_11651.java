package baekjoon.silver;

import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

public class SortingCoordination2_11651{
   public static void main(String args[]){ 
     Scanner sc = new Scanner(System.in);
     CompareTo comp = new CompareTo();
     int n = sc.nextInt();
     int[][] pointList = new int[n][2];
     
     for(int i=0; i<n; i++){
       pointList[i][0] = sc.nextInt();
       pointList[i][1] = sc.nextInt();
     }
     
     Arrays.sort(pointList, comp);
     
     for(int i=0; i<n; i++){
       System.out.println(pointList[i][0]+" "+pointList[i][1]);
     }
   }
   
   static class CompareTo implements Comparator<int[]> {
     public int compare(int[] a1, int[] a2){
       if(a1[1] == a2[1]){
         return a1[0] - a2[0];
       }
       return a1[1] - a2[1];
     }
   }
 }