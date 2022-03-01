import java.util.*;
public class BinStrWthoutCons1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fun(n,"",0);
        sc.close();
    }
    public static void fun(int n,String osf,int last){
        if(n==0){
            System.out.println(osf);
            return;
        }
        fun(n-1,osf+"0",0);
        if(last==0){
            fun(n-1,osf+"1",1);
        }
    }
}
