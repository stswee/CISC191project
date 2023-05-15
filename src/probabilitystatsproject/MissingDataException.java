package probabilitystatsproject;

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
 * Display error messages when an invalid file or an empty array is given
 * Error messages are customized depending on method
 *
 */

// MissingDataException is-a Exception
public class MissingDataException extends Exception
{
	// Default constructor to create InvalidParameterException object
	MissingDataException()
	{
		super("There is no data in the file provided.");
	}
	
	// Error if no data is provided
	public String NoDataAvailable()
	{
		return "There is no data to store.";
	}
	
	// Error if average cannot be calculated
	public String NoAverage()
	{
		return "There is no data to average.";
	}
	
	// Error if median cannot be determined
	public String NoMedian()
	{
		return "There is no data to take the median for.";
	}
	
	// Error if variance cannot be calculated
	public String NoVariance()
	{
		return "There is no data to calculate the variance for.";
	}
	
	// Error if standard deviation cannot be calculated
	public String NoStandardDeviation()
	{
		return "There is no data to calculate the standard deviation for.";
	}
	
	// Error if range cannot be calculated
	public String NoRange()
	{
		return "There is no data to calculate the range for.";
	}
}
