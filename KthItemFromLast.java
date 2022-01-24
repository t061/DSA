import java.util.*;
public class KthItemFromLast {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static void addb(int data){
        Node nn = new Node(data);
        if(head==null){
            head = nn;
        }
        else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = nn;
        }
    }
    public static Node item(Node head,int k){
        if(head==null){
            return head;
        }
        int len = 0;
        Node temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        if(len<k){
            return null;
        }
        temp = head;
        for(int i=0;i<len-k;i++){
            temp = temp.next;
        }
        return temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int el = sc.nextInt();
            addb(el);
        }          
        int k = sc.nextInt();                       
        sc.close();
        Node ans = item(head, k);
        System.out.println(ans.data);
    }
}
