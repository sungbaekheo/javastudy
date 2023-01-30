package baekjoon.array;

import java.util.Scanner;

public class Remainings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] numbers = new int[10];

        for(int i=0; i<10; i++){
            numbers[i] = sc.nextInt()%42;
        }
        int[] remainings = new int[42];
        for(int i=0; i<numbers.length; i++){
            remainings[numbers[i]]++;
        }
        int count = 0;
        for(int i=0; i<remainings.length; i++){
            if(remainings[i]>0){
                count++;
            }
        }
        System.out.println(count);
    }
}
