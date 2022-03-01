import java.util.*;
public class printSubsetofArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sub(arr, n, 0, "");
    }
    public static void sub(int[] arr,int n,int i,String osf) {
        if(i==n){
            System.out.println(osf);
            return;
        }
        sub(arr,n,i+1,osf+arr[i]);
        sub(arr,n,i+1,osf);
    }
}
