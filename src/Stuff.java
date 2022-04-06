public class Stuff {
    private String name;
    private double weight;

    Stuff(){
        name = null;
        weight = 0;
    }
    Stuff(String n, double w){
        name = n;
        weight = w;
    }

    public Weapon getType() {
        return null;
    }
    @Override public String toString(){
        return (name + " weights " + weight);
    }
    public int getFullAttack() {
        return 0;
    }
    public int getBaseAttack(Avatar hero) {
        return 0;
    }

    public String getName() {
        return name;
    }
}
