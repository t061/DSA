import java.util.*;
public class MergeSort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        msort(arr,n);
        System.out.println(Arrays.toString(arr));
    }
    public static void msort(int[] arr,int n){
        if(n>=2){
            int mid = n/2;
            int[] left = new int[mid];
            for(int i=0;i<mid;i++){
                left[i] = arr[i];
            }
            int[] right = new int[n-mid];
            for(int i=mid;i<n;i++){
                right[i-mid] = arr[i];
            }
            msort(left,mid);
            msort(right,n-mid);
            merge(arr,left,mid,right,n-mid,mid);
        }
    }
    public static void merge(int[]arr,int[] left,int lb,int[] right,int rb,int mid){
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<lb && j<rb){
            if(left[i]<right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
            }
        }
        while(i<lb){
            arr[k++] = left[i++];
        }
        while(j<rb){
            arr[k++] = right[j++];
        }
        System.out.println(Arrays.toString(arr));
    }
}
