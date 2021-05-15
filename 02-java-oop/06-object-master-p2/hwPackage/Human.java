package hwPackage;

public class Human {
    protected int strength = 3;
    protected int stealth = 3;
    protected int intelligence = 3;
    protected int health = 100;
    
    public void attack(Human enemy) {
        enemy.health -= this.strength;
    }

    public void displayStats() {
        String str = String.format("Current Stats:\n Strength: %d\n Stealth: %d\n Intelligence: %d\n Health: %d",
            this.strength, this.stealth, this.intelligence, this.health);
        System.out.println(str);
    }
}