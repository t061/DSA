import java.util.*;
public class midPoint{
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
    public static Node mid(Node head){
        if(head==null || head.next == null){
            return head;
        }
        Node fast = head;
        Node slow = head;
        while(fast.next!=null){
            slow = slow.next;
            if(fast.next.next==null){
                return slow;
            }
            fast = fast.next.next;
        }
        return slow;
    }
    public static void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int el = sc.nextInt();
            addb(el);
        }
        sc.close();
        Node midNode = mid(head);
        System.out.println(midNode.data);
    }
}