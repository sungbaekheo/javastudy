package algorithm.datastructure.slidingwindow;

import java.util.Scanner;

public class DNAPassword12891 {
    static int[] checkArr;
    static int[] myArr;
    static int checkSecret;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int P = sc.nextInt();
        int result = 0;

        char[] seq = sc.next().toCharArray();
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;

        for(int i=0; i<4; i++){
            checkArr[i] = sc.nextInt();
            if(checkArr[i] == 0){
                checkSecret++;
            }
        }

        for(int i=0; i<P; i++){
            add(seq[i]);
        }

        if(checkSecret == 4){
            result++;
        }

        for(int i=P; i<S; i++){
            int j = i - P;
            add(seq[i]);
            remove(seq[j]);
            if(checkSecret == 4){
                result++;
            }
        }
        System.out.println(result);
    }

    private static void add(char c){
        switch(c){
        case 'A':
            myArr[0]++;
            if(myArr[0] == checkArr[0]){
                checkSecret++;
            }
            break;
        case 'C':
            myArr[1]++;
            if(myArr[1] == checkArr[1]){
                checkSecret++;
            }
            break;
        case 'G':
            myArr[2]++;
            if(myArr[2] == checkArr[2]){
                checkSecret++;
            }
            break;
        case 'T':
            myArr[3]++;
            if(myArr[3] == checkArr[3]){
                checkSecret++;
            }
            break;
        }
    }
    
    private static void remove(char c){
        switch(c){
        case 'A':
            if(myArr[0] == checkArr[0]){
                checkSecret--;
            }
            myArr[0]--;
            break;
        case 'C':
            if(myArr[1] == checkArr[1]){
                checkSecret--;
            }
            myArr[1]--;
            break;
        case 'G':
            if(myArr[2] == checkArr[2]){
                checkSecret--;
            }
            myArr[2]--;
            break;
        case 'T':
            if(myArr[3] == checkArr[3]){
                checkSecret--;
            }
            myArr[3]--;
            break;
        }
    }
}
