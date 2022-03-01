import java.util.*;
public class Jump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fun(n,0,"");
    }
    public static void fun(int n,int i,String osf){
        if(i>n){
            return;
        }
        if(i==n){
            System.out.println(osf);
            return;
        }
        for(int j=1;j<=n;j++){
            fun(n,i+j,osf+j);
        }
    }
}
