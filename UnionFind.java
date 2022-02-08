package DSA;
import java.util.*;
public class UnionFind {
    static class Edge{
        int src,dest;
    }
    static int v,e;
    static Edge[] edge;
    UnionFind(int n,int ed){
        this.v = n;
        this.e = ed;
        this.edge = new Edge[e];
        for(int i=0;i<e;i++){
            edge[i] = new Edge();
        }
    }
    public static void addEdge(int n1,int n2){
        edge[n1].src = n1;
        edge[n2].dest = n2;
    }
    public static boolean isCyclic(){
        int[] parent = new int[v];
        Arrays.fill(parent,-1);
        for(int i=0;i<e;i++){
            int x = find(parent,edge[i].src);
            int y = find(parent,edge[i].dest);
            if(x==y){
                return true;
            }
            union(parent,x,y);
        }
        return false;
    }
    public static int find(int[] parent,int s){
        if(parent[s]==-1){
            return s;
        }
        return find(parent, parent[s]);
    }
    public static void union(int[] parent,int x,int y){
        parent[x] = y;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ed = sc.nextInt();
        UnionFind g = new UnionFind(n, ed);
        for(int i=0;i<ed;i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            addEdge(n1, n2);
        }
        sc.close();
        System.out.println(isCyclic());
    }
}
