import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*
    Takes commands from the user and executes them. Possible commands are
    'read' - reads a file of weather data into the system
    'write' - writes weather data to a file -- overwrites the file if it exists
    'sort' - sorts weather data by the hottest to coldest average temperature
    'append' - writes weather data to a file -- appends data to the file if it exists
    'quit' - ends the program
     */
    public static void main(String[] args)
    {
        ArrayList<WeatherData> weatherData = null;
        while (true)
        {
            System.out.print("Enter a command: ");
            Scanner sc = new Scanner(System.in);

            String command = sc.next().toLowerCase();
            switch (command)
            {
                case "read":
                {
                    System.out.print("Enter the path to the file: ");
                    String path = sc.next();

                    weatherData = ReadFile(path);
                    PrintWeatherData(weatherData);
                    break;
                }
                case "sort":
                {
                    if (weatherData == null)
                    {
                        System.out.println("Please call 'read' first, before calling 'append'.");
                        break;
                    }

                    SortWeatherData(weatherData);
                    break;
                }
                case "write":
                {
                    if (weatherData == null)
                    {
                        System.out.println("Please call 'read' first, before calling 'write'.");
                        break;
                    }

                    System.out.print("Enter the path to the file: ");
                    String path = sc.next();

                    WriteFile(path, false, weatherData);
                    break;
                }
                case "append":
                {
                    if (weatherData == null)
                    {
                        System.out.println("Please call 'read' first, before calling 'append'.");
                        break;
                    }

                    System.out.print("Enter the path to the file: ");
                    String path = sc.next();

                    WriteFile(path, true, weatherData);
                    break;
                }
                case "quit":
                {
                    return;
                }
                default:
                {
                    System.out.println("Unrecognized command. Possible commands are 'read', 'write', 'append', 'sort', and 'quit'");
                    break;
                }
            }
        }
    }

    /*
    Reads a file from the given path and puts the information into an ArrayList.
    If the file does not exist, the function catches the exception, prints a message
    to the console, and return an empty (not null) array.
     */
    public static ArrayList<WeatherData> ReadFile(String path)
    {
        // remove the line below and implement your function here
        File startfile = new File(path);
        ArrayList<WeatherData> returnweather =  new ArrayList<WeatherData>();
        try {
            Scanner kiri = new Scanner(startfile);
            while(kiri.hasNextLine()){
                String newline = kiri.nextLine();
                String[] splitdata = newline.split(",");
                WeatherData finalweather = new WeatherData(splitdata[0], Double.parseDouble(splitdata[1]), Double.parseDouble(splitdata[2]));
                returnweather.add(finalweather);
            }
            //if (startfile == null)
        }
        catch (Exception j){
            System.out.print("womp womp exception in readfile");
            j.printStackTrace();
        }
        return returnweather;

    }

    /*
    Prints the weather data ArrayList to the console. Each weather data item should
    go on a new line:

    [City1], [Average Temperature], [Average Humidity]
    [City2], [Average Temperature], [Average Humidity]
    ...
     */
    public static void PrintWeatherData(ArrayList<WeatherData> weatherData)
    {
        // remove the line below and implement your function here
        //throw new UnsupportedOperationException();
        //ArrayList finaldata = [];
        for (int i= 0; i < weatherData.size(); i++){
            System.out.println(weatherData.get(i).toString());
        }
    }

    /*
    Sorts the given ArrayList from hottest average temperature to coldest average temperature
     */
    public static void SortWeatherData(ArrayList<WeatherData> weatherData)
    {
        // remove the line below and implement your function here
        //throw new UnsupportedOperationException();
        ArrayList<WeatherData> finalData = weatherData;
        WeatherData placeholder;
        //finalData.sort(compare<WeatherData>);
        for(int eri = 1; eri < weatherData.size(); eri++){
            if(eri==0){
                eri++;
            }
            WeatherData base = weatherData.get(eri-1);
            WeatherData mover = weatherData.get(eri);

            if (mover.compareTo(base) >0){
                for(int erj = 0; erj < eri; erj++){
                    WeatherData hotornot = weatherData.get(erj);
                    if (hotornot.compareTo(mover) <0){
                        finalData.remove(eri);
                        finalData.add(erj,mover);
                        break;
                    }
                }
            }
        }
        weatherData = finalData;

    }

    /*
    Writes the weather data information into the file with the given path.
    If shouldAppend is false, the function replaces the existing contents of the file
    (if it exists) with the new weatherData. If shouldAppend is true, the function
    adds the weather data to the end of the file.
    If the file cannot be created, the function catches the exception, prints a message
    to the console, and does not try to write to the file.
     */
    public static void WriteFile(String path, boolean shouldAppend, ArrayList<WeatherData> weatherData)
    {
        // remove the line below and implement your function here
        //throw new UnsupportedOperationException();
        try {
            PrintWriter wowprint = new PrintWriter(new FileOutputStream(new File(path), shouldAppend));
            for (int i = 0; i < weatherData.size(); i++)
                wowprint.write(weatherData.get(i).toString() + "\n");
            wowprint.close();

        }
        catch (Exception j){
            System.out.print("womp womp exception but in writefile");
            j.printStackTrace();
        }
    }
}
