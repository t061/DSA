import java.util.*;
public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        sort(arr,n);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr,int n){
        for(int i=0;i<n;i++){
            int min = findmin(arr,i);
            if(min!=i){
                swap(arr,min,i);
            }
        }
    }
    public static int findmin(int[] arr,int start){
        int min = start;
        for(int i=start+1;i<arr.length;i++){
            if(arr[i]<arr[min]){
                min = i;
            }
        }
        return min;
    }
    public static void swap(int[] arr,int x,int y){
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }
}
