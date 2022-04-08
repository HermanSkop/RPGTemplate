import java.util.Objects;
import java.util.Scanner;

public class Avatar {
    private int capacity;
    private String characterName;
    private double health;
    private Stuff hand;
    //private
    public Node backpack;

    Avatar() {
        characterName = null;
        health = 0;
        hand = null;
        capacity = 1;
        backpack = null;
    }

    Avatar(String n, int h) {
        characterName = n;
        health = h;
        hand = null;
        capacity = 1;
        backpack = null;
    }

    Avatar(String n, int h, Stuff thing) {
        this(n, h);
        hand = thing;
    }

    Avatar(String Name, int Health, Stuff thing, int Capacity) {
        this(Name, Health, thing);
        capacity = Capacity;
    }

    public String getName() {
        return characterName;
    }

    public double getHealth() {
        return health;
    }

    public Stuff getHand() {
        return hand;
    }

    public void setName(String name) {
        characterName = name;
    }

    public void setHealth(double hp) {
        health = hp;
    }

    public void setHand(Stuff thing) {
        hand = thing;
    }

    public void action(){
        System.out.println("What item do you need from backpack?(type backpack)");
        Scanner read = new Scanner(System.in);
        String name = read.nextLine();
        if(Objects.equals(name, "backpack")){
            showInventory();
            action();
        }
        else if(Objects.equals(name, "hand")&&hand==null) System.out.println("Attack with no weapon?! Ok..");
        else if(!Objects.equals(name, "hand")){
            this.changeItem(name);
        };
        System.out.println("Attacking with " + hand.getName() + "..");
    }

    public void changeItem(String itemName) {
        if (addItem(hand)) {
            try {
                hand = backpack.getByName(itemName).getItem();

                backpack.removeByName(itemName);
                backpack.showInventory();
            } catch (NullPointerException exc) {
                System.out.println("Item is not found(");
                action();
            }
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int attack() {
        if (hand != null) {
            return hand.getBaseAttack(this);
        } else return 1;
    }

    public double hurt(double hp) {
        return health -= hp;
    }

    public boolean addItem(Stuff item) {
        if (item != null) {
            if (backpack == null) {
                backpack = new Node(item);
                return true;
            } else if (backpack.getLast().id < capacity) {
                Node next = new Node(backpack.getLast(), item);
                backpack.getLast().setNext(next);
                return true;
            } else {
                System.out.println("Backpack is FULL!");
                return false;
            }
        }
        return true;
    }

    public void showInventory() {
        backpack.showInventory();
    }
}