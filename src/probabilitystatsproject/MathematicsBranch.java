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

public abstract class MathematicsBranch
{
	/** Purpose: Gets the mathematics branch; anything that extends MathematicsBranch requires this method
	 * @param none
	 * @return the mathematics branch
	 */
	abstract String getBranch();
	
}
