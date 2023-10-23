package part3;

import java.util.List;
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

    // TODO: TEST THIS!!!!!
    public static Sector sectorWithBiggestChangeInEmissions(List<Sector> sectors, int startYear, int endYear) {
        // Given a list of sectors (List<Sector>), identify the sector which has seen the highest
        // average greenhouse gas emissions between two specified years

        double sum = 0;
        double average = 0;
        Sector highestChange = null;

        for (Sector sector: sectors) {
            for (int i = startYear; i < endYear; i++) {
                sum += sector.getEmissions().get(i);
            }

            if (startYear != endYear) {
                sum = sum / (endYear - startYear);
            }

            if (sum > average) {
                average = sum;
                highestChange = sector;
            }
        }

        System.out.println("Sector: " + highestChange.getName());
        System.out.println("Average Emissions: " + average);
        return highestChange;
    }
}
