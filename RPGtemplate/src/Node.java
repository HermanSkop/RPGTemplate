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
        if (next != null) {
            System.out.print(this.getItem().getName() + ", ");
            next.showInventory();
        } else System.out.println(this.getItem().getName() + ".");
    }

    public Node getByName(String name) {
        Node temp;
        if (!name.equals(item.getName())) {
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
        current.id--;
        if (current.next != null) {
            reduceIdByOne(current.next);
        }
    }

    public void remove(Node temp) {
        if (temp.next != null && temp.id != 1) {
            getById(temp.id - 1).setNext(temp.next);
            reduceIdByOne(temp.next);
        } else if (temp.id != 1) getById(temp.id - 1).setNext(null);
        else {
            if (temp.next != null) temp.item = temp.next.item;
            else temp.item = null;
            temp.next = null;
        }
    }

    public boolean removeByName(String Name) {
        Node temp = getByName(Name);
        if (temp != null) {
            remove(temp);
            return true;
        } else return false;
    }

}
