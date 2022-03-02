import java.util.*;
public class LargestAreaUnderBinaryMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int max = 0;
        int[] area = new int[m];
        for(int i=0;i<m;i++){
            if(mat[0][i]==0){
                area[i] = 0;
            }
            else{
                area[i] = 1;
            }
        }
         max = MAH(area, m);
        if(n>1){
            for(int i=1;i<n;i++){
                for(int j=0;j<m;j++){
                    if(mat[i][j]==0){
                        area[j] = 0;
                    }
                    else{
                        area[j] += 1; 
                    }
                }
                int curr = MAH(area, m);
                if(curr>max){
                    max = curr;
                }
            }
        }
        System.out.println(max);
    }
    public static int MAH(int[] arr,int n){
        int[] ps = new int[n];
        int[] ns = new int[n]; 
        ps = prevSmaller(arr, n);
        ns = nextSmaller(arr, n);
        int[] width = new int[n];
        for(int i=0;i<n;i++){
            width[i] = ns[i]-ps[i]-1;
        }
        int[] area = new int[n];
        int max = -1;
        for(int i=0;i<n;i++){
            area[i] = arr[i]*width[i];
            max = Math.max(max,area[i]);
        }
        return max;
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
