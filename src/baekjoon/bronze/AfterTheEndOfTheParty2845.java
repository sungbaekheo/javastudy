package baekjoon.bronze;

import java.util.Scanner;

public class AfterTheEndOfTheParty2845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int N = sc.nextInt();

        int ap = L*N;

        int[] people = new int[5];
        for(int i=0; i<5; i++){
            people[i] = sc.nextInt() - ap;
            System.out.print(people[i]+" ");
        }
    }
}
