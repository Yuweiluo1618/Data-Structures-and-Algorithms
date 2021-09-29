package DataStructure.Hash_Table;

public class Custom_Hash2 {

}

class HashTab {
    private Emp1LinkedList[] emp1LinkedListArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        emp1LinkedListArray = new Emp1LinkedList[size];
        for (int i = 0; i < size; i++) {
            emp1LinkedListArray[i] = new Emp1LinkedList();
        }
    }

    public int getHash(int id) {
        return id % size;
    }

    public void add(Emp1 newEmp1) {
        int hashCode = getHash(newEmp1.id);
        emp1LinkedListArray[hashCode].add(newEmp1);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            emp1LinkedListArray[i].list();
        }
    }

    public void findEmp1ById(int id){
        int hashCode = getHash(id);
        Emp1 findRes = emp1LinkedListArray[hashCode].findEmp1ByID(id);
        if(findRes != null) {
            System.out.printf("name: %s \n", findRes.name);
        }
    }
}

class Emp1 {
    public int id;
    public String name;
    public Emp1 next;

    public Emp1(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Emp1LinkedList {
    private Emp1 head = null;

    public void add(Emp1 newEmp1) {
        if (head == null) {
            head = newEmp1;
            return;
        }

        Emp1 curEmp1 = head;
        while (true) {
            if (curEmp1.next == null) {
                break;
            }
            curEmp1 = curEmp1.next;
        }
        curEmp1.next = newEmp1;
    }

    public void list() {
        if (head == null) {
            System.out.println("This linked list not exist!");
            return;
        }

        Emp1 curEmp1 = head;
        while (true) {
            if (curEmp1 == null) {
                break;
            }
            System.out.printf("=> EMP: ID: %d Name: %s\t", curEmp1.id, curEmp1.name);
            curEmp1 = curEmp1.next;
        }
        System.out.println();
    }

    public Emp1 findEmp1ByID(int id) {
        if (head == null) {
            System.out.println("this linked list not exist");
            return null;
        }

        Emp1 curEmp1 = head;
        while (true) {
            if (curEmp1.id == id) {
                break;
            }
            if (curEmp1.next == null) {
                curEmp1 = null;
                break;
            }
            curEmp1 = curEmp1.next;
        }

        return curEmp1;
    }
}