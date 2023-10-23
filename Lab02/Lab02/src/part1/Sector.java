package part1;

import java.util.Map;

public class Sector {
    private String name;
    private Map<Integer, Double> emissions;

    public Sector(String name, Map<Integer, Double> emissions) {
        // Constructor
        this.name = name;
        this.emissions = emissions;
    }

    public String getName() {
        // getter method
       return name;
    }

    public Map<Integer, Double> getEmissions() {
        // getter method
        return emissions;
    }
}
