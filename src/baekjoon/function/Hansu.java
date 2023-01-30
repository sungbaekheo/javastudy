package baekjoon.function;

import java.util.Scanner;

public class Hansu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int count = 0;
        for(int i=1; i<=num; i++){
            if(i<100){
                count++;
            }else{
                if(hansu(i)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static boolean hansu(int a){
        int[] num = new int[3];
        char[] numChar = String.valueOf(a).toCharArray();
        for(int i=0; i<3; i++){
            num[i] = Integer.parseInt(String.valueOf(numChar[i]));
        }
        if(num[2]-num[1] == num[1]-num[0]){
            return true;    
        }
        return false;
    }
}
