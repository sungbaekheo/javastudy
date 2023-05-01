package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Cousin9489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        List<Node> tree = new ArrayList<>();

        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            if(N == 0 && target == 0){
                break;
            }

            st = new StringTokenizer(br.readLine());
            Queue<Integer> q = new LinkedList<>();
            for(int i=0; i<N; i++){
                int now = Integer.parseInt(st.nextToken());
                if(i == 0){
                    tree.add(new Node(0, now, new ArrayList<>()));
                } else {
                    if(now - tree.get(i-1).num == 1){
                        tree.get(i-1).list.add(new Node(tree.get(i-1)))
                    }
                }
            }

        }
    }

    static class Node{
        int level;
        int num;
        List<Node> list;

        public Node(int level, int num, List<Node> list){
            this.level = level;
            this.num = num;
            this.list = list;
        }
    }
}