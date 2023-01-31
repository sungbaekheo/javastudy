package baekjoon.String;

import java.util.Scanner;

public class CroatianAlphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] alphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String str = sc.next();

        for(int i=0; i<alphabet.length; i++){
            str = str.replace(alphabet[i], "i");
        }

        System.out.println(str.toCharArray().length);
    }
}
