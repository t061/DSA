import java.util.*;
public class LongestSbstrWAtleastKRepChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        sc.close();
        System.out.println(helper(s,k,0,s.length()));
    }
    public static int helper(String s,int k,int start,int end) {
        if(end-start<k){
            return 0;
        }
        int[] count = new int[256];
        for(int i=start;i<end;i++){
            count[s.charAt(i)]++;
        }
        for(int i=start;i<end;i++){
            if(count[s.charAt(i)]<k){
                int j = i+1;
                while(j<s.length() && count[s.charAt(j)]<k){
                    j++;
                }
                return Math.max(helper(s,k,start,i),helper(s, k, j, end));
            }
        }
        return end-start;
    }
}
