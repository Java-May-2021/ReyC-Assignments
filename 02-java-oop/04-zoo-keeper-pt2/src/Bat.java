public class Bat extends Mammal {
    public Bat(int energyLevel) {
        super(energyLevel);
    }
    
    public void fly() {
        System.out.println("The bat is flying and lost energy.");
        this.energyLevel -= 50;
    }

    public void eatHuman() {
        System.out.println("The bat is eating humans and gained energy.");
        this.energyLevel += 25;
    }

    public void attackTown() {
        System.out.println("The bat is attacking the town and lost energy.");
        this.energyLevel -= 100;
    }
}
