public class Monster {
    int health;
    int attackPower;
    int attackChance;
    String type;

    Monster(int hp, int power, int chance, String Type){
        health = hp;
        attackChance = chance;
        attackPower = power;
        type = Type;
    }
    int attack(){
        if(Math.random()*100<=attackChance){
            return attackPower;
        }
        else return 0;
    }
    public boolean isAlive(){
        return health>0;
    }
}
