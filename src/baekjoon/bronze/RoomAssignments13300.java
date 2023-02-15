package baekjoon.bronze;

import java.util.Scanner;

public class RoomAssignments13300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stNum = sc.nextInt();
        int limit = sc.nextInt();

        int[][] students = new int[6][2];
        int rooms = 0;
        for(int i=0; i<stNum; i++){
            int gender = sc.nextInt();
            int grade = sc.nextInt()-1;
            students[grade][gender]++;
        }

        for(int i=0; i<students.length; i++){
            for(int j=0; j<2; j++){
                int n = students[i][j];
                if(n%limit != 0){
                    rooms+=n/limit+1;
                }else{
                    rooms+=n/limit;
                }
            }
        }
        System.out.println(rooms);
    }
}
