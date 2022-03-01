import java.util.*;
public class CycleSort{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        cs(arr, n);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
    public static void cs(int[] arr,int n) {
        int i = 0;
        while(i<n){
            int pos = arr[i]-1;
            if(arr[i]!=arr[pos]){
                swap(arr,i,pos);
            }
            else{
                i++;
            }
        }
    }
    public static void swap(int[] arr,int x,int y){
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }
}