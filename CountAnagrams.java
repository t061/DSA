import java.util.*;
public class CountAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        sc.close();
        int count = occurrences(s, p);
        System.out.println(count);
    }
    public static int occurrences(String s,String p) {
        int[] sarr = new int[256];
        int[] parr = new int[256];
        if(p.length()>s.length()){
            return 0;
        }
        for(int i=0;i<p.length();i++){
            sarr[s.charAt(i)]++;
            parr[p.charAt(i)]++;
        }
        int count = 0;
        if(Arrays.equals(sarr, parr)){
            count++;
        }
        for(int i=p.length();i<s.length();i++){
            sarr[s.charAt(i)]++;
            sarr[s.charAt(i-p.length())]--;
            if(Arrays.equals(sarr, parr)){
                count++;
            }
        }
        return count;
    }
}
