package hwPackage;

public class HumanTest {
    public static void main(String[] args) {
        Ninja newNinja = new Ninja();
        Wizard newWizard = new Wizard();
        Samurai newSamurai = new Samurai();
        Samurai anotherSamurai = new Samurai();

        Human newHuman = new Human();
        
        newNinja.displayStats();
        newNinja.steal(newHuman);
        newNinja.displayStats();
        newNinja.runAway();
        newNinja.displayStats();
        newHuman.displayStats();

        newWizard.displayStats();
        newWizard.heal(newHuman);
        newHuman.displayStats();
        newWizard.fireBall(newHuman);
        newHuman.displayStats();

        newSamurai.displayStats();
        newSamurai.deathBlow(newHuman);
        newSamurai.displayStats();
        newHuman.displayStats();
        newSamurai.meditate();
        newSamurai.displayStats();
        anotherSamurai.howMany();
    }
}
