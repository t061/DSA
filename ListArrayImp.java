package DSA;
import java.util.*;
public class ListArrayImp {
    static class Node{
        int dest,wt;
        Node(int dest,int wt){
            this.dest = dest;
            this.wt = wt;
        }
    }
    static int v;
    static List<Node> adj[];
    ListArrayImp(int n){
        this.v = n;
        this.adj = new ArrayList[v];
        for(int i=0;i<v;i++){
            adj[i] = new ArrayList<>();
        }
    }
    public static void addEdge(int n1,int n2,int w){
        adj[n1].add(new Node(n2,w));
        adj[n2].add(new Node(n1,w));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListArrayImp g = new ListArrayImp(n);
        int e = sc.nextInt();
        for(int i=0;i<e;i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int w = sc.nextInt();
            addEdge(n1, n2, w);
        }
        for(int i=0;i<n;i++){
            System.out.print(i+"->");
            for(int j=0;j<adj[i].size();j++){
                System.out.print("("+adj[i].get(j).dest+" "+adj[i].get(j).wt+")"+" ");
            }
            System.out.println();
        }
    }
}
