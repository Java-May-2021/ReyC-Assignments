package projectPackage;

public class Human {
    protected int strength = 3;
    protected int stealth = 3;
    protected int intelligence = 3;
    protected int health = 100;
    
    public void attack(Human enemy) {
        enemy.health -= strength;
    }

    public void displayHealth() {
        System.out.println("Current Health: " + health);
    }
}