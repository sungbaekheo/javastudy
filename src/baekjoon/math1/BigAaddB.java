package baekjoon.math1;

import java.math.BigDecimal;
import java.util.Scanner;

public class BigAaddB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigDecimal a = new BigDecimal(sc.next());
        BigDecimal b = new BigDecimal(sc.next());

        System.out.println(a.add(b));
        
    }
}
