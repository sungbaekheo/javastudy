package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class AC5430 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Deque<String> dq = new ArrayDeque<>();
    
    int testCase = Integer.parseInt(br.readLine());
    for(int t=0; t<testCase; t++){
      StringBuilder sb = new StringBuilder();
      dq.clear();
      String func = br.readLine();
      int len = Integer.parseInt(br.readLine());
      String arr = br.readLine();
      for(String e : arr.substring(1, arr.length()-1).split(",")){
        if(!e.equals("")){
          dq.offer(e);
        }
      }
      boolean isAsc = true;
      boolean isError = false;
      main: for(int i=0; i<func.length(); i++){
        char op = func.charAt(i);
        switch(op){
          case 'R':
            isAsc = isAsc? false:true;
            break;
          case 'D':
            if(dq.isEmpty()){
              isError = true;
              break main;
            }
            if(isAsc){
              dq.poll();
            } else {
              dq.pollLast();
            }
        }
      }
      if(isError){
        sb.append("error");
      } else {
        sb.append("[");
        while(!dq.isEmpty()){
          if(isAsc){
            while(!dq.isEmpty()){
              if(dq.size() == 1){
                sb.append(dq.poll());
              } else{
                sb.append(dq.poll()).append(",");
              }
            }
          } else {
            while(!dq.isEmpty()){
              if(dq.size() == 1){
                sb.append(dq.pollLast());
              } else {
                sb.append(dq.pollLast()).append(",");
              }
            }
          }
        }
        sb.append("]");
      }
      System.out.println(sb.toString());
    }
  }
}