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
 * Display the branch of a Probability object
 * 
 */

// Probability is-a MathematicsBranch
public abstract class Probability extends MathematicsBranch
{
	private String branch = "Probability"; // A Probability has-a branch
	
	/** Purpose: Get the branch for Probability object
	 * @param none
	 * @return String describing the object, including the branch
	 */	
	public String getBranch()
	{
		return this.branch;
	}
}
