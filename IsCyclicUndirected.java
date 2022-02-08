package DSA;
import java.util.*;
class IsCyclicUndirected{
    static int v;
    static List<Integer> adj[];
    IsCyclicUndirected(int n){
        this.v = n;
        this.adj = new ArrayList[v];
        for(int i=0;i<v;i++){
            adj[i] = new ArrayList<>();
        }
    }
    public static void addEdge(int n1,int n2) {
        adj[n1].add(n2);
        adj[n2].add(n1);
    }
    public static boolean isCyclic(){
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(isCyclicUtil(visited,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCyclicUtil(boolean[] visited,int s,int parent){
        visited[s] = true;
        Integer i;
        ArrayList<Integer> temp = (ArrayList<Integer>)adj[s];
        for(int node : temp){
            i = node;
            if(!visited[node]){
                if(isCyclicUtil(visited, node,s)){
                    return true;
                }
            }
            else if(i!=parent){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        IsCyclicUndirected g = new IsCyclicUndirected(n);
        int e = sc.nextInt();
        for(int i=0;i<e;i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            addEdge(n1, n2);
        }
        sc.close();
        System.out.println(isCyclic());
    }
}