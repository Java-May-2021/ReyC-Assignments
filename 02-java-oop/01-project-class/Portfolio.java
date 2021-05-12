import java.util.ArrayList;
import java.util.Arrays;

public class Portfolio {
    ArrayList<Project> projects;

    public Portfolio() {
        this.projects = new ArrayList<Project>();
    }

    public void addToPortfolio(Project proj) {
        projects.add(proj);
    }

    public String getPortfolio() {
        String[] projStr = new String[projects.size()];
        for (int i = 0; i < projects.size(); i++) {
            String projName = projects.get(i).getName();
            projStr[i] = projName;
        }
        return Arrays.toString(projStr);
    }

    public double getPortfoliCost() {
        double totalCost = 0;
        for (Project proj : projects) {
            totalCost += proj.getInitialCost();
        }
        return totalCost;
    }

    public void showPortfolio() {
        System.out.println("Cost per project:");
        for (Project proj : projects) {
            System.out.println(proj.elevatorPitch());
        }
        System.out.println(String.format("Total Cost: %.2f", this.getPortfoliCost()));
    }
}
