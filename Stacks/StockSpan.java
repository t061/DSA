import java.util.*;
public class StockSpan{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int[] ans = new int[n];
        ans = prevSmaller(arr,n);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] prevSmaller(int[] arr,int n){
        Stack<Integer> st = new Stack<>();
        int[] p = new int[n];
        for(int i=0;i<n;i++){
            if(st.empty()){
                st.push(i);
                p[i] = 1;
            }
            else{
                if(arr[st.peek()]<=arr[i]){
                    while(!st.empty() && arr[st.peek()]<=arr[i]){
                        st.pop();
                    }
                    if(st.empty()){
                        st.push(i);
                        p[i] = i+1;
                    }
                    else{
                        p[i] = i-st.peek();
                        st.push(i);
                    }
                }
                else{
                    p[i] = i-st.peek();
                    st.push(i);
                }
            }
        }
        return p;
    }
}