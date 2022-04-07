public class Monster {
    int health;
    int attackPower;
    int attackChance;

    Monster(int hp, int power, int chance) {
        health = hp;
        attackChance = chance;
        attackPower = power;
    }

    int attack() {
        if (Math.random() * 100 <= attackChance) {
            return attackPower;
        } else return 0;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
