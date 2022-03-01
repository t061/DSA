import java.util.*;
public class BalancedBrackets{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.empty()){
                st.push(s.charAt(i));
            }
            else{
                if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                    st.push(s.charAt(i));
                }
                else if(st.peek()=='{' && s.charAt(i)=='}' || st.peek()=='(' && s.charAt(i)==')' || st.peek()=='[' && s.charAt(i)==']'){
                    st.pop();
                }
                else{
                    System.out.println("Not balanced");
                    return;
                }
            }
        }
        if(st.empty()){
            System.out.println("Balanced");
        }
        else{
            System.out.println("Not Balanced");
        }
    }
}