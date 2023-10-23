package part1;

import java.util.List;
import java.util.Map;

public class Country {
    private String name;
    private Map<Integer, Emission> data;

    public Country(String name, Map<Integer, Emission> data) {
    // Constructor
        this.name = name;
        this.data = data;
    }

    public String getName() {
        // getter method
        return name;
    }

    public Map<Integer, Emission> getEmissions() {
        // getter method
        return data;
    }
}
