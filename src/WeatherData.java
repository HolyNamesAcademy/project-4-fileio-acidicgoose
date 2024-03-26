import java.util.ArrayList;

/*
Holds weather data related to a city
 */
public class WeatherData implements Comparable<WeatherData> {
    private String city;
    private double averageTemp;
    private double averageHumidity;

    // constructor
    public WeatherData(String c, double t, double h) {
        city = c;
        averageTemp = t;
        averageHumidity = h;
    }

    // getters
    public String getCity() {
        return city;
    }
    public double getAverageTemp() {
        return averageTemp;
    }
    public double getAverageHumidity() {
        return averageHumidity;
    }

    /*
    Returns a string representation of WeatherData:

    [City], [Average Temperature], [Average Humidity]
     */
    public String toString()
    {
        // remove the line below and implement your function here
       // throw new UnsupportedOperationException();
        String returnfile = city + ", " + averageTemp + ", " + averageHumidity;
        return returnfile;
    }

    /*
    Read the compareTo documentation and implement it here:
    https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html#compareTo-T-
     */
    public int compareTo(WeatherData other)
    {
        // remove the line below and implement your function here
        //throw new UnsupportedOperationException();
        if(averageTemp==other.getAverageTemp()){
            if(averageHumidity==other.getAverageHumidity()){
                return 0; // equal temp and humidity
            }
            else if(averageHumidity>other.getAverageHumidity()){
                return 1; //avg humidity up
            }
        }
        else if(averageTemp> other.getAverageTemp()){
            return 1; //avg temp upo
        }
        return -1; //avg temp down

    }
    /*
    public int compare(WeatherData o1, WeatherData o2) {
        return o1.compareTo(o2);
    }
    public static <WeatherData extends Comparable<? super WeatherData>> void sort​(ArrayList<WeatherData> list){

    }*/


}
