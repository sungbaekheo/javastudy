package baekjoon.function;

public class SelfNumber {
    public static void main(String[] args) {
        int[] numList = new int[10001];
        for(int i=1; i<numList.length; i++){
            numList[selfNum(i)]++;
        }
        for(int i=1; i<numList.length; i++){
            if(numList[i] == 0){
                System.out.println(i);
            }
        }
    }

    static int selfNum(int a){
        int sum = 0;
        char[] as = String.valueOf(a).toCharArray();
        for(char c:as){
            sum+=Integer.parseInt(String.valueOf(c));
        }
        if(a+sum > 10000){
            return 0;
        }
        return a+sum;
    }
}
