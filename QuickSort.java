import java.util.*;
class QuickSort{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        QS(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void QS(int[] arr,int l,int h){
        if(l<h){
            int pivot = partition(arr,l,h);
            QS(arr,l,pivot);
            QS(arr,pivot+1,h);
        }
    }
    public static int partition(int[]arr,int l,int h){
        int pivot = arr[l];
        int i = l+1;
        for(int j=l+1;j<=h;j++){
            if(arr[j]<pivot){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,l,i-1);
        return i-1;
    }
    public static void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }  
}

