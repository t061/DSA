import java.util.*;
public class LargestAreaUnderHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int[] ps = new int[n];
        ps = prevSmaller(arr, n);
        int[] ns = new int[n];
        ns = nextSmaller(arr, n);
        int[] width = new int[n];
        for(int i=0;i<n;i++){
            width[i] = ns[i]-ps[i]-1;
        }
        int[] area = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            area[i] = width[i]*arr[i];
            max = Math.max(max,area[i]);
        }
        System.out.println(max);
    }
    public static int[] prevSmaller(int[] arr,int n){
        Stack<Integer> st = new Stack<>();
        int[] p = new int[n];
        for(int i=0;i<n;i++){
            if(st.empty()){
                st.push(i);
                p[i] = -1;
            }
            else{
                if(arr[st.peek()]>=arr[i]){
                    while(!st.empty() && arr[st.peek()]>=arr[i]){
                        st.pop();
                    }
                    if(st.empty()){
                        p[i] = -1;
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
    public static int[] nextSmaller(int[] arr,int n){
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
}
