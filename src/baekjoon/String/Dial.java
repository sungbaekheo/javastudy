package baekjoon.String;

import java.util.Scanner;

public class Dial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String code = sc.next();
        int number = 0;
        for(int i=0; i<code.length(); i++){
            char c = code.charAt(i);
            if(c == 'A' || c == 'B' || c == 'C'){
                number+=3;
            }
            else if(c == 'D' || c == 'E' || c == 'F'){
                number+=4;
            }
            else if(c == 'G' || c == 'H' || c == 'I'){
                number+=5;
            }
            else if(c == 'J' || c == 'K' || c == 'L'){
                number+=6;
            }
            else if(c == 'M' || c == 'N' || c == 'O'){
                number+=7;
            }
            else if(c == 'P' || c == 'Q' || c == 'R' || c == 'S'){
                number+=8;
            }
            else if(c == 'T' || c == 'U' || c == 'V'){
                number+=9;
            }
            else{
                number+=10;
            }
        }
        System.out.println(number);
    }
}
