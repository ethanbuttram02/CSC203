package part2;

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

    public int getYearWithHighestEmissions() {
        // return the year with the highest emissions

        Map<Integer, Double> data = this.getEmissions();
        int year = 0;
        double max = 0;

        for (Integer key: data.keySet()) {
            if (data.get(key) > max) {
                max = data.get(key);
                year = key;
            }
        }

        return year;

    }
}
