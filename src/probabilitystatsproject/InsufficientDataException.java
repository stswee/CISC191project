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
 * Display error messages when only a single data point was given in the dataset
 * Error messages are customized depending on method
 *
 */

// InsufficientDataException is-a Exception
public class InsufficientDataException extends Exception
{
	// Prints error message when variance cannot be calculated
	public String NotEnoughDataForVariance()
	{
		return "More than one data point is needed to calculate variance.";
	}
	
	// Prints error message when standard deviation cannot be calculated
	public String NotEnoughDataForStandardDeviation()
	{
		return "More than one data point is needed to calculate standard deviation.";
	}
}
