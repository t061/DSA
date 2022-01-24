import java.util.*;
public class CountOfSubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        sc.close();
        int[][] dp = new int[n+1][sum+1];
        dp[0][0] = 1;
        int m = (int)Math.pow(10,9)+7;
        int zcount = 0;
        for(int i=1;i<=n;i++){
            if(arr[i-1]==0){
                zcount++;
            }
            dp[i][0] = (int)Math.pow(2,zcount);
        }
        for(int j=1;j<=sum;j++){
            dp[0][j] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = (dp[i-1][j-arr[i-1]]+dp[i-1][j])%m;
                }
                else{
                    dp[i][j] = dp[i-1][j]%m;
                }
            }
        }
        System.out.println(dp[n][sum]%m);
    }
}
