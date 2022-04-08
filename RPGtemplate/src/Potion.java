import java.util.Scanner;

public class Potion extends Stuff {
    private double healAmount;

    Potion(String name, double weight, double hp) {
        super(name, weight);
        healAmount = hp;
    }

    public double getHealAmount() {
        return healAmount;
    }

    @Override
    public int getBaseAttack(Avatar hero) {
        hero.setHealth(hero.getHealth() + healAmount);
        hero.setHand(null);
        System.out.println(healAmount + " HP gained");
        return 0;
    }
}
