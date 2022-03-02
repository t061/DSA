import java.util.*;
public class LongestValidParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int re = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }
            else{
                if(!st.empty()){
                    st.pop();
                }
                if(!st.empty()){
                    re = Math.max(re,i-st.peek());
                }
                else{
                    st.push(i);
                }
            }
        }
        System.out.println(re);
    }
}
