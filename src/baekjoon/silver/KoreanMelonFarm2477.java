package baekjoon.silver;

import java.util.Scanner;

public class KoreanMelonFarm2477 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int melons = sc.nextInt();
    int area = 0;
    int h = 0;
    int w = 0;
    int subArea = 0;
    int[] lens = new int[6];
    int[] counter = new int[5];
    int idx = 0;
    for(int p=0; p<6; p++){
      int d = sc.nextInt();
      int len = sc.nextInt();
      if(d == 1 || d == 2){
        w = Math.max(w, len);
      } else{
        h = Math.max(h, len);
      }
      counter[d]++;
      lens[p] = len;
      if(counter[d] == 2){
        idx = p;
      }
    }
    subArea = lens[idx-2]*lens[idx-1];
    area = h*w-subArea;
    System.out.println(melons*area);
  }
}
