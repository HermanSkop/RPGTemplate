import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Weapon axe = new Weapon("Axe", 50.0, 50);
        Potion hpBoost2 = new Potion("a", 2.0, 3);
        Potion hpBoost3 = new Potion("b", 2.0, 3);
        Potion hpBoost4 = new Potion("c", 2.0, 3);
        Potion hpBoost = new Potion("Gaint", 2.0, 2);
        Avatar hero = new Avatar("Aang", 15, hpBoost, 4);
        Monster zombie = new Monster(15, 2, 100);

        hero.addItem(hpBoost2);
        hero.addItem(hpBoost3);
        hero.addItem(hpBoost4);
        hero.addItem(axe);
        hero.backpack.showInventory();
        //hero.showInventory();
        hero.setHand(hpBoost);
        Arena Forest = new Arena(hero, zombie);
        Forest.fight();
    }
}
