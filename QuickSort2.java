import java.util.*;
public class QuickSort2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        sort(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr,int l,int h){
        if(l<h){
            int pivot = partition(arr,l,h);
            sort(arr,l,pivot-1);
            sort(arr,pivot+1,h);
        }
    }
    public static int partition(int[] arr,int l,int h){
        int pivot = arr[h];
        int i = l-1;
        for(int j=l;j<=h-1;j++){
            if(arr[j]>pivot){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i+1,h);
        return i+1;
    }
    public static void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
