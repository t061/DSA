import java.util.*;
public class MatrixPath {
    public static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        path(n, m, 0, 0, "");
        System.out.println(count);
    }
    public static void path(int n,int m,int i,int j,String osf){
        if(i>=n || j>=m){
            return;
        }
        if(i==n-1 && j==m-1){
            count++;
            System.out.println(osf);
            return;
        }
        if(i>=0 && i<n && j+1>=0 && j+1<m){
            path(n, m, i, j+1, osf+"D");
        }
        if(i+1>=0 && i+1<n && j>=0 && j<m){
            path(n, m, i+1, j, osf+"R");
        }
    }
}
