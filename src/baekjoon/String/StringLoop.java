package baekjoon.String;

import java.util.Scanner;

public class StringLoop{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int r = sc.nextInt();
            String str = sc.next();

            for(int j=0; j<str.length(); j++){
                for(int k=0; k<r; k++){
                    System.out.print(str.charAt(j));
                }
            }
            System.out.println();
        }
    }
}