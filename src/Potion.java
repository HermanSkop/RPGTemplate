import java.util.Scanner;

public class Potion extends Stuff{
    private double healAmount;

    Potion(String name, double weight, double hp){
        super(name,weight);
        healAmount = hp;
    }
    public double getHealAmount() {
        return healAmount;
    }
    @Override public int getBaseAttack(Avatar hero) {
        hero.setHealth(hero.getHealth()+healAmount);
        hero.setHand(null);
        System.out.println(healAmount + " HP gained");
        System.out.println("What item do you need from backpack?");
        Scanner read = new Scanner(System.in);
        String name = read.nextLine();
        hero.changeItem(name);

        return 0;
    }
}
