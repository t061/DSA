import java.util.*;
public class Goldmine {
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
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            dp[i][m-1] = mat[i][m-1];
        }
        for(int j=m-2;j>=0;j--){
            for(int i=0;i<n;i++){
                if(i+1<=n-1 && i-1>=0){
                    dp[i][j] = Math.max(dp[i][j+1],Math.max(dp[i+1][j+1],dp[i-1][j+1]))+mat[i][j];
                }
                else if(i+1<=n-1){
                    dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j+1])+mat[i][j];
                }
                else if(i-1>=0){
                    dp[i][j] = Math.max(dp[i][j+1],dp[i-1][j+1])+mat[i][j];
                }
                else{
                    dp[i][j] = dp[i][j+1]+mat[i][j];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max,dp[i][0]);
        }
        System.out.println(max);
    }
}
