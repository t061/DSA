import java.util.*;
public class SmallestDistWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        int distcount = 0;
        int[] arr = new int[256];
        for(int i=0;i<s.length();i++){
            if(arr[s.charAt(i)]==0){
                distcount++;
            }
            arr[s.charAt(i)]++;
        }
        int[] currcount = new int[256];
        int count = 0;
        int start = 0;
        int si = -1;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            currcount[s.charAt(i)]++;
            if(currcount[s.charAt(i)]==1){
                count++;
            }
            if(count==distcount){
                while(currcount[s.charAt(start)]>1){
                    if(currcount[s.charAt(start)]>1){
                        currcount[s.charAt(start)]--;
                    }
                    start++;
                }
                int len = i-start+1;
                if(ans>len){
                    ans = len;
                    si = start;
                }
            }
        }
        System.out.println(ans);
        System.out.println(s.substring(si, ans+si));
    }
}
