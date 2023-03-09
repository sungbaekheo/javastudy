package baekjoon.bronze;

import java.util.Scanner;

public class Tax20492 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int prize = sc.nextInt();

        System.out.println((int)(prize*0.78)+" "+(prize-(int)(prize*0.2*0.22)));
    }
}
