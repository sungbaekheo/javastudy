package baekjoon.silver;

import java.util.Scanner;
import java.util.Stack;

public class StackSequence1874 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();

    int n = sc.nextInt();
    int[] seq = new int[n];
    for(int i=0; i<n; i++){
      seq[i] = sc.nextInt();
    }

    int num = 1;
    boolean isAble = true;
    for(int i=0; i<n; i++){
      if(seq[i] >= num){
        while(seq[i]>=num){
          stack.add(num++);
          sb.append("+\n");
        }
      }
      if(stack.peek() != seq[i]){
        isAble = false;
        break;
      }
      stack.pop();
      sb.append("-\n");
    }
    if(isAble){
      System.out.println(sb.toString());
    } else {
      System.out.println("NO");
    }
  }
}
