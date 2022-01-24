import java.util.*;
class fibmemo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp,0);
        sc.close();
        int ans = fib(n,dp);
        System.out.println(ans);
    }
    public static int fib(int n,int[] dp){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n] = fib(n-1,dp)+fib(n-2,dp);
        return dp[n];
    }
}