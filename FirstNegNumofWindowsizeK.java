import java.util.*;
public class FirstNegNumofWindowsizeK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        int[] ans = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<Integer>();
        for(int i=0;i<k;i++){
            if(arr[i]<0){
                dq.add(arr[i]);
            }
        }
        if(dq.isEmpty()){
            ans[0] = 0;
        }
        else{
            ans[0] = dq.getFirst();
        }
        for(int i=k;i<n;i++){
            if(arr[i-k]<0){
                dq.removeFirst();
            }
            if(arr[i]<0){
                dq.add(arr[i]);
            }
            if(dq.isEmpty()){
                ans[i-k+1] = 0;
            }
            else{
                ans[i-k+1] = dq.getFirst();
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
