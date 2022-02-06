package DSA;
import java.util.*;
public class KahnsAlgoTopo{
    static int v;
    static List<Integer> adj[];
    KahnsAlgoTopo(int n){
        this.v = n;
        this.adj = new ArrayList[v];
        for(int i=0;i<v;i++){
            adj[i] = new ArrayList<>();
        }
    }
    public static void addEdgr(int n1,int n2){
        adj[n1].add(n2);
    }
    public static void topo(){
        int[] indegree = new int[v];
        for(int i=0;i<v;i++){
            ArrayList<Integer> temp = (ArrayList<Integer>)adj[i];
            for(int node : temp){
                indegree[node]++;
            }
        }
        Deque<Integer> dq = new LinkedList<Integer>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                dq.add(i);
            }
        }
        int cnt =0 ;
        ArrayList<Integer> al = new ArrayList<Integer>();
        while(!dq.isEmpty()){
            int u = dq.remove();
            al.add(u);
            for(int node : adj[u]){
                if(--indegree[node]==0){
                    dq.add(node);
                }
            }
            cnt++;
        }
        if(cnt!=v){
            System.out.println("Cycle");
        }
        else{
            System.out.println(al);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        KahnsAlgoTopo g = new KahnsAlgoTopo(n);
        int e = sc.nextInt();
        for(int i=0;i<e;i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            addEdgr(n1, n2);
        }
        topo();
    }
}