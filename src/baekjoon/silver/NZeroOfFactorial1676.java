package baekjoon.silver;

import java.util.Scanner;

public class NZeroOfFactorial1676 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    int answer = num/5+num/25+num/125;
    System.out.println(answer);
  }
}
