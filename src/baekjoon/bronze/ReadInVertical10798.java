package baekjoon.bronze;

import java.util.Scanner;

public class ReadInVertical10798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] arr = new String[5][15];

        for(int i=0; i<5; i++){
            String str = sc.next();
            for(int j=0; j<str.length(); j++){
                arr[i][j] = String.valueOf(str.charAt(j));
            }
        }
        for(int j=0; j<15; j++){
            for(int i=0; i<5; i++){
                if(arr[i][j] == null){
                    continue;
                } else{
                    System.out.print(arr[i][j]);
                }
            }
        }
    }
}
