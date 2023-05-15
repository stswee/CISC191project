//package probabilitystatsproject;
//
///**
// * Lead Author(s):
// * @author Steven Swee
// * 
// * References:
// * 
// * Gaddis, T. (2015). Starting out with Java: From control structures through objects. Addison-Wesley.
// * 
// * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
// * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
// *  
// * Version/date: 2022-12 (4.26.0)
// * 
// * Responsibilities of class:
// * Get/Set the variance
// * Get/Set the standard deviation
// * Get/Set the range
// * Display summary statements for the ways to determine the spread of the data
// * 
// */
//
//// Spread is-a Center
//public class Spread extends Center
//{
//	private double sampleVariance = 0.0; // A Spread has-a sampleVariance
//	private double sampleStandardDeviation = 0.0; // A Spread has-a sampleStandardDeviation
//	private double sampleRange = 0.0; // A Spread has-a sampleRange
//	
//	/** Purpose: Creates a Spread object given a file name
//	 * @param file name
//	 * @return none
//	 */
//	Spread(String fileName)
//	{
//		// Use the Center constructor to read in the file, calculate average and median
//		super(fileName);
//		
//		// Perform any computations to set the variance, standard deviation, and range
//		setVariance(fileName);
//		setStandardDeviation(fileName);
//		setRange(fileName);
//	}
//	
//	/** Purpose: Gets the variance
//	 * @param none
//	 * @return data
//	 */
//	public double getVariance()
//	{
//		return sampleVariance;
//	}
//	
//	/** Purpose: Gets the standard deviation
//	 * @param none
//	 * @return standard deviation
//	 */
//	public double getStandardDeviation()
//	{
//		return sampleStandardDeviation;
//	}
//	
//	/** Purpose: Gets the range
//	 * @param none
//	 * @return range
//	 */
//	public double getRange()
//	{
//		return sampleRange;
//	}
//	
//	/** Purpose: Sets the variance
//	 * @param File name
//	 * @return none
//	 */
//	public void setVariance(String fileName)
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
//			// Initialize relevant values needed to calculate variance
//			double sumOfSquares = 0.0; // sum of squares
//			double average = super.getAverage(); // average
//			
//			// Read in the data from file
//			double[] data = super.readData(fileName);
//			
//			// Calculate the sum of squares
//			for (int k = 0; k < sampleSize; k++)
//			{
//				sumOfSquares += (data[k] - average) * (data[k] - average);
//			}
//			
//			// Divide by the sample size - 1 to get the sample variance
//			sampleVariance = sumOfSquares / (sampleSize - 1);
//			
//		}
//		// If there is no data, print error message
//		catch (MissingDataException ex)
//		{
//			System.out.println("There is no data to take the variance for");
//		}
//	}
//	
//	/** Purpose: Sets the standard deviation
//	 * @param File name
//	 * @return none
//	 */
//	public void setStandardDeviation(String fileName)
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
//			// The standard deviation is the square root of the sample variance
//			sampleStandardDeviation = Math.sqrt(sampleVariance);
//		}
//		// If there is no data, print error message
//		catch (MissingDataException ex)
//		{
//			System.out.println("There is no data to take the standard deviation for");
//		}
//	}
//	
//	/** Purpose: Sets the range
//	 * @param File name
//	 * @return none
//	 */
//	public void setRange(String fileName)
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
//			// Read in data from file
//			double[] data = super.readData(fileName);
//			
//			// Sort data from least to greatest using BubbleSort
//			data = super.bubbleSort(data);
//			
//			// Min is the first entry, Max is the last entry; the difference is the range
//			sampleRange = data[sampleSize - 1] - data[0];
//			
//		}
//		// If there is no data, print error message
//		catch (MissingDataException ex)
//		{
//			System.out.println("There is no data to take the range for");
//		}
//	}
//	
//	/** Purpose: Describes the dataset in terms of sample size, variance, and standard deviation or alerts user of empty dataset or invalid file
//	 * @param none
//	 * @return Description of center of dataset or alert of empty dataset or invalid file
//	 */
//	
//	public String toString()
//	{
//		return "You are currently using " + super.getBranch() + ". Your dataset contains " + super.getSampleSize() + " data points.\n" + 
//				"The sample variance of your data is " + String.format("%.2f", getVariance()) +  
//				".\nThe sample standard deviation of your data is "  + String.format("%.2f",  getStandardDeviation()) + 
//				".\nThe range of your data is " + 
//				String.format("%.2f", getRange()) + ".\n";
//	}
//}
