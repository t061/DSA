package DSA;
import java.util.*;
public class ArrayListImp {
    static int v;
    static List<List<Integer>> adj;
    ArrayListImp(int n){
        this.v = n;
        this.adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(i,new ArrayList<>());
        }
    }
    public static void addEdge(int n1,int n2){
        adj.get(n1).add(n2);
        adj.get(n2).add(n1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayListImp g = new ArrayListImp(n);
        int e = sc.nextInt();
        for(int i=0;i<e;i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            addEdge(n1, n2);
        }
        sc.close();
        for(int i=0;i<n;i++){
            System.out.print(i+"->");
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
