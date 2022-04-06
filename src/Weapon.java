public class Weapon extends Stuff{
    int baseAttack;
    int bonus;
    weaponType type;

    Weapon(String n, double w, int attack, weaponType wpType){
        super(n,w);
        baseAttack = attack;
        type = wpType;
    }
    void dealDMG(Monster aim){
        if(aim.type==type.againstType){
            aim.health-=type.addDamage;
            System.out.println("Monster: -" + type.addDamage + " hp from weapon type | LEFT: " + aim.health);
        }
    }
    @Override
    public Weapon getType() {
        return this;
    }

    @Override public int getBaseAttack(Avatar hero) {
        return baseAttack;
    }
    @Override public int getFullAttack() {
        return baseAttack+bonus;
    }
}
