import java.util.*;
public class MinCostMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int[][] dp =new int[n][m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i<n-1 && j<m-1){
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])+mat[i][j];
                }
                else if(i<n-1 && j>=m-1){
                    dp[i][j] = dp[i+1][j]+mat[i][j];
                }
                else if(i>=n-1 && j<m-1){
                    dp[i][j] = dp[i][j+1]+mat[i][j];
                }
                else{
                    dp[i][j] = mat[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
