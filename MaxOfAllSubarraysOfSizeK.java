import java.util.*;
public class MaxOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        Deque<Integer> dq = new LinkedList<Integer>();
        for(int i=0;i<k;i++){
            while( !dq.isEmpty() && arr[i]>dq.getLast()){
                dq.removeLast();
            }
            dq.add(arr[i]);
        }
        int[] ans = new int[n-k+1];
        ans[0] = dq.getFirst();
        for(int i=k;i<n;i++){
            if(dq.getFirst()==arr[i-k]){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && arr[i]>dq.getLast()){
                dq.removeLast();
            }
            dq.add(arr[i]);
            ans[i-k+1] = dq.getFirst();
        }
        System.out.println(Arrays.toString(ans));
    }
}
