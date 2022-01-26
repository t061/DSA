import java.util.*;
public class LongesSubstringWthKUnqChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        sc.close();
        int[] count = new int[256];
        int u = 0;
        for(int i=0;i<s.length();i++){
            if(count[s.charAt(i)]==0){
                count[s.charAt(i)]++;
                u++;
            }
            else{
                count[s.charAt(i)]++;
            }
        }
        if(u<k){
            System.out.println("0");
            return;
        }
        Arrays.fill(count,0);
        int r = 0;
        int l = 0;
        count[s.charAt(0)]++;
        int ans = 1;
        for(int i=1;i<s.length();i++){
            count[s.charAt(i)]++;
            r++;
            if(!isvalid(count,k)){
                count[s.charAt(l)]--;
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        System.out.println(ans);
    }
    public static boolean isvalid(int[] count,int k){
        int u = 0;
        for(int i=0;i<256;i++){
            if(count[i]>0){
                u++;
            }
        }
        return (u<=k);
    }
}
