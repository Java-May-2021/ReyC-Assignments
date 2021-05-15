package projectPackage;

public class HumanTest {
    public static void main(String[] args) {
        Human x = new Human();
        Human y = new Human();

        x.attack(y);
        x.displayHealth();
        y.displayHealth();
    }
}