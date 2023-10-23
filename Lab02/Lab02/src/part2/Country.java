package part2;

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

    public int getYearWithHighestEmissions() {
        // return the year with the highest TOTAL emissions for a country

        Map<Integer, Emission> data = this.getEmissions();
        int year = 0;
        double max = 0;

        for (Integer key: data.keySet()) {
            if (data.get(key).getTotalEmissions() > max) {
                max = data.get(key).getTotalEmissions();
                year = key;
            }
        }

        return year;

    }
}
