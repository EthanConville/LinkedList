import java.util.*;
public class hashNoUtil {
    //make sure table size is prime
    static Integer tableSize = 10;

    private static LinkedList theLists[];



    //Simple hash function. O(1) time
    public static Integer hash(Integer key){
        return key % tableSize;
    }

    //creates empty array of linked lists. O(N) time for for loop
    public static LinkedList[] chain(){
        theLists = new LinkedList[tableSize];
        for( int i = 0; i < theLists.length; i++ )
            theLists[ i ] = new LinkedList();
        return theLists;
    }
    //insertion takes O(1) time. O(1) access to array + O(1) to add to list
    //Could add the ability to accept arrays as inputs to add more than one value
    //at once.
    public static void InsertChain(Integer key, String data, LinkedList [] list){
        Integer hash = hash(key);
            list[hash].addNode(list[hash], data, key);

    }

    //Complexity O(N) for iteration through list worst case
    public static void print(Integer key, LinkedList [] list){
        Integer hash = hash(key);
        if(list[hash] != null){
            System.out.println("List : " + list[hash].toString());
        }
    }

    //Worst Case complexity O(N) for iteration.
    public static void printAllChain(LinkedList [] list){
        for(int i = 0; i < tableSize; i++){
            if(list[i] != null){
                System.out.println("List : ");
                LinkedList.print(list[i]);
            }
        }
    }





    public static void main(String[] args) {
        LinkedList [] Chaining = chain();
        InsertChain(4371, "4371", Chaining);
        InsertChain(1323, "1323", Chaining);
        InsertChain(6173, "6173", Chaining);
        InsertChain(4199, "4199", Chaining);
        InsertChain(4344, "4344", Chaining);
        InsertChain(9679, "9679", Chaining);
        InsertChain(1989, "1989", Chaining);
        System.out.println("Printing Separate Chaining Array Linked list\n");
        printAllChain(Chaining);
    }
}