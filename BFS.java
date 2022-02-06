package DSA;
import java.util.*;
public class BFS {
    static int v;
    static List<Integer> adj[];
    BFS(int n){
        this.v = n;
        this.adj = new ArrayList[v];
        for(int i=0;i<v;i++){
            adj[i] = new ArrayList<>();
        }
    }
    public static void addEdge(int n1,int n2){
        adj[n1].add(n2);
    }
    public static void BFSFunc(int s){
        boolean[] visited = new boolean[v];
        Deque<Integer> dq = new LinkedList<Integer>();
        visited[s] = true;
        dq.add(s);
        while(!dq.isEmpty()){
            s = dq.remove();
            System.out.print(s+" ");
            for(int i=0;i<adj[s].size();i++){
                int u = adj[s].get(i);
                if(!visited[u]){
                    visited[u] = true;
                    dq.add(u);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BFS g = new BFS(n);
        int e = sc.nextInt();
        for(int i=0;i<e;i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            addEdge(n1, n2);
        }
        BFSFunc(0);
    }
}
