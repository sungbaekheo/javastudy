package algorithm.tree.binarytree;

import java.util.Arrays;
import java.util.Scanner;

public class TreeTour1991 {
    static int[][] tree = new int[26][2];
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        int N = sc.nextInt();

        for(int i=0; i<N; i++){
            char pNode = sc.next().charAt(0);
            char lNode = sc.next().charAt(0);
            char rNode = sc.next().charAt(0);

            if(lNode == '.'){
                tree[pNode-'A'][0] = -1;
            } else {
                tree[pNode-'A'][0] = lNode - 'A';
            }
            
            if(rNode == '.'){
                tree[pNode-'A'][1] = -1;
            } else {
                tree[pNode-'A'][1] = rNode - 'A';
            }
        }

        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        sb.append("\n");

        System.out.println(sb.toString());
    }

    public static void preOrder(int node){
        if(node == -1){
            return;
        }
        sb.append((char) (node + 'A'));
        preOrder(tree[node][0]);
        preOrder(tree[node][1]);
    }
    public static void inOrder(int node){
        if(node == -1){
            return;
        }
        inOrder(tree[node][0]);
        sb.append((char) (node + 'A'));
        inOrder(tree[node][1]);
    }
    public static void postOrder(int node){
        if(node == -1){
            return;
        }
        postOrder(tree[node][0]);
        postOrder(tree[node][1]);
        sb.append((char) (node + 'A'));
    }
}
