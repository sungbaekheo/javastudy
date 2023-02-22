package baekjoon.bronze;

import java.util.Scanner;

public class String9086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for(int t=0; t<testCase; t++){
            String str = sc.next();
            System.out.println(str.charAt(0) + "" + str.charAt(str.length()-1));
        }
    }
}
