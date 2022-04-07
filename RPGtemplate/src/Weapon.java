public class Weapon extends Stuff {
    int baseAttack;
    int bonus;

    Weapon(String n, double w, int attack) {
        super(n, w);
        baseAttack = attack;
    }

    @Override
    public int getBaseAttack(Avatar hero) {
        return baseAttack;
    }

    @Override
    public int getFullAttack() {
        return baseAttack + bonus;
    }
}
