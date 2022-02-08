package DSA;
import java.util.*;
public class RankandPath {
    static class Edge{
        int src,dest;
    }
    static class Subset{
        int parent;
        int rank;
    }
    static int v,e;
    static Edge[] edge;
    RankandPath(int n,int ed){
        this.v = n;
        this.e = ed;
        this.edge = new Edge[e];
        for(int i=0;i<e;i++){
            edge[i] = new Edge();
        }
    }
    public static void addEdge(int n1,int n2){
        edge[n1].src = n1;
        edge[n1].dest = n2;
    }
    public static boolean isCyclic(){
        Subset[] subset = new Subset[v];
        for(int i=0;i<v;i++){
            subset[i] = new Subset();
            subset[i].parent = i;
            subset[i].rank = 0;
        }
        for(int i=0;i<e;i++){
            int x = find(subset,edge[i].src);
            int y = find(subset,edge[i].dest);
            if(x==y){
                return true;
            }
            union(subset,x,y);
        }
        return false;
    }
    public static int find(Subset[] subset,int s){
        if(subset[s].parent!=s){
            subset[s].parent = find(subset, subset[s].parent);
        }
        return subset[s].parent;
    }
    public static void union(Subset[] subset,int x,int y){
        int xroot = find(subset,x);
        int yroot = find(subset,y);
        if(subset[xroot].rank<subset[yroot].rank){
            subset[xroot].parent = xroot;
        }
        else if(subset[yroot].rank<subset[xroot].rank){
            subset[yroot].parent = xroot;
        }
        else{
            subset[xroot].parent = yroot;
            subset[yroot].rank++;
        }
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int ed = sc.nextInt();
         RankandPath g = new RankandPath(n, ed);
         for(int i=0;i<e;i++){
             int n1 = sc.nextInt();
             int n2 = sc.nextInt();
             addEdge(n1, n2);
         }
         System.out.println(isCyclic());
    }
}
