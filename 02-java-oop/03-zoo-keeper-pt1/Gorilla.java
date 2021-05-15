public class Gorilla extends Mammal {
    public void throwSomething() {
        energyLevel -= 5;
        System.out.println("The gorilla threw something and lost energy.");
    }
    public void eatBananas() {
        energyLevel += 10;
        System.out.println("The gorilla ate bananas and gained energy.");
    }
    public void climb() {
        energyLevel -= 10;
        System.out.println("The gorilla climbed the tree and lost energy.");
    }
}