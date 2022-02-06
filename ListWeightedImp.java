package DSA;
import java.util.*;
public class ListWeightedImp {
    static class Node{
        int dest;int w;
        Node(int dest,int w){
            this.dest = dest;
            this.w = w;
        }
    }
    static int v;
    static List<List<Node>> adj;
    ListWeightedImp(int n){
        this.v = n;
        this.adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(i,new ArrayList<>());
        }
    }
    public static void addEdge(int n1,int n2,int w){
        adj.get(n1).add(new Node(n2,w));
        adj.get(n2).add(new Node(n1,w));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListWeightedImp g = new ListWeightedImp(n);
        int e = sc.nextInt();
        for(int i=0;i<e;i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int w = sc.nextInt();
            addEdge(n1,n2,w);
        }
        sc.close();
        for(int i=0;i<n;i++){
            System.out.print(i+"->");
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print("("+adj.get(i).get(j).dest+" "+adj.get(i).get(j).w+")"+" ");
            }
            System.out.println();
        }
    }
}
