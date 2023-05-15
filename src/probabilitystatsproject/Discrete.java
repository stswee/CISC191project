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
 * Get the branch of a MathematicsBranch object
 * 
 */

// Discrete is-a Probability
public abstract class Discrete extends Probability
{
	private String type = "Discrete"; // A Discrete has-a type
	
	/** Purpose: Display the type of probability distribution
	 * @param none
	 * @return String describing the object, including the type
	 */
	public String getType()
	{
		return this.type;
	}
}
