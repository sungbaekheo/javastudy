package baekjoon.math1;

import java.util.Scanner;

public class 부녀회장이될테야 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for(int t=0; t<testCase; t++){
            int fNum = sc.nextInt();
            int rNum = sc.nextInt();
            
            int[] nResidents = new int[rNum+1];
            for(int i=0; i<=rNum; i++){
                nResidents[i] = i;
            }

            for(int i=0; i<fNum; i++){
                int[] sumArray = new int[rNum+1];
                for(int j=1; j<=rNum; j++){
                    sumArray[j] = sumArray[j-1]+nResidents[j];
                }
                nResidents = sumArray;
            }
            System.out.println(nResidents[rNum]);
        }
    }
}
