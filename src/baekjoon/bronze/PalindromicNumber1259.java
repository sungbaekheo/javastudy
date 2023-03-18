package baekjoon.bronze;

import java.util.Scanner;

public class PalindromicNumber1259{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            String num = sc.next();
            if(num.equals("0")){
                break;
            }
            boolean isPalindromic = true;
            for(int i=0; i<num.length()/2; i++){
                if(num.charAt(i) != num.charAt(num.length()-1-i)){
                    isPalindromic = false;
                    break;
                }
            }

            if(isPalindromic){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}