import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        weaponType heavy = new weaponType("Skeleton",1);
        Weapon axe = new Weapon("Axe", 50.0, 5, heavy);
        Avatar hero = new Avatar("Aang", 15, axe, 4);
        Monster skeleton = new Monster(12, 0, 0, "Skeleton");

        Arena Forest = new Arena(hero,skeleton);
        Forest.fight();
    }
}
