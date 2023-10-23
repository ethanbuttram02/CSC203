package src;

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

    // TODO: TEST THIS!!!!!!!!!!!!!!
    public static Country countryWithHighestCH4InYear(List<Country> countries, int year) {
        double max = 0;
        Country highestEmitter = null;

        for (Country country: countries) {
            Map<Integer, Emission> localData = country.getEmissions();
            double ch4InYear = localData.get(year).getCH4();

            if (ch4InYear > max) {
                max = ch4InYear;
                highestEmitter = country;
            }
        }

        return highestEmitter;
    }

    // TODO: TEST THIS!!!!!!!!!!!!!!
    public static Country countryWithHighestChangeInEmissions(List<Country> countries, int startYear, int endYear) {
        double delta = 0;
        Country highestChange = null;

        for (Country country: countries) {
            Map<Integer, Emission> localData = country.getEmissions();
            double currentDifference = Math.abs(localData.get(startYear).getTotalEmissions() - localData.get(endYear).getTotalEmissions());

            if (currentDifference > delta) {
                delta = currentDifference;
                highestChange = country;
            }
        }

        System.out.println("Country: " + highestChange.getName());
        System.out.println("Change: " + delta);
        return highestChange;
    }
}
