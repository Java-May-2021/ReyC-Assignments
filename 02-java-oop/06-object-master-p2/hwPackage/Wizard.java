package hwPackage;

public class Wizard extends Human {
    public Wizard() {
        this.health = 50;
        this.intelligence = 8;
    }
    
    public void heal(Human ally) {
        ally.health += intelligence;
    }

    public void fireBall(Human enemy) {
        enemy.health -= (intelligence * 3);
    }
}
