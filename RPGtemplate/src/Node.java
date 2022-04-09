import java.lang.annotation.ElementType;
import java.util.Objects;

public class Node {
    Node next;
    Stuff item;
    int id;
    Node head;

    Node(Stuff Item, Node Head) {
        item = Item;
        id = 1;
        next = null;
        head = Head;
    }
    Node(Stuff MainItem, Stuff Item) {
        item = MainItem;
        id = 0;
        head = this;
        next = new Node(Item, head);
        System.out.println(next.head);
    }
    Node(Node prev, Stuff Item, Node Head) {
        item = Item;
        id = prev.id + 1;
        next = null;
        head = Head;
    }

    public Stuff getItem() {
        return item;
    }
    public Node getNext() {
        return next;
    }
    public Node getLast() {
        if (next != null) {
            return next.getLast();
        } else return this;
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
            System.out.println("Something wrong in showInventory");;
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
        if (Id != id && next != null) {
            return next.getById(Id);
        }
        else if(Id!=id) return null;
        else return this;
    }
    public void reduceIdByOne(Node current) {
        current.id--;
        if (current.next != null) {
            reduceIdByOne(current.next);
        }
    }
    public void remove(Node elemToRemove) {
        if (elemToRemove.next != null && elemToRemove.id != 1) {
            getById(elemToRemove.id - 1).setNext(elemToRemove.next);
            reduceIdByOne(elemToRemove.next);
        }
        else if (elemToRemove.id != 1) {
            getById(elemToRemove.id - 1).setNext(null);
        }
        else if(elemToRemove.next == null){
            elemToRemove.item = null;
        }
        else {
            elemToRemove.id = -1;
            Node temp = getById(2);
            head.setNext(temp);
            reduceIdByOne(elemToRemove.next);
            elemToRemove = null;
        }
    }
    public void removeByName(String Name) {
        Node temp = getByName(Name);
        if (temp != null) {
            remove(temp);
        }
    }
    public void removeById(int Id) {
        Node temp = getById(Id);
        if (temp != null) {
            remove(temp);
        }
    }
    public boolean isFull(int capacity){
        return getLast().id == capacity;
    }
}
