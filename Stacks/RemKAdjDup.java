import java.util.*;
public class RemKAdjDup {
    static class Pair{
        char c;
        int cnt;
        Pair(char c,int cnt){
            this.c = c;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        sc.close();
        if(k==1){
            System.out.println(" ");
            return;
        }
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.empty()){
                st.push(new Pair(s.charAt(i),1));
            }
            else{
                if(st.peek().c==s.charAt(i)){
                    char ch = st.peek().c;
                    int count = st.peek().cnt;
                    st.pop();
                    count = count+1;
                    if(count==k){
                        continue;
                    }
                    else{
                        st.push(new Pair(ch,count));
                    }
                }
                else{
                    st.push(new Pair(s.charAt(i),1));
                }
            }
        }
        String ans = "";
        while (!st.empty()) {
            char ch = st.peek().c;
            int count = st.peek().cnt;
            while(count!=0){
                ans = ch+ans;
                count--;
            }
            st.pop();
        }
        System.out.println(ans);
    }
}
