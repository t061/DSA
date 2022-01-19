import java.util.*;
public class MergeSort2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        msort(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void msort(int[] arr,int l,int h){
        if(l<h){
            int mid = (l+h)/2;
            msort(arr,l,mid);
            msort(arr,mid+1,h);
            merge(arr,l,mid,h);
        }
    }
    public static void merge(int[] arr,int l,int mid,int h){
        int i = l;
        int j = mid+1;
        int k = 0;
        int[] temp = new int[h-l+1];
        while(i<=mid && j<=h){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=h){
            temp[k++] = arr[j++];
        }
        for(int z=0;z<temp.length;z++){
            arr[l++] = temp[z];
        }
    }
}
