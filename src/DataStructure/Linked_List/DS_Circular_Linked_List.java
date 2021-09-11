package DataStructure.Linked_List;

import java.util.LinkedList;
import java.util.Queue;

//解决约瑟夫问题
public class DS_Circular_Linked_List {

    public static void main(String[] args) {
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);
        Person person5 = new Person(5);
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.add(person1);
        circularLinkedList.add(person2);
        circularLinkedList.add(person3);
        circularLinkedList.add(person4);
        circularLinkedList.add(person5);

        circularLinkedList.josephuStart(1,3);
//        System.out.println(circularLinkedList.getHead().next.next.next);
    }


}

class CircularLinkedList{
    private Person head = new Person(0);
    private Person rear = head;
    private Queue<Person> queue = new LinkedList<Person>();

    public CircularLinkedList() {
        head.next = head;
    }

    public Person getHead() {
        return head;
    }

    public void add(Person addNode){
        if(rear == head){
            head.next = addNode;
            addNode.next = addNode;
            rear = addNode;
        }else {
            addNode.next = rear.next;
            rear.next = addNode;
            rear = rear.next;
        }
    }

    public void josephuStart(int k, int m){
        Person temp = head;
        for(int i = 0; i < k+m-2; i++ ){
            temp = temp.next;
        }

        while (true){
            if (temp.next == temp.next.next){
                System.out.println(temp);
                break;
            }
//            queue.offer(temp.next);
            System.out.println(temp.next);
            temp.next = temp.next.next;
            for(int i=0 ; i<m-1; i++){
                temp = temp.next;
            }
        }
    }
}

class Person{
    public int no;
    public Person next;

    public Person(int no){
        this.no = no;
    }

    @Override
    public String toString() {
        return "Person{" +
                "no=" + no +
                '}';
    }
}
