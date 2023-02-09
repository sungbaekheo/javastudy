package baekjoon.bronze;

import java.util.Scanner;

public class CupHolder2810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int number = sc.nextInt();
        char[] seats = sc.next().replace("LL", "C").toCharArray();
        boolean containsC = false;
        for(char c: seats){
            if(c == 'C'){
                containsC = true;
                break;
            }
        }
        int answer = seats.length;
        if(containsC){
            answer++;
        }
        System.out.println(answer);
    }
}
