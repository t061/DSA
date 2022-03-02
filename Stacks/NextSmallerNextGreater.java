import java.util.*;
public class NextSmallerNextGreater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int[] ns = new int[n];
        ns = preSmaller(arr, n);
        int[] ng = new int[n];
        ng = preGreater(arr,n);
        System.out.println(Arrays.toString(ns));
        System.out.println(Arrays.toString(ng));
    }
    public static int[] preSmaller(int[] arr,int n){
        Stack<Integer> st = new Stack<>();
        int[] p = new int[n];
        for(int i=n-1;i>=0;i--){
            if(st.empty()){
                st.push(i);
                p[i] = n;
            }
            else{
                if(arr[st.peek()]>=arr[i]){
                    while(!st.empty() && arr[st.peek()]>=arr[i]){
                        st.pop();
                    }
                    if(st.empty()){
                        p[i] = n;
                        st.push(i);
                    }
                    else{
                        p[i] = st.peek();
                        st.push(i);
                    }
                }
                else{
                    p[i] = st.peek();
                    st.push(i);
                }
            }
        }
        return p;
    }
    public static int[] preGreater(int[] arr,int n){
        Stack<Integer> st = new Stack<>();
        int[] p = new int[n];
        for(int i=n-1;i>=0;i--){
            if(st.empty()){
                st.push(i);
                p[i] = n;
            }
            else{
                if(arr[st.peek()]<=arr[i]){
                    while(!st.empty() && arr[st.peek()]<=arr[i]){
                        st.pop();
                    }
                    if(st.empty()){
                        p[i] = n;
                        st.push(i);
                    }
                    else{
                        p[i] = st.peek();
                        st.push(i);
                    }
                }
                else{
                    p[i] = st.peek();
                    st.push(i);
                }
            }
        }
        return p;
    }
}
