package baekjoon.String;

import java.util.Scanner;

public class GroupWordChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            boolean isGroup = true;
            String str = sc.next();
            char[] alphabetBox = new char[str.length()];
            alphabetBox[0] = str.charAt(0);
            int copyIdx = 1;
            for(int j=1; j<str.length(); j++){
                if(str.charAt(j) == str.charAt(j-1)){
                    continue;
                } else{
                    alphabetBox[copyIdx++] = str.charAt(j);
                }
            }
            for(int j=0; j<copyIdx-1; j++){
                for(int k=j+1; k<copyIdx; k++){
                    if(alphabetBox[k] == alphabetBox[j]){
                        isGroup = false;
                        break;
                    }
                }
            }
            if(isGroup){
                count++;
            }else if(str.length() == 1){
                count++;
            }
        }
        System.out.println(count);
    }
}
