import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class extraspecialtest {

    @Test
    void main() {
    }

    @Test
    void readFile() {
        ArrayList<WeatherData> answerdata = Main.ReadFile("resources/WeatherData.csv");
        assertTrue(answerdata.get(0).compareTo(new WeatherData("Albany  N.Y.",46.6, 38.6)) ==0);
        assertTrue(answerdata.get(98).compareTo(new WeatherData("Wichita  Kan.",55.3, 30.38)) ==0);

    }

    @Test
    void printWeatherData() {
    }

    @Test
    void sortWeatherData() {
        // Arrange
        //// Find an example of comment line
        WeatherData test1 = new WeatherData("seattle", 88, 33); //1
        WeatherData test2 = new WeatherData("nt", 77, 33);//3
        WeatherData test3 = new WeatherData("illinois", 100, 70);//0
        WeatherData test4 = new WeatherData("canada", 77, 70);//2

        ArrayList<WeatherData> testweather = new ArrayList<>();
        testweather.add(test1);
        testweather.add(test2);
        testweather.add(test3);
        testweather.add(test4);
        Main.SortWeatherData(testweather);

        // Act
        // Assert
        assertTrue(test1==testweather.get(1));
        assertTrue(test4==testweather.get(2));
        assertTrue(test2==testweather.get(3));
        assertTrue(test3==testweather.get(0));


    }

    @Test
    void writeFile() {
    }
}