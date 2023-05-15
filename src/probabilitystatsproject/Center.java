//package probabilitystatsproject;
//
///**
// * Lead Author(s):
// * @author Steven Swee
// * 
// * References:
// * Gaddis, T. (2015). Starting out with Java: From control structures through objects. Addison-Wesley.
// * 
// * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
// * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
// *  
// * Version/date: 2022-12 (4.26.0)
// * 
// * Responsibilities of class:
// * Get/Set the average
// * Get/Set the median
// * Display summary statements for the ways to determine the center of the data
// * 
// */
//
//// Center is-a Statistic
//public class Center extends Statistic
//{
//	private double sampleAverage = 0.0; // A Center has-a sampleAverage
//	private double sampleMedian = 0.0; // A Center has-a sampleMedian	
//	private String fileName = ""; // A Center has-a fileName
//	
//	/** Purpose: Creates a Center object given a file name
//	 * @param file name
//	 * @return none
//	 */
//	Center(String fileName)
//	{		
//		// Set the file name
//		this.fileName = fileName;
//		
//		// Perform any computations to set the sample size, average, and median
//		super.setSampleSize(fileName);
//		setAverage(fileName);
//		setMedian(fileName);
//	}
//	
//	/** Purpose: Gets the file name
//	 * @param none
//	 * @return file name
//	 */
//	public String getFileName()
//	{
//		return fileName;
//	}
//	
//	/** Purpose: Gets the average
//	 * @param none
//	 * @return average
//	 */
//	public double getAverage()
//	{
//		return sampleAverage;
//	}
//	
//	/** Purpose: Gets the median
//	 * @param none
//	 * @return median
//	 */
//	public double getMedian()
//	{
//		return sampleMedian;
//	}
//	
//	/** Purpose: Set the average
//	 * @param File name
//	 * @return none
//	 */
//	public void setAverage(String fileName)
//	{
//		try 
//		{
//			// First, check if sample size is non-zero
//			int sampleSize; // Number of data points
//			
//			// Get sample size
//			sampleSize = super.getSampleSize();
//			
//			// If there is no data, throw MissingDataException
//			if (sampleSize == 0)
//			{
//				throw new MissingDataException();
//			}
//			
//			// If there is data, continue with the code below
//			
//			// Initialize relevant values needed to calculate average
//			double sum = 0; // Sum of all data points
//			double average; // Average = Sum / Number of data points
//			
//			// Read in data from file
//			double[] data = super.readData(fileName);
//			
//			// Get sum of all data points
//			for (int k = 0; k < sampleSize; k++)
//			{
//				sum += data[k];
//			}
//			
//			// Calculate and return average
//			average = sum / sampleSize;
//			sampleAverage = average;
//		}
//		// If there is no data, print error message
//		catch (MissingDataException ex)
//		{
//			System.out.println("There is no data to average.");
//		}
//	}
//	
//	/** Purpose: Set the median
//	 * @param File name
//	 * @return none
//	 */
//	public void setMedian(String fileName)
//	{
//		try
//		{
//			// First, check if sample size is non-zero
//			int sampleSize; // Number of data points
//			
//			// Get sample size
//			sampleSize = super.getSampleSize();
//			
//			// If there is no data, throw MissingDataException
//			if (sampleSize == 0)
//			{
//				throw new MissingDataException();
//			}
//			
//			// If there is data, continue with the code below
//			
//			// Initialize relevant values needed to determine median
//			int location; // Median is located in the middle
//			double median; // Median is the middle point
//			
//			// Read in data from file
//			double[] data = super.readData(fileName);
//			
//			// Sample size is equal to size of data array; NullPointerException is thrown if there is no data
//			sampleSize = data.length;
//			
//			// Code below only executes if there is data
//			// Sort data from least to greatest using BubbleSort
//			data = super.bubbleSort(data);
//			
//			// Check if the number of data points is even or odd, then determine location of median
//			// If number of data points is even, divide the sample size by 2 and cast as int
//			if (sampleSize % 2 == 0)
//			{
//				location = (int) sampleSize / 2; 
//				
//				// Use location to determine median
//				median = (data[location] + data[location + 1]) / 2;
//			} 
//			// If the number of data points is odd, divide the sample size by 2, add 0.5, and cast as int
//			else 
//			{
//				location = (int) (sampleSize / 2 + 0.5);
//				
//				// Use location to determine median
//				median = data[location];
//			}
//			
//			sampleMedian = median;
//		}
//		// If there is no data, print error message
//		catch (MissingDataException ex)
//		{
//			System.out.println("There is no data to take the median for.");
//		}
//	}
//	
//	/** Purpose: Describes the dataset in terms of sample size, average, and median or alerts user of empty dataset or invalid file
//	 * @param none
//	 * @return Description of center of dataset or alert of empty dataset or invalid file
//	 */
//	public String toString()
//	{
//		// If a valid file is used, give complete statistical information
//		try
//		{
//			if (super.readData(fileName) == null)
//			{
//				throw new MissingDataException();
//			}
//			
//			return "You are currently using " + super.getBranch() + ".\nYour dataset contains " + super.getSampleSize() + " data points. " + 
//			"\nThe average of your data is " + String.format("%.2f", getAverage()) + " and the median of your data is " + 
//			String.format("%.2f", getMedian()) + ".\n";
//			
//		}
//		// If an invalid file is used, alert the user that an empty dataset or an invalid file was used
//		catch (MissingDataException e)
//		{
//			return "You are currently using " + super.getBranch() + ".\nYou have entered an empty dataset or an invalid file.\n";
//		}
//		
//	}
//}
