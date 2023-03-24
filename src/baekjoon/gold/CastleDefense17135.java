package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CastleDefense17135 {
  static int row;
  static int col;
  static int d;
  static int[][] map;
  static int killed = Integer.MIN_VALUE;
  static int[] arrangement;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    row = Integer.parseInt(st.nextToken());
    col = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    map = new int[row+1][col];
    arrangement = new int[col];
    for(int r=0; r<row; r++){
      st = new StringTokenizer(br.readLine());
      for(int c=0; c<col; c++){
        map[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    arrange(0, 0);
    System.out.println(killed);
  }

  public static void defense(int[] arrangement){
    int tempKilled = 0;
    int[][] tempMap = new int[row+1][col];
    copyMap(tempMap);
    tempMap[row] = arrangement;
    int[] line = new int[col];

    while(!isCleared(tempMap)){
      for(int i=0; i<=row; i++){
        System.out.println(Arrays.toString(tempMap[i]));
      }
      System.out.println("------------------");
      for(int i=0; i<col; i++){
        if(tempMap[row][i] != 2){
          continue;
        }
        shoot: for(int r=row-1; r>0; r--){
          System.out.println("row = " + r);
          if(Math.abs(row-r)>d){
            break;
          }
          System.out.println("row = " + r);
          for(int c=0; c<col; c++){
            if(Math.abs(row-r)+Math.abs(i-c)>d){
              System.out.println(r+" "+c);
              continue;
            }
            if(tempMap[r][c] == 1){
              System.out.println("죽인 좌표: "+r+" "+c);
              tempKilled++;
              tempMap[r][c] = 0;
              break shoot;
            }
          }
        }
        for(int j=0; j<=row; j++){
          System.out.println(Arrays.toString(tempMap[j]));
        }
        System.out.println("------------------");
      }
      for(int i=row-1; i>0; i--){
        System.out.println("it worked");
        if(i == 0){
          changeArray(tempMap[i], line);
        }
        changeArray(tempMap[i], tempMap[i-1]);
      }

      for(int i=0; i<=row; i++){
        System.out.println(Arrays.toString(tempMap[i]));
      }
      System.out.println("------------------");
    }
    System.out.println(tempKilled);
    killed = Math.max(killed, tempKilled);
  }

  public static void arrange(int idx, int cnt){
    if(idx == col){
      if(cnt == 3){
        System.out.println(Arrays.toString(arrangement));
        System.out.println("------------------");
        defense(arrangement);
      }
      return;
    }
    arrangement[idx] = 0;
    arrange(idx+1, cnt);
    if(cnt<3){
      arrangement[idx] = 2;
      arrange(idx+1, cnt+1);
    }
  }

  public static void copyMap(int[][] copied){
    for(int r=0; r<=row; r++){
      for(int c=0; c<col; c++){
        copied[r][c] = map[r][c];
      }
    }
  }

  public static boolean isCleared(int[][] tempMap){
    for(int r=0; r<row; r++){
      for(int c=0; c<col; c++){
        if(tempMap[r][c] == 1){
          return false;
        }
      }
    }
    return true;
  }

  public static void changeArray(int[] arr1, int[] arr2){
    for(int i=0; i<col; i++){
      arr1[i] = arr2[i];
    }
  }
}
