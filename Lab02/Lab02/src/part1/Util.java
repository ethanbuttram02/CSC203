package part1;

import java.io.DataOutput;
import java.util.Map;

public class Util {
    public static int getYearWithHighestEmissions(Country Country) {
        // return the year with the highest TOTAL emissions for a country

        Map<Integer, Emission> data = Country.getEmissions();
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

    public static int getYearWithHighestEmissions(Sector Sector) {
        // return the year with the highest emissions

        Map<Integer, Double> data = Sector.getEmissions();
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

