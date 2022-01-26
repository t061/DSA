import java.util.*;
public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        Set<Character> set = new HashSet<Character>();
        int l = 0;
        int r = 0;
        int max = 0;
        while(r<s.length()){
            if(set.add(s.charAt(r))){
                max = Math.max(max,r-l+1);
                r++;
            }
            else{
                set.remove(s.charAt(l));
                l++;
            }
        }
        System.out.println(max);
    }
}
