import java.util.*;
public class SortUsingStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        Stack<Integer> st = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        for(int i=0;i<n;i++){
            st.push(arr[i]);
        }
        while(!st.empty()){
            int a = st.pop();
            if(temp.empty()){
                temp.push(a);
            }
            else{
                if(temp.peek()>a){
                    while(!temp.empty() && temp.peek()>a){
                        int el = temp.pop();
                        st.push(el);
                    }
                    temp.push(a);
                }
                else{
                    temp.push(a);
                }
            }
        }
        System.out.println(temp);
    }
}
