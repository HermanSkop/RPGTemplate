public class Arena {
    Avatar hero;
    Monster enemy;

    Arena(Avatar avatar, Monster monster){
        hero = avatar;
        enemy = monster;
    }
    void fight(){
        System.out.println("----------- FIGHT! ---------");
        while (hero.isAlive()&&enemy.isAlive()){
            double temp = hero.attack(enemy);
            enemy.health-=temp;
            System.out.println("Monster: -" + temp + " hp from " + hero.getHand().getName() + " | LEFT: " + enemy.health);
            temp = enemy.attack();
            hero.setHealth(hero.getHealth()-temp);
            System.out.println("Hero: -" + temp + " hp | LEFT: " + hero.getHealth());
        }
        System.out.println("----------- *Bell ring* ---------");
        System.out.println((enemy.isAlive()?(hero.isAlive()?"No one":"Monster"):hero.isAlive()?"Avatar":"No one") + " wins!");
    }
}
