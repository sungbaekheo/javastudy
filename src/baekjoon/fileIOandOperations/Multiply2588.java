package baekjoon.fileIOandOperations;


import java.util.Scanner;

public class Multiply2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ab = a*b;
        for(int i=0; i<3; i++){
            System.out.println(a*(b%10));
            b = b/10;
        }
        System.out.println(ab);

    }
}
