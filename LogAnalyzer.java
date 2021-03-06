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
    // WHAT I ADDED!!!! Where to calculate the daily acces counts.
    private int[] dayCounts;
    // WHAT I ADDED!!!! Where to calculate the monthly access counts.
    private int[] monthCounts;
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
        dayCounts = new int[31];
        monthCounts = new int[13];
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
    
    //HOUR
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
    /**WHAT I ADDED!!!!
     * numberofAccesses counts the total number of accesses made.
     * Using a for loop to get through the hourCounts array we add
     * to int accesses each time. 
     */
    public void numberofAccesses()
    {
        int accesses = 0;
        for(int i = 0; i < hourCounts.length; i++){
            accesses = accesses + hourCounts[i];
        }
        System.out.println("Total # of Accesses: " + accesses);
    }
    
    //DAY
    /**WHAT I ADDED!!!! I added getDay() method to LogEntry that works directly with this method so I can then get busiestDay,
     * quietestDay, etc.
     * Analyze the daily access data from the log file.
     */
    public void analyzeDailyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int day = entry.getDay();
            dayCounts[day]++;
        }
    }
    /**WHAT I ADDED!!!!
     * Print the daily counts.
     * These should have been set with a prior
     * call to analyzeDailyData.
     */
    public void printDailyCounts()
    {
        System.out.println("Daily: Count");
        for(int day = 0; day < dayCounts.length; day++) {
            System.out.println(day + ": " + dayCounts[day]);
        }
    }
    /**WHAT I ADDED!!!!
     * busiestDay is looking for the largest amount of accesses for a specific day of the data being recorded.
     */
    public void busiestDay()
    {
        int largest = 0, index = 0, count = -1000;
        while(index < dayCounts.length -1){
            if(count < dayCounts[index]){
                largest = index;
                count = dayCounts[index];
                index++;
            }
            else
                index++;
        }
        System.out.println("Busiest Day: " + largest);
    }
    public void quietestDay()
    {
        int smallest = 0, index = 0, count = 1000;
        while(index < dayCounts.length -1){
            if(count > dayCounts[index]){
                smallest = index;
                count = dayCounts[index];
                index++;
            }
            else
                index++;
        }
        System.out.println("Quietest Day: " + smallest);
    }
    
    //MONTH
    /**WHAT I ADDED!!!! I added getMonth() method to LogEntry that works directly with this method so I can then get busiestDay,
     * quietestDay, etc.
     * Analyze the monthly access data from the log file.
     */
    public void analyzeMonthlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int month = entry.getMonth();
            monthCounts[month]++;
        }
    }
    /**WHAT I ADDED!!!!
     * Print the daily counts.
     * These should have been set with a prior
     * call to analyzeDailyData.
     */
    public void printMonthlyCounts()
    {
        System.out.println("Monthly: Count");
        for(int month = 1; month < monthCounts.length; month++) {
            System.out.println(month + ": " + monthCounts[month]);
        }
    }
    /**WHAT I ADDED!!!!
     * busiestMonth is looking for the largest amount of 
     * accesses for a specific day of the data being recorded.
     */
    public void busiestMonth()
    {
        int largest = 0, index = 0, count = -1000;
        while(index < monthCounts.length -1){
            if(count < monthCounts[index]){
                largest = index;
                count = monthCounts[index];
                index++;
            }
            else
                index++;
        }
        System.out.println("Busiest Month: " + largest);
    }
    /**WHAT I ADDED!!!!
     * quietestMonth is looking for the smallest amount of 
     * accesses for a specific month of the data being recorded.
     */
    public void quietestMonth()
    {
        int smallest = 0, index = 0, count = 1000;
        while(index < monthCounts.length -1){
            if(count > monthCounts[index]){
                smallest = index;
                count = monthCounts[index];
                index++;
            }
            else
                index++;
        }
        System.out.println("Quietest Month: " + smallest);
    }
    /**WHAT I ADDED!!!!
     * totalAccessesPerMonth is taking the accesses of each
     * month and adding them all up.
     */
    public void totalAccessesPerMonth()
    {
        int accesses = 0;
        for(int month = 1; month < monthCounts.length; month++)
        {
            accesses = accesses + monthCounts[month];
        }
        System.out.println("Total # of Accesses: " + accesses);
    }
    /**WHAT I ADDED!!!!
     * averageAccessesPerMonth is taking the average of the
     * accesses of all the months.
     */
    public void averageAccessesPerMonth()
    {
        int total = 12, sum = 0, average = 0;
        for(int month = 1; month < monthCounts.length; month++)
        {
            sum = monthCounts[month] + sum;
            average = sum / total;
        }
        System.out.println("Average Per Month: " + average);
    }
}
