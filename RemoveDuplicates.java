import java.util.*;
public class RemoveDuplicates {
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
    public static void printList(Node head) {
        if(head==null){
            System.out.println("Empty List");
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static Node removedup(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        Node temp = head;
        Set<Integer> set = new HashSet<Integer>();
        set.add(head.data);
        while(temp.next!=null){
            if(set.contains(temp.next.data)){
                temp.next = temp.next.next;
            }
            else{
                set.add(temp.next.data);
                temp = temp.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int el = sc.nextInt();
            addb(el);
        }
        sc.close();
        head = removedup(head);
        printList(head);
    }
}
