package DataStructure.Linked_List;

public class DS_Josephu_Problem {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,2,5);

    }
}

class CircleSingleLinkedList{
    private Boy first = null;

    public void addBoy(int nums){

        if(nums < 1){
            System.out.println("nums is wrong");
            return;
        }

        Boy rear = first;

        for (int i = 1; i <= nums; i++){
            if(i == 1){
                first = new Boy(i);
                rear = first;
                first.setNext(first);
            } else {
                Boy addBoy = new Boy(i);
                rear.setNext(addBoy);
                addBoy.setNext(first);
                rear = addBoy;
            }
        }

    }

    public void countBoy(int startNo, int countNum, int nums){

        if(first == null || startNo < 1 || startNo > nums){
            System.out.println("params are wrong");
            return;
        }

        Boy helper = first;

        while (true){
            if(helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }

        for(int i = 0; i < startNo-1; i++){
            helper = helper.getNext();
            first = first.getNext();
        }

        while (true){
            if(helper == first){
                break;
            }
            for(int i = 0; i < countNum-1; i++){
                helper = helper.getNext();
                first = first.getNext();
            }
            System.out.println(first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }

        System.out.println(first.getNo());


    }

    public void showBoy(){
        if(first == null){
            System.out.println("linked list is empty");
            return;
        }

        Boy curBoy = first;

        while (true){
            System.out.println(curBoy.getNo());
            if(curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }

    }
}

class Boy{
    private int no;
    private Boy next;

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}


