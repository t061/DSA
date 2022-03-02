import java.util.*;
public class SortStackRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            st.push(arr[i]);
        }
        sort(st);
        System.out.println(st);
    }
    public static void sort(Stack<Integer> st){
        if(!st.empty()){
            int x = st.pop();
            sort(st);
            insertSorted(st,x);
        }
    }
    public static void insertSorted(Stack<Integer> st,int x){
        if(st.empty() || st.peek()<x){
            st.push(x);
            return;
        }
        int temp = st.pop();
        insertSorted(st, x);
        st.push(temp);
    }
}
