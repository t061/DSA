package DSA;
import java.util.*;
public class DFS {
    static int v;
    static List<Integer> adj[];
    DFS(int n){
        this.v = n;
        this.adj = new ArrayList[v];
        for(int i=0;i<v;i++){
            adj[i] = new ArrayList<>();
        }
    }
    public static void addEdge(int n1,int n2){
        adj[n1].add(n2);
    }
    public static void DFSfunc(){
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                DFSutilFunc(visited,i);
            }
        }
    }
    public static void DFSutilFunc(boolean[] visited,int s){
        visited[s] = true;
        System.out.print(s+" ");
        for(int i=0;i<adj[s].size();i++){
            int u = adj[s].get(i);
            if(!visited[u]){
                DFSutilFunc(visited, u);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DFS g = new DFS(n);
        int e = sc.nextInt();
        for(int i=0;i<e;i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            addEdge(n1,n2);
        }
        DFSfunc();
    }
}
