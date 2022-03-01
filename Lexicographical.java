import java.util.*;
public class Lexicographical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        lex(n,0);
    }
    public static void lex(int n,int i){
        if(i>n){
            return;
        }
        System.out.print(i+" ");
        for(int j=(i==0)?1:0;j<10;j++){
            lex(n,i*10+j);
        }
    }
}
