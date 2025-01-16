import java.util.ArrayList;

/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author Niko Madriz
 */

public class WeatherPatterns {


    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */
    public static int longestWarmingTrend(int[] temperatures) {
        // TODO: Write your code here!
        ArrayList<Integer> longestRun = new ArrayList<Integer>();
        int highestNum = 0;
        int longest;
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] > highestNum) {
                highestNum = temperatures[i];
            }
        }
        int i = temperatures.length;
        search(temperatures, highestNum, longestRun, i);
        longest = longestRun.size();
        return longest;
    }

    public static int search(int[] temperatures, int highestNum, ArrayList<Integer> longestRun, int i) {
        if (highestNum < -50) {
            return highestNum;
        }
        if (i == 0) {
            return  highestNum;
        }
        highestNum = temperatures[i];
        i--;
        if (search(temperatures, highestNum, longestRun, i) < highestNum) {
            longestRun.add(highestNum);
        }
        return 0;
    }
}
