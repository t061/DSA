import java.util.*;
public class LongestSubarrayWSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int len = 0;
        int ei = 0;
        int sum = 0;
        hm.put(0,-1);
        for(int i=0;i<n;i++){
            sum += arr[i];
            hm.putIfAbsent(sum, i);
            if(hm.containsKey(sum-k) && len<i-hm.get(sum-k)){
                len = i-hm.get(sum-k);
                ei = i;
            }
        }
        System.out.println(len);
        for(int i=len-ei+1;i<=ei;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
