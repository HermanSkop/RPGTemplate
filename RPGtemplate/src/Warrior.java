public class Warrior extends Avatar {
    Warrior(String n, int h) {
        super(n, h);
    }

    Warrior(String n, int h, Stuff thing) {
        super(n, h, thing);
    }

    @Override
    public int attack() {
        return this.getHand().getFullAttack();
    }
}
