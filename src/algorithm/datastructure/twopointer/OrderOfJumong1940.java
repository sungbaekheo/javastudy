package algorithm.datastructure.twopointer;

import java.util.Arrays;
import java.util.Scanner;

public class OrderOfJumong1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int con = sc.nextInt();
        int[] materials = new int[n];

        for(int i=0; i<n; i++){
            materials[i] = sc.nextInt();
        }

        Arrays.sort(materials);

        int front = 0;
        int rear = 1;

        
    }
}
