package baekjoon.bronze;

import java.math.BigInteger;
import java.util.Scanner;

public class Hashing15829 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        char[] str = sc.next().toCharArray();
        BigInteger a = new BigInteger("0");
        for(int i=0; i<len; i++){
            BigInteger b = new BigInteger(String.valueOf(str[i]-'a'+1));
            b = b.multiply(new BigInteger("31").pow(i));
            a = a.add(b);
        }
        System.out.println(a.mod(new BigInteger("1234567891")));
    }
}