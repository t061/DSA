import java.util.*;
public class InsertDelete{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static void addback(int data){
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
     public static void addfront(int data) {
         Node nn = new Node(data);
         if(head==null){
             head = nn;
         }
         else{
             Node temp = head;
             nn.next = temp;
             head = nn;
         }
     }
     public static void delFront() {
         if(head==null){
             System.out.println("List Empty");
             return;
         }
         else{
             head = head.next;
         }
     }
     public static void delLast(){
         if(head==null){
             System.out.println("List Empty");
             return;
         }
         else if(head.next==null){
            head = head.next;
         }
         else{
             Node temp = head;
            while(temp.next.next !=null){
                temp = temp.next;
            }
            temp.next = null;
         }
     }
    public static void printList(){
        if(head==null){
            System.out.println("List Empty");
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int el = sc.nextInt();
            addback(el);
        }
        int m = sc.nextInt();
        for(int i=0;i<m;i++){
            int el = sc.nextInt();
            addfront(el);
        }
        delFront();
        delLast();
        sc.close();
        printList();
    }
}