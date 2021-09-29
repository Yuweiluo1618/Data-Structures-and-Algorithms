package DataStructure.Hash_Table;

import java.util.Arrays;

public class Custom_Hash1 {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.addEmp(new Emp(1, "jack", "china"));
        System.out.println(hashTable.empLinkedList[1].head.next);
        hashTable.updateEmp(new Emp(1, "Tom", "US"));
        System.out.println(hashTable.empLinkedList[1].head.next);
        hashTable.deleteEmp(new Emp(1));
        hashTable.addEmp(new Emp(17, "Zoe", "Canada"));
        System.out.println(hashTable.empLinkedList[1].head.next);
    }

}

class HashTable {
    int maxSize = 16;
    public EmpLinkedList[] empLinkedList = new EmpLinkedList[maxSize];

    public HashTable() {
        for (int i = 0; i < maxSize; i++) {
            empLinkedList[i] = new EmpLinkedList();
        }
    }

    public int hashCal(Emp emp) {
        return emp.id % maxSize;
    }

    public void addEmp(Emp addEmp) {
        int hashCode = hashCal(addEmp);
        empLinkedList[hashCode].addEmp(addEmp);
    }

    public void updateEmp(Emp updateEmp) {
        int hashCode = hashCal(updateEmp);
        empLinkedList[hashCode].updateEmp(updateEmp);
    }

    public void deleteEmp(Emp delEmp) {
        int hashCode = hashCal(delEmp);
        empLinkedList[hashCode].deleteEmp(delEmp);
    }

    public void printHash() {
        System.out.println(Arrays.toString(empLinkedList));
    }
}

class EmpLinkedList {
    Emp head = new Emp(-1);

    //add
    public void addEmp(Emp newEmp) {
        Emp temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id > newEmp.id) {
                break;
            }
            if (temp.next.id == newEmp.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("id is existed");
            return;
        } else {
            newEmp.next = temp.next;
            temp.next = newEmp;
        }

    }

    //update
    public void updateEmp(Emp newEmp) {
        if (head.next == null) {
            System.out.println("id is not existed");
            return;
        }
        Emp temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == newEmp.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = newEmp.name;
            temp.address = newEmp.address;
        } else {
            System.out.println("no this id exist!");
        }

    }

    //delete
    public void deleteEmp(Emp delEmp) {
        Emp temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id == delEmp.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("id is not exist!");
        }
    }

    //printEmp
    public void printEmp(Emp printEmp) {
        Emp temp = head;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.id == printEmp.id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println(temp);
        } else {
            System.out.println("id not exist!");
        }
    }

}

class Emp {
    public int id;
    public String name;
    public String address;
    public Emp next;

    public Emp(int id) {
        this.id = id;
    }

    public Emp(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
