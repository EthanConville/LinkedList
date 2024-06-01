//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LinkedList {
    //head of list
    Node head;

    static class Node {
        int data;
        Node next;

       //node constructor
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public static boolean contains(LinkedList list, int data){
        //iterates through list to check if the value is there
        //if not found returns false. O(n) for traversal
        if (list.head != null) {
            Node current = list.head;
            while (current != null) {
                if (current.data == data) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    //Gets the size of list by traversal. O(N). Could be done in O(1) by having a global variable to track
    // the number of elements in the list that increments when values are added to list and decrements when they are
    //removed.
    public static int size(LinkedList list){
        int num = 0;
        if(list.head != null){
            Node current = list.head;
            while (current != null){
                num++;
                current = current.next;
            }
        }
        return num;
    }

    //Traverses and uses contains which is O(N) so overall complexity is 2*O(N) = O(N). Complexity could be made simpler
    //By rewriting function to not use contains  but would overcomplicate code and make less modular.
    public static LinkedList addNode(LinkedList list, int data){
        if(!contains(list, data)) {
            Node newNode = new Node(data);
            //case if list is empty
            if (list.head == null) {
                list.head = newNode;
            }
            else
            {
                //traverse until at end of list then insert
                Node current = list.head;
                while(current.next != null){
                    current = current.next;
                }
                current.next = newNode;

            }
        }
        return list;
    }

    //If value is in list and not head traverse list with 2 nodes. One starts at the first value (we already know it isn't the value we are removing)
    //and one starts at second value. They both increment until the second one finds the data then it will be
    //removed from the list. 3O(N) = O(N) complexity.
    public static void remove(LinkedList list, int data){
       if(!contains(list, data)){
           return;
       }
        if(list.head !=null){
            Node current = list.head;
           //if the head is the node we are removing reassign it
            if(current.data == data)
            {
                list.head = current.next;
            }
            else {
                Node previous = current;
                current = current.next;
                while (current.data != data) {
                    previous = previous.next;
                    current = current.next;
                }
                    previous.next = current.next;
            }
        }
    }

    public static void print(LinkedList list){
        if(list.head ==null){
            System.out.println("List empty. \n");
            return;
        }
        Node current = list.head;
        while(current !=null)
        {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }









    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        addNode(list, 7);
        addNode(list, 7);
        addNode(list, 8);
        addNode(list, 12);
        addNode(list, 32);
        addNode(list, 4);
        addNode(list, 9);

        print(list);
        System.out.println("Number of elements in list: " + size(list));
        System.out.println("The list contains 7: " + contains(list, 7) + "\n");
        remove(list, 7);
        print(list);
    }
}
