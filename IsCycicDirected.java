package DSA;
import java.util.*;
public class IsCycicDirected {
    static int v;
    static List<Integer> adj[];
    IsCycicDirected(int n){
        this.v = n;
        this.adj = new ArrayList[v];
        for(int i=0;i<v;i++){
            adj[i] = new ArrayList<>();
        }
    }
    public static void addEdge(int n1,int n2){
        adj[n1].add(n2);
    }
    public static boolean isCyclic(){
        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];
        for(int i=0;i<v;i++){
            if(isCyclicUtil(visited,i,recStack)){
                return true;
            }
        }
        return false;
    }
    public static boolean isCyclicUtil(boolean[] visited,int s,boolean[] recStack){
        if(recStack[s]){
            return true;
        }
        if(visited[s]){
            return false;
        }
        recStack[s] = true;
        visited[s] = true;
        for(int i=0;i<adj[s].size();i++){
            int u = adj[s].get(i);
            if(isCyclicUtil(visited, u, recStack)){
                return true;
            }
        }
        recStack[s] = false;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        IsCycicDirected g = new IsCycicDirected(n);
        int e = sc.nextInt();
        for(int i=0;i<e;i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            addEdge(n1, n2);
        }
        System.out.println(isCyclic());
    }
}
