import java.util.*;
public class apowerb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(pow(a,b));
    }
    public static int pow(int a,int b){
        if(b==0){
            return 1;
        }
        int temp = pow(a,b/2);
        if(b%2==1){
            return a*temp*temp;
        }
        return temp*temp;
    }
}
