package baekjoon.silver;

import java.util.Scanner;

public class SwitchOnAndOff1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] switches = new int[n];
        for(int i=0; i<n; i++){
            switches[i] = sc.nextInt();
        }
        int stu = sc.nextInt();
        for(int t=0; t<stu; t++){
            int gender = sc.nextInt();
            int sNum = sc.nextInt();
            switch(gender){
                case 1:
                    for(int i=0; i<n; i++){
                        if((i+1)%sNum == 0){
                            switches[i] = ++switches[i]%2;
                        }
                    }
                    break;
                case 2:
                    int li = 0;
                    int ri = 0;
                    while((sNum-1+li>=0 && sNum-1+ri<n) && (switches[sNum-1+li] == switches[sNum-1+ri])){
                        li--;
                        ri++;
                    }
                    li++;
                    ri--;
                    for(int i=sNum-1+li; i<=sNum-1+ri; i++){
                        switches[i] = ++switches[i]%2;
                    }
                    break;
            }
        }
        for(int i=0; i<n; i++){
            if(i>0 && i%20 == 0){
                System.out.println();
            }
            System.out.print(switches[i]+ " ");
        }
    }
}
