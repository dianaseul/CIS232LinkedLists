/*
    Diana Gault-Williams
    CIS 232 / Sfarzo
    Linked Lists / Assignment 4
    3/4/2022
 */

class LinkedList  {

    class Node {
        String data;
        Node next;

        Node(String d, Node n) {
            this.data=d;
            this.next=n;
        }
    }

    Node  head=null; // maintain this as the beginning node

    public void addFirst(String d) {
        System.out.println("+first:"+d);
        if (head==null) { //  the 'trivial case' is an empty list:
            head = new Node(d,null);
        }
        else { // make a new head node & move the existing head node
            Node n = new Node(d,head);
            head = n;
        }
    }

    public String toString() { // Display list as String
        StringBuffer s= new StringBuffer();
        Node n = head;
        do {
            s.append(n.data.toString());
            n= n.next;
        } while (n!=null);
        return s.toString();
    }

    public void addLast(String d){
        // a sentinal node could have been used to remember the end
        // but without one, we must loop through to the end
        System.out.println("+last:"+d);
        if(head==null) { // the 'trivial case' is an empty list
            head=new Node(d,null);
        } else {
            Node n = head; // important not to write head=head.next or it'll get lost
            while (n.next!=null) {
                n=n.next;
            }
            // n.next is definitely null now, so add the new node there:
            n.next=new Node(d,null);
        }
    }

    public void changeValue(String d, String new_d) {
        // change any and all values equal to d to new_d
        Node n=head; // using a local reference because it is important not to alter the head attribute

        while (n.next != null) {

            if (n.next.data.equals(d)) {
               n.next.data = new_d;
            }

            n = n.next;
        }
    }

    public void deleteNode(String d) {
        // delete the first node whose value is equal to d
        // move any previous node's next to this node's next
        // if the found node is the head, then just set the head to it's next
        Node prev=null;
        Node n=head;
        // loop here
        while (n != null) {

            if (n.data.equals(d)) {

                if (prev == null) {
                    head = n.next;
                }
                else {
                    prev.next = n.next;
                }
            }

            prev = n;
            n = n.next;
        }
    }
}
/////////////////////////////////////////////
class Main {
    public static void main(String[] args) {
        LinkedList  ll= new LinkedList();
        ll.addFirst("C");
        ll.addLast("D");
        ll.addFirst("B");
        ll.addLast("E");
        ll.addFirst("A");
        System.out.println(ll.toString()); // ABCDE
        ll.changeValue("E","Z");
        System.out.println(ll.toString()); //ABCDZ
        ll.deleteNode("Z");
        ll.deleteNode("A");
        System.out.println(ll.toString()); // BCD
    }
}
