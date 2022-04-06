public class weaponType{
    String againstType;
    double addDamage;


    weaponType(String monsterType, double dmg){
        againstType = monsterType;
        addDamage = dmg;
    }
    weaponType(){this(null, 0);}

}
