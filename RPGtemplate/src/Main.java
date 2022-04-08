import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Weapon axe = new Weapon("Axe", 50.0, 4);
        Potion hpBoost2 = new Potion("Small potion", 2.0, 3);
        Potion hpBoost3 = new Potion("Medium potion", 3.0, 6);
        Potion hpBoost4 = new Potion("Huge potion", 5.0, 20);
        Potion hpBoost = new Potion("Gaint potion", 10.0, 70);
        Avatar hero = new Avatar("Aang", 15, hpBoost, 5);
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
