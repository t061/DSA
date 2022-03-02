import java.util.*;
public class RemoveAdjDup{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.empty()){
                st.push(s.charAt(i));
            }
            else{
                if(st.peek()==s.charAt(i)){
                    while(!st.empty() && st.peek()==s.charAt(i)){
                        st.pop();
                    }
                }
                else{
                    st.push(s.charAt(i));
                }
            }
        }
        String ans = "";
        while(!st.empty()){
            ans = st.peek()+ans;
            st.pop();
        }
        System.out.println(ans);
    }
}