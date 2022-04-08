import java.util.Objects;

public class Node {
    Node next;
    Stuff item;
    int id;

    Node(Stuff Item) {
        item = Item;
        id = 1;
        next = null;
    }

    Node(Node prev, Stuff Item) {
        item = Item;
        id = prev.id + 1;
        next = null;
    }

    Node(Node prev) {
        item = prev.item;
        id = prev.id;
        next = prev.next;
    }

    public Stuff getItem() {
        return item;
    }

    public Node getNext() {
        return next;
    }

    public Node getLast() {
        Node temp = null;
        if (next != null) {
            temp = next.getLast();
        } else temp = this;
        return temp;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void showInventory() {
        try {
            if (next != null) {
                System.out.print(this.getItem().getName() + "(" + id + "), ");
                next.showInventory();
            } else System.out.println(this.getItem().getName() + "(" + id + ").");
        }
        catch (Exception e){
            System.out.println("Backpack is empty!");
        }
    }

    public Node getByName(String name) {
        Node temp;

        if (!Objects.equals(name,item.getName())) {
            if (next != null) {
                temp = next.getByName(name);
            } else {
                return null;
            }
        } else {
            temp = this;
        }

        return temp;
    }

    public Node getById(int Id) {
        Node temp = null;
        if (Id != id && next != null) {
            temp = next.getById(Id);
        } else temp = this;
        return temp;
    }

    public void reduceIdByOne(Node current) {
        try {
            current.id--;
            if (current.next != null) {
                reduceIdByOne(current.next);
            }
        }
        catch (Exception e){
            System.out.println("backpack is empty(");
        }
    }

    public void remove(Node elemToRemove) {
        if (elemToRemove.next != null && elemToRemove.id != 1) {
            getById(elemToRemove.id - 1).setNext(elemToRemove.next);
            reduceIdByOne(elemToRemove.next);
        }
        else if (elemToRemove.id != 1) getById(elemToRemove.id - 1).setNext(null);
        else if(elemToRemove.next == null){
            //if (temp.next != null) temp.item = temp.next.item;
            elemToRemove.item = null;
        }
        else {
            elemToRemove.item = elemToRemove.next.item;
            elemToRemove.next = elemToRemove.next.next;
            removeById(getLast().id);
            reduceIdByOne(elemToRemove.next);
        }
    }
/*Сдвинуть айдишники влево*/
    public boolean removeByName(String Name) {
        Node temp = getByName(Name);
        if (temp != null) {
            remove(temp);
            return true;
        } else return false;
    }
    public boolean removeById(int Id) {
        Node temp = getById(Id);
        if (temp != null) {
            remove(temp);
            return true;
        } else return false;
    }
}
