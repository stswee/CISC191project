package probabilitystatsproject;

import java.util.ArrayList;

/**
 * Lead Author(s):
 * @author Steven Swee
 * 
 * References:
 * 
 * Gaddis, T. (2015). Starting out with Java: From control structures through objects. Addison-Wesley.
 * 
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *  
 * Version/date: 2022-12 (4.26.0)
 * 
 * Responsibilities of class:
 * Get/Set the average
 * Get/Set the median
 * Get/Set the variance
 * Get/Set the standard deviation
 * Get/Set the range
 * Display descriptive statistics of the data if valid dataset was used. If not, display error messages to the user
 * 
 * 
 */

// DescriptiveStatistics is-a Statistic
public class DescriptiveStatistics extends Statistic
{
	private String dataset = ""; // A DescriptiveStatistics has-a dataset
	private double sampleAverage = 0.0; // A DescriptiveStatistics has-a sampleAverage
	private double sampleMedian = 0.0; // A DescriptiveStatistics has-a sampleMedian	
	private double sampleVariance = 0.0; // A DescriptiveStatistics has-a sampleVariance
	private double sampleStandardDeviation = 0.0; // A DescriptiveStatistics has-a sampleStandardDeviation
	private double sampleRange = 0.0; // A DescriptiveStatistics has-a sampleRange
	
	/** Purpose: Creates a DescriptiveStatistics object
	 * @param dataset in form of csv
	 * @return none
	 */
	DescriptiveStatistics(String dataset)
	{
		// Set the dataset name
		this.dataset = dataset;
		
		// Perform any computations to set the sample size, average, median, variance, standard deviation, and range
		super.setSampleSize(dataset);
		setAverage(dataset);
		setMedian(dataset);
		setVariance(dataset);
		setStandardDeviation(dataset);
		setRange(dataset);
	}
	
	/** Purpose: Gets the file name
	 * @param none
	 * @return file name
	 */
	public String getFileName()
	{
		return dataset;
	}
	
	/** Purpose: Gets the average
	 * @param none
	 * @return average
	 */
	public double getAverage()
	{
		return sampleAverage;
	}
	
	/** Purpose: Gets the median
	 * @param none
	 * @return median
	 */
	public double getMedian()
	{
		return sampleMedian;
	}
	
	/** Purpose: Gets the variance
	 * @param none
	 * @return data
	 */
	public double getVariance()
	{
		return sampleVariance;
	}
	
	/** Purpose: Gets the standard deviation
	 * @param none
	 * @return standard deviation
	 */
	public double getStandardDeviation()
	{
		return sampleStandardDeviation;
	}
	
	/** Purpose: Gets the range
	 * @param none
	 * @return range
	 */
	public double getRange()
	{
		return sampleRange;
	}
	
	/** Purpose: Set the average
	 * @param dataset
	 * @return none
	 */
	public void setAverage(String dataset)
	{			
		try 
		{
			// First, check if sample size is non-zero
			int sampleSize; // Number of data points
			
			// Get sample size
			sampleSize = super.getSampleSize();
			
			// If there is no data, throw MissingDataException
			if (sampleSize == 0)
			{
				throw new MissingDataException();
			}
			
			// If there is data, continue with the code below
			// Initialize data ArrayList
			ArrayList<Double> data = new ArrayList<Double>();
				
			// Read in data from file
			data = super.readData(dataset);
			
			// Initialize relevant values needed to calculate average
			double sum = 0; // Sum of all data points
			double average; // Average = Sum / Number of data points
			
			// Get sum of all data points
			for (int k = 0; k < sampleSize; k++)
			{
				sum += data.get(k);
			}
			
			// Calculate and return average
			average = sum / sampleSize;
			sampleAverage = average;
		}
		// If there is no data, print error message
		catch (MissingDataException ex)
		{
			System.out.println(ex.NoAverage());
		}
	}
	
	/** Purpose: Set the median
	 * @param dataset
	 * @return none
	 */
	public void setMedian(String dataset)
	{
		try
		{
			// First, check if sample size is non-zero
			int sampleSize; // Number of data points
			
			// Get sample size
			sampleSize = super.getSampleSize();
			
			// If there is no data, throw MissingDataException
			if (sampleSize == 0)
			{
				throw new MissingDataException();
			}
			
			// If there is data, continue with the code below
			// Initialize data ArrayList
			ArrayList<Double> data = new ArrayList<Double>();
				
			// Read in data from file
			data = super.readData(dataset);
			
			// Initialize relevant values needed to determine median
			int location; // Median is located in the middle
			double median; // Median is the middle point
			
			// Sample size is equal to size of data array; NullPointerException is thrown if there is no data
			sampleSize = data.size();
			
			// Code below only executes if there is data
			// Sort data from least to greatest using BubbleSort
			data = super.bubbleSort(data);
			
			// Check if the number of data points is even or odd, then determine location of median
			// If number of data points is even, divide the sample size by 2 and cast as int
			if (sampleSize % 2 == 0)
			{
				location = (int) sampleSize / 2; 
				
				// Use location to determine median
				median = (data.get(location) + data.get(location + 1)) / 2;
			} 
			// If the number of data points is odd, divide the sample size by 2, add 0.5, and cast as int
			else 
			{
				location = (int) (sampleSize / 2 + 0.5);
				
				// Use location to determine median
				median = data.get(location);
			}
			
			sampleMedian = median;
		}
		// If there is no data, print error message
		catch (MissingDataException ex)
		{
			System.out.println(ex.NoMedian());
		}
	}
	
	/** Purpose: Sets the variance
	 * @param dataset
	 * @return none
	 */
	public void setVariance(String dataset)
	{
		try
		{
			// First, check if sample size is non-zero
			int sampleSize; // Number of data points
			
			// Get sample size
			sampleSize = super.getSampleSize();
			
			// If there is no data, throw MissingDataException
			if (sampleSize == 0)
			{
				throw new MissingDataException();
			}
			// If there is only a single data point, throw InsufficientDataException
			else if (sampleSize == 1)
			{
				throw new InsufficientDataException();
			}
			
			// If there is data, continue with the code below
			// Initialize data ArrayList
			ArrayList<Double> data = new ArrayList<Double>();
				
			// Read in data from file
			data = super.readData(dataset);
			
			// Initialize relevant values needed to calculate variance
			double sumOfSquares = 0.0; // sum of squares
			
			// Calculate the sum of squares
			for (int k = 0; k < sampleSize; k++)
			{
				sumOfSquares += (data.get(k) - sampleAverage) * (data.get(k) - sampleAverage);
			}
			
			// Divide by the sample size - 1 to get the sample variance
			sampleVariance = sumOfSquares / (sampleSize - 1);
			
		}
		// If there is no data, print error message
		catch (MissingDataException ex)
		{
			System.out.println(ex.NoVariance());
		}
		// If there is only one data point, print error message
		catch (InsufficientDataException ex)
		{
			System.out.println(ex.NotEnoughDataForVariance());
		}
	}
	
	/** Purpose: Sets the standard deviation
	 * @param dataset
	 * @return none
	 */
	public void setStandardDeviation(String dataset)
	{
		try
		{
			// First, check if sample size is non-zero
			int sampleSize; // Number of data points
			
			// Get sample size
			sampleSize = super.getSampleSize();
			
			// If there is no data, throw MissingDataException
			if (sampleSize == 0)
			{
				throw new MissingDataException();
			}
			// If there is only a single data point, throw InsufficientDataException
			else if (sampleSize == 1)
			{
				throw new InsufficientDataException();
			}
			
			// In case sample variance is not yet calculated, calculate sample variance first
			// This is to allow setStandardDeviation to be executed anytime
			setVariance(dataset);
			
			// The standard deviation is the square root of the sample variance
			sampleStandardDeviation = Math.sqrt(sampleVariance);
		}
		catch (MissingDataException ex)
		{
			System.out.println(ex.NoStandardDeviation());
		}
		catch (InsufficientDataException ex)
		{
			System.out.println(ex.NotEnoughDataForStandardDeviation());
		}
	}
	
	/** Purpose: Sets the range
	 * @param File name
	 * @return none
	 */
	public void setRange(String dataset)
	{
		try
		{
			// First, check if sample size is non-zero
			int sampleSize; // Number of data points
			
			// Get sample size
			sampleSize = super.getSampleSize();
			
			// If there is no data, throw MissingDataException
			if (sampleSize == 0)
			{
				throw new MissingDataException();
			}
			
			// If there is data, continue with the code below
			// Initialize data ArrayList
			ArrayList<Double> data = new ArrayList<Double>();
				
			// Read in data from file
			data = super.readData(dataset);
			
			// Sort data from least to greatest using BubbleSort
			data = super.bubbleSort(data);
			
			// Min is the first entry, Max is the last entry; the difference is the range
			sampleRange = data.get(sampleSize - 1) - data.get(0);
			
		}
		catch (MissingDataException ex)
		{
			System.out.println(ex.NoRange());
		}
	}
	
	/** Purpose: Provides descriptive statistics for data or give an error
	 * @param none
	 * @return Descriptive statistics or error
	 */
	public String toString()
	{
		try
		{
			// If there is no data, throw MissingDataException
			if (super.getSampleSize() == 0)
			{
				throw new MissingDataException();
			}
			
			// If the user inputs data, give complete statistical information
			if (dataset == "User Dataset")
			{
				return "You are currently using " + super.getBranch() + ".\nThe average is " + String.format("%.2f", getAverage()) + " and the median of your data is " + 
						String.format("%.2f", getMedian()) + ".\n" + 
						"The sample variance of your data is " + String.format("%.2f", getVariance()) +  
						".\nThe sample standard deviation of your data is "  + String.format("%.2f",  getStandardDeviation()) + 
						".\nThe range of your data is " + 
						String.format("%.2f", getRange()) + ".\n";
			}
			else 
			{
				// If a valid file is used, give complete statistical information
				return "You are currently using " + super.getBranch() + ".\nYour dataset contains " + super.getSampleSize() + " data points. " + 
						"\nThe average of your data is " + String.format("%.2f", getAverage()) + " and the median of your data is " + 
						String.format("%.2f", getMedian()) + ".\n" + 
						"The sample variance of your data is " + String.format("%.2f", getVariance()) +  
						".\nThe sample standard deviation of your data is "  + String.format("%.2f",  getStandardDeviation()) + 
						".\nThe range of your data is " + 
						String.format("%.2f", getRange()) + ".\n";
			}
		}
		// If an invalid file is used, alert the user that an empty dataset or an invalid file was used
		catch (MissingDataException e)
		{
			return "\nYou have entered an empty dataset or an invalid file.\n";
		}
	}
}
