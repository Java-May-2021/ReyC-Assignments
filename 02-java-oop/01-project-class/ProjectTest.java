public class ProjectTest {
    public static void main(String[] args) {
        Project projectOne = new Project();
        projectOne.setName("Project One");
        projectOne.setDescription("Project One Description");
        projectOne.setInitialCost(50);
        System.out.println(projectOne.elevatorPitch());
        System.out.println(projectOne.getName());
        System.out.println(projectOne.getDescription());
        System.out.println(projectOne.getInitialCost());

        Project projectTwo = new Project("Project Two");
        projectTwo.setDescription("Project Two Description");
        projectTwo.setInitialCost(100);
        System.out.println(projectTwo.elevatorPitch());
        System.out.println(projectTwo.getName());
        System.out.println(projectTwo.getDescription());
        System.out.println(projectTwo.getInitialCost());

        Project projectThree = new Project("Project Three", "Project Three Description", 150);
        System.out.println(projectThree.elevatorPitch());
        System.out.println(projectThree.getName());
        System.out.println(projectThree.getDescription());
        System.out.println(projectThree.getInitialCost());

        Portfolio projectPortfolio = new Portfolio();
        projectPortfolio.addToPortfolio(projectOne);
        projectPortfolio.addToPortfolio(projectTwo);
        projectPortfolio.addToPortfolio(projectThree);
        System.out.println(projectPortfolio.getPortfolio());
        projectPortfolio.showPortfolio();
    }
}