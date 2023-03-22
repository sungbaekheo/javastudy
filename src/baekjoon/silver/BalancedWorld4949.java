package baekjoon.silver;

import java.util.Scanner;
import java.util.Stack;

public class BalancedWorld4949 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Stack<Character> stack;

    while(true){
      stack = new Stack<>();
      String str = sc.nextLine();

      if(str.equals(".")){
        break;
      }

      for(int i=0; i<str.length(); i++){
        char c = str.charAt(i);
        if(c == '(' || c == '['){
          stack.add(c);
        } else if(c == ')'){
          if(stack.isEmpty()){
            stack.add(c);
          } else if(stack.peek() == '('){
            stack.pop();
          } else {
            stack.add(c);
          }
        } else if(c == ']'){
          if(stack.isEmpty()){
            stack.add(c);
          } else if(stack.peek() == '['){
            stack.pop();
          } else {
            stack.add(c);
          }
        }
      }
      
      if(stack.isEmpty()){
        System.out.println("yes");
      } else {
        System.out.println("no");
      }
    }
  }
}
