package baekjoon.math1;

import java.util.Scanner;

public class ACMHotel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for(int t=0; t<testCase; t++){
            int floor = sc.nextInt();
            int room = sc.nextInt();
            int resident = sc.nextInt();
            int order = 1; 
            String rRoom = "";
            String rFloor = "";
            for(int c=1; c<=room; c++){
                for(int r=1; r<=floor; r++){
                    if(order == resident){
                        rRoom = String.valueOf(c);
                        rFloor = String.valueOf(r);
                    }
                    order++;
                }
            }
            if(rRoom.length() == 1){
                rRoom = "0"+rRoom;
            }
            System.out.println(rFloor+rRoom);
        }
        
        

    }
}
