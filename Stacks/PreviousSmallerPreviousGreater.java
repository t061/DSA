import java.util.*;
public class PreviousSmallerPreviousGreater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int[] ps = new int[n];
        ps = preSmaller(arr, n);
        int[] pg = new int[n];
        pg = preGreater(arr,n);
        System.out.println(Arrays.toString(ps));
        System.out.println(Arrays.toString(pg));
    }
    public static int[] preSmaller(int[] arr,int n){
        Stack<Integer> st = new Stack<>();
        int[] p = new int[n];
        for(int i=0;i<n;i++){
            if(st.empty()){
                st.push(arr[i]);
                p[i] = -1;
            }
            else{
                if(st.peek()>=arr[i]){
                    while(!st.empty() && st.peek()>=arr[i]){
                        st.pop();
                    }
                    if(st.empty()){
                        p[i] = -1;
                        st.push(arr[i]);
                    }
                    else{
                        p[i] = st.peek();
                        st.push(arr[i]);
                    }
                }
                else{
                    p[i] = st.peek();
                    st.push(arr[i]);
                }
            }
        }
        return p;
    }
    public static int[] preGreater(int[] arr,int n){
        Stack<Integer> st = new Stack<>();
        int[] p = new int[n];
        for(int i=0;i<n;i++){
            if(st.empty()){
                st.push(arr[i]);
                p[i] = -1;
            }
            else{
                if(st.peek()<=arr[i]){
                    while(!st.empty() && st.peek()<=arr[i]){
                        st.pop();
                    }
                    if(st.empty()){
                        p[i] = -1;
                        st.push(arr[i]);
                    }
                    else{
                        p[i] = st.peek();
                        st.push(arr[i]);
                    }
                }
                else{
                    p[i] = st.peek();
                    st.push(arr[i]);
                }
            }
        }
        return p;
    }
}
