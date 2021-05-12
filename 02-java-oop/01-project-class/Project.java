public class Project {
    private String name;
    private String description;
    private double initialCost = 0;
    private String defaultName = "Default Name";
    private String defaultDescription = "Default Description";
    
    public String elevatorPitch() {
        return String.format("%s (%.2f): %s", name, initialCost, description);
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getInitialCost() {
        return initialCost;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setInitialCost(double initialCost) {
        this.initialCost = initialCost;
    }

    public Project() {
        name = defaultName;
        description = defaultDescription;
    }
    public Project(String name) {
        this.name = name;
        this.description = defaultDescription;
    }
    public Project(String name, String description, double initialCost) {
        this.name = name;
        this.description = description;
        this.initialCost = initialCost;
    }
}