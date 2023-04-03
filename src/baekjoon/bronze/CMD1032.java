package baekjoon.bronze;

import java.util.Scanner;

public class CMD1032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        char[] firstOne = sc.next().toCharArray();
        for(int i=1; i<N; i++){
            String compareTo = sc.next();

            for(int c=0; c<firstOne.length; c++){
                if(firstOne[c] != compareTo.charAt(c)){
                    firstOne[c] = '?';
                }
            }
        }
        for(char c: firstOne){
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
