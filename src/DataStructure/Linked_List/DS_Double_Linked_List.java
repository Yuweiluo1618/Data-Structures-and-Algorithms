package DataStructure.Linked_List;

public class DS_Double_Linked_List {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNodeDou heroNodeDou1 = new HeroNodeDou(1, "songjiang", "jishiyu");
        HeroNodeDou heroNodeDou2 = new HeroNodeDou(2, "lujunyi", "yuqiling");
        HeroNodeDou heroNodeDou3 = new HeroNodeDou(3, "wuyong", "zhiduoxing");
        HeroNodeDou heroNodeDou4 = new HeroNodeDou(4, "linchong", "baozitou");
        HeroNodeDou heroNodeDou5 = new HeroNodeDou(4, "linchong~~~~", "baozitou~~");

        doubleLinkedList.addByOrder(heroNodeDou3);
        doubleLinkedList.addByOrder(heroNodeDou1);
        doubleLinkedList.addByOrder(heroNodeDou2);
        doubleLinkedList.addByOrder(heroNodeDou4);
//        doubleLinkedList.updateNode(heroNodeDou5);

        doubleLinkedList.deleteNode(4);

        doubleLinkedList.showList();
    }
}

class  DoubleLinkedList{
    private HeroNodeDou head = new HeroNodeDou(0,"","");

    public void addNode(HeroNodeDou addNode){
        HeroNodeDou temp = head;

        while (true){

            if(temp.next == null){
                break;
            }

            temp = temp.next;
        }

        temp.next = addNode;
        addNode.pre = temp;
    }

    public void addByOrder(HeroNodeDou addNode){
        HeroNodeDou temp = head;
        boolean flag = false;

        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > addNode.no){
                break;
            }
            if(temp.next.no == addNode.no){
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag){
            System.out.println("Node is exist");
        }else {
            addNode.next = temp.next;
            temp.next = addNode;
            addNode.pre = temp;
            if(addNode.next != null){
                addNode.next.pre = addNode;
            }
        }
    }

    public void updateNode(HeroNodeDou update){
        if(head.next == null){
            System.out.println("linked list is empty");
            return;
        }

        HeroNodeDou temp = head.next;
        boolean flag = false;

        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == update.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            temp.name = update.name;
            temp.nickname = update.nickname;
        }else {
            System.out.println("Node not exist");
        }

    }

    public void deleteNode(int no){
        if(head.next == null){
            System.out.println("linked list is empty");
        }

        HeroNodeDou temp = head.next;
        boolean flag = false;

        while (true){

            if(temp == null){
                break;
            }

            if(temp.no == no){
                flag = true;
                break;
            }

            temp = temp.next;
        }

        if(flag){
            temp.pre.next = temp.next;
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
            temp = null;
        }else {
            System.out.println("Node not exist");
        }

    }

    public void showList(){

        if(head.next == null){
            System.out.println("linked list is empty");
            return;
        }

        HeroNodeDou temp = head.next;

        while (true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }
}



class HeroNodeDou{
    public int no;
    public String name;
    public String nickname;
    public HeroNodeDou next;
    public HeroNodeDou pre;

    public HeroNodeDou(int no, String name, String nickname){
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "DataStructure.Linked_List.HeroNodeDou{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
