package DSA;
import java.util.*;
public class matrixImp {
    static int v;
    static int[][] mat;
    matrixImp(int n){
        this.v = n;
        this.mat = new int[v][v];
    }
    public static void addEdge(int n1,int n2){
        mat[n1][n2] = 1;
        mat[n2][n1] = 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        matrixImp g = new matrixImp(n);
        for(int i=0;i<e;i++){
            int st = sc.nextInt();
            int des = sc.nextInt();
            addEdge(st, des);
        }
        sc.close();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
