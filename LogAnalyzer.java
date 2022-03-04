/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
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
    
    /**Here I am trying to get the busiest hour from that data list
     * I am only getting the return value as of now and not the actual hour the return value is from.
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
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
