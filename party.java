import java.util.*;
public class party {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fun(n));
        System.out.println(fun2(n));
    }
     public static int fun(int n) {  /*dp approach */
        if(n==0){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+(i-1)*dp[i-2];
        }
        return dp[n];
    }
    public static int fun2(int n){ /*recursive approach*/
        if(n<=0){
            return 1;
        }
        return fun2(n-1)+(n-1)*fun2(n-2);
    }
}
