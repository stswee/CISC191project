package probabilitystatsproject;

/**
 * Lead Author(s):
 * @author Steven Swee
 * 
 * References:
 * 
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *  
 * Version/date: 2022-12 (4.26.0)
 * 
 * Responsibilities of interface:
 * Specifies the methods to be implemented
 * This interface specifies getting the mean, standard deviation, variance, and parameters
 * 
 */

public interface SummaryProbability
{
	/**
	 * Purpose: Sets the required methods for any class that implements SummaryProbability
	 * @return double for mean, standard deviation, variance, and parameters
	 */
	
	public abstract double getMean();
	public abstract double getStandardDeviation();
	public abstract double getVariance();
	public abstract double[] getParameters();
}
