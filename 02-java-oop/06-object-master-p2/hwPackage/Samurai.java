package hwPackage;

public class Samurai extends Human {
    private static int counter = 0;
    
    public Samurai() {
        this.health = 200;
        Samurai.counter++;
    }

    public void deathBlow(Human enemy) {
        enemy.health = 0;
        this.health /= 2;
    }

    public void meditate() {
        this.health += (this.health / 2);
    }

    public int howMany() {
        System.out.println("Number of Samurais: " + Samurai.counter);
        return Samurai.counter;
    }
}
