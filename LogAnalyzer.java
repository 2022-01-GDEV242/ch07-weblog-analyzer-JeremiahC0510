/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author  Jeremiah Curtis
 * @version 03.04.2022
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    
    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader("demo.log");
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    /**WHAT I ADDED!!!!
     * busiestHour is looking for the largest amount of accesses for a specific hour of the day.
     * I am using a while loop to run through the hourCounts array.
     * I have three variables, largest is the return variable and tracks the hourCounts that the largest amount of accesses happened.
     * Index is the variable that is keeping track of each indexed count based off the if else parameters.
     * Count is the variable that updates each time the while loop runs it makes sure that the if statement is updating so that the 
     * hourCounts[index] has to be larger than it. It's getting rid of every other option.
     */
    public void busiestHour()
    {
        int largest = 0, index = 0, count = -1000;
        
        while(index < hourCounts.length -1){
            if(count < hourCounts[index]){
                largest = index;
                count = hourCounts[index];
                index++;
            }
            else
                index++;
        }
        System.out.println("Busiest Hour: " + largest);
    }
    
    /**WHAT I ADDED!!!!
     * Using similar features from busiestHour() quietest hour is looking for the hour during the day where there was the least
     * amount of accesses to the weblog Analyzer.
     * Using a while loop to get through the array, count variable is updating the if statement, index is keeping track of the
     * access according to the hours and smallest is the return of the hour with the smalles amount of accesses.
     */
    public void quietestHour()
    {
        int smallest = 0, index = 0, count = 1000;
        while(index < hourCounts.length -1){
            if(count > hourCounts[index]){
                smallest = index;
                count = hourCounts[index];
                index++;
            }
            else
                index++;
        }
        System.out.println("Quietest Hour: " + smallest);
    }
    
    /**WHAT I ADDED!!!!
     * twoHourBusiest is looking for the largest amount of accesses per 2 hours of the day. So there is 12 possibilities.
     * Using a while loop to get through the array. Similar to busiest hour index is the variable that is keeping track of each 
     * indexed count based off the if else parameters. 
     * Count is the variable that updates each time the while loop runs it makes sure that the if statement is updating so that 
     * the hourCounts[index] has to be larger than it. It's getting rid of every other option.
     * Largest is the return variable and tracks the hourCounts that the largest amount of accesses happened.
     */
    public void twoHourBusiest()
    {
        int largest = 0, index = 0, count = -1000;   
        while(index < hourCounts.length - 1){
            if (count < hourCounts[index] + hourCounts[index + 1]){
                largest = index;
                count = hourCounts[index] + hourCounts[index + 1];
                index++;
            }
            else {
                index++;
            }
            }
        System.out.println("Two Hour Busiest: " + largest + "-" + (largest+2));
    }          
}
