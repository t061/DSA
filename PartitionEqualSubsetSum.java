import java.util.*;
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(equalSum(arr, n));
    }
    public static boolean equalSum(int[] arr,int n) {
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
        }
        if(sum%2!=0){
            return false;
        }
        sum = sum/2;
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0||j==0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        if(dp[n][sum]==sum){
            return true;
        }
        return false;
    }
}
