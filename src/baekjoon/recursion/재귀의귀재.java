package baekjoon.recursion;

import java.util.Scanner;

public class 재귀의귀재 {
	static int cnt = 0;
    public static int recursion(String s, int l, int r){
    	cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	for(int i=0; i<n; i++) {
    		System.out.println(isPalindrome(sc.next()) +" " +cnt);
    		cnt = 0;
    	}
    }
}
