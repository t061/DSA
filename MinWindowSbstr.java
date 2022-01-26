import java.util.*;
public class MinWindowSbstr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        sc.close();
        int[] arr = new int[256];
        int count = 0;
        for(int i=0;i<t.length();i++){
            if(arr[t.charAt(i)]==0){
                count++;
            }
            arr[t.charAt(i)]++;
        }
        int l = 0;
        int r = 0;
        int ans = Integer.MAX_VALUE;
        int start = 0;
        while(r<s.length()){
            arr[s.charAt(r)]--;
            if(arr[s.charAt(r)]==0){
                count--;
            }
            if(count==0){
                while(count==0){
                    ans = Math.min(ans,r-l+1);
                    arr[s.charAt(l)]++;
                    start = l;
                    if(arr[s.charAt(l)]>0){
                        count++;
                     }
                    l++;
                }
            }
            r++;
        }
       System.out.println(ans);
       System.out.println(s.substring(start, ans+start));
    }
}
