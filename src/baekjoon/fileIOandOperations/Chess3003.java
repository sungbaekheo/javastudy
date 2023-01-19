package baekjoon.fileIOandOperations;


import java.util.Scanner;

public class Chess3003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] chess = {1,1,2,2,2,8};

        for(int i: chess){
            System.out.printf("%d ", i-sc.nextInt());
        }
    }
}
