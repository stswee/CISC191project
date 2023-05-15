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
 * Display error messages when invalid parameters were used
 * Error messages are customized depending on method
 *
 */

// InvalidParameterException is-a Exception
public class InvalidParameterException extends Exception
{
	// Default constructor to create InvalidParameterException object
	InvalidParameterException()
	{
		super("An invalid value for one or more parameters has been used");
	}
	
	// Gives the message that a mean cannot be calculated given invalid parameters
	public String invalidMean()
	{
		return "Mean cannot be calculated";
	}
	
	// Gives the message that a variance cannot be calculated given invalid parameters
	public String invalidVariance()
	{
		return "Variance cannot be calculated";
	}
	
	// Gives the message that a standard deviation cannot be calculated given invalid parameters
	public String invalidStandardDeviation()
	{
		return "Standard Deviation cannot be calculated";
	}
}