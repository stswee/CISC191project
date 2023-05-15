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
 * Responsibilities of interface:
 * Specifies the methods to be implemented
 * This interface specifies setting (adding) use cases and getting the new use cases
 * 
 */

public interface AddUseCases
{
	/**
	 * Purpose: Sets the required methods for any class that implements AddUseCases
	 * @return none for setMoreUseCases() and String array of use cases for getMoreUseCases()
	 */
	
	public abstract void setMoreUseCases(int numberOfNewUseCases);
	public abstract String[] getMoreUseCases();
}
