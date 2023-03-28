package baekjoon.gold;

import java.util.Arrays;
import java.util.Scanner;

public class MakingPassword1759 {
  static int N;
  static int M;
  static char[] chars; // 주어지는 알파벳 저장할 배열
  static char[] result; // M개 뽑은 알파벳을 저장할 배열
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    M = sc.nextInt();
    N = sc.nextInt();
    chars = new char[N];
    result = new char[M];
    for(int i=0; i<N; i++){
      chars[i] = sc.next().charAt(0);
    }

    Arrays.sort(chars); // 사전 순으로 출력하라고 하기에 정렬한 후
    combination(0, 0, 0, 0); // 조합 고고
  }

  public static void combination(int idx, int sidx, int v, int c){
    if(sidx == M && v>=1 && c>=2){ // 모음이 한 개 이상 자음이 두 개 이상 들어가고 네 개를 다 골랐다면
      String password = "";
      for(char ch: result){
        password+=ch; // 다 더해서
      }
      System.out.println(password); // 출력
      return;
    }
    if(idx == N || (sidx == M && (v<1 || c<2))){ // M 글자 안 채워지거나 모음 자음이 기준 미만이면 바로 리턴
      return;
    }
    boolean isVowel = false; // 모음인지 아닌지 판단할 boolean 값
    char alph = chars[idx]; // 해당 인덱스의 문자
    result[sidx] = alph; // 결과 배열에 넣고
    if(alph == 'a' || alph == 'e' || alph == 'i' || alph == 'o' || alph == 'u'){
      isVowel = true; 
    }
    if(isVowel){ // 모음이면 v 증가
      v++;
    } else{ // 자음이면 c 증가
      c++;
    }
    combination(idx+1, sidx+1, v, c); // 다음 자리 입력으로 넘긴 후
    if(isVowel){ // 모음이었으면 v 다시 빼주고
      v--;
    } else { // 자음이었으면 c 다시 빼주기
      c--;
    }
    combination(idx+1, sidx, v, c); // 안 넣을거얌
  }
}
