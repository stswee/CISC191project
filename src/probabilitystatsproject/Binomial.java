package probabilitystatsproject;

import java.util.*;
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
 * Creates a binomial object with size n and probability p
 * Get the mathematics branch, type of distribution, mean, standard deviation, variance, use cases, and more use cases
 * Provide a description of the binomial object
 * Throw exceptions if invalid parameters were used
 * 
 */

// A Binomial is-a Discrete and is SummaryProbability, UseCases, and AddUseCases
public class Binomial extends Discrete implements SummaryProbability, UseCases, AddUseCases
{
	private int n; // A Binomial has-a (parameter) n
	private double p; // A Binomial has-a (parameter) p
	private double[] parameter = new double[2]; // A Binomial has-a parameter
	private String[] useCases; // A Binomial has-a useCases
	private String[] newUseCases; // A Binomial has-a newUseCases
	
	// Checks if getStandardDeviation() method has been called; used for Exception handling
	private boolean checkStandardDeviation = false; // A binomial has-a checkStandardDeviation
	
	
	/** Purpose: Creates a Binomial object given parameters n and p
	 * @param n, p
	 * @return none
	 */
	Binomial(int n, double p) throws InvalidParameterException
	{
		// If valid parameters are used, create a Binomial object with valid parameters
		try
		{
			// This sets the initial use cases
			useCases = new String[]{"Modeling coin flips", "Modeling if a medication cures a disease", "Modeling two-party voting patterns"};
						
			// Parameters are invalid if n is not positive and p is not between 0 and 1
			if ((n <= 0) || (p < 0) || (p > 1))
			{
				throw new InvalidParameterException();
			}
			
			// This sets the parameters
			this.n = n;
			this.p = p;
			
			// Store the parameters into the parameter array
			this.parameter[0] = n;
			this.parameter[1] = p;
			
		} 
		// If invalid parameters are used, print out an error message 
		catch (InvalidParameterException ex)
		{
			System.out.println(ex.getMessage());
		}
	}	
	/** Purpose: Gets the Probability branch
	 * @param none
	 * @return Probability branch
	 */
	public String getBranch()
	{
		return super.getBranch();
	}
	
	/** Purpose: Gets the distribution type
	 * @param none
	 * @return distribution type
	 */
	public String getType()
	{
		return super.getType();
	}
	
	/** Purpose: Gets the mean
	 * @param none
	 * @return mean
	 */
	public double getMean()
	{
		// If parameters are valid, return the mean
		try
		{
			// Parameters are invalid if n is not positive and p is not between 0 and 1
			if ((n <= 0) || (p < 0) || (p > 1))
			{
				throw new InvalidParameterException();
			}
			return n * p;
		} 
		// If invalid parameters are used, print out an error message 
		catch(InvalidParameterException ex)
		{
			System.out.println(ex.invalidMean());
		}
		// Return default value of 0
		return 0.0;
	}
	
	/** Purpose: Gets the standard deviation
	 * @param none
	 * @return standard deviation
	 */
	public double getStandardDeviation()
	{
		// Assign checkStandardDeviation to be true and print out standard deviation error message if InvalidParameterException thrown
		checkStandardDeviation = true;
		return Math.sqrt(getVariance());
	}
	
	/** Purpose: Gets the variance
	 * @param none
	 * @return variance
	 */
	public double getVariance()
	{
		// If parameters are valid, return the variance
		try
		{
			// Parameters are invalid if n is not positive and p is not between 0 and 1
			if ((n <= 0) || (p < 0) || (p > 1))
			{
				throw new InvalidParameterException();
			}
			return n * p * (1 - p);
		}
		// If invalid parameters are used, print out an error message 
		catch(InvalidParameterException ex)
		{
			// If getStandardDeviation() method was used, return standard deviation error message
			if (checkStandardDeviation == true)
			{
				System.out.println(ex.invalidStandardDeviation());
				checkStandardDeviation = false;
			}
			// If getVariance() method was used, return variance error message
			else
			{
				System.out.println(ex.invalidVariance());
			}
		}
		// Return default value of 0
		return 0.0;
	}
	
	/** Purpose: Gets the parameters
	 * @param none
	 * @return parameters in double array
	 */
	public double[] getParameters()
	{
		return parameter;
	}
	
	/** Purpose: Gets the use cases
	 * @param none
	 * @return use cases
	 */
	public String[] getUseCases()
	{
		return useCases;
	}
	
	/** Purpose: Gets the use cases in a String format
	 * @param none
	 * @return use cases
	 */
	public String useCasesToString()
	{
		// Initialize empty string
		String useCasesString = "";
		for (int k = 0; k < useCases.length; k++)
		{
			// Special case for last use case to make the string grammatically correct
			if (k == (useCases.length - 1))
			{
				useCasesString += "and ";
				useCasesString += useCases[k];
			}
			// Add use case to string
			else {
				useCasesString += useCases[k];
				useCasesString += ", ";
			}
		}
		return useCasesString;
	}
	
	/** Purpose: Set more use cases
	 * @param number of additional use cases
	 * @return none
	 */
	public void setMoreUseCases(int numberOfUseCases)
	{
		// Open scanner for user input
		Scanner inputMoreUseCases = new Scanner(System.in);
		
		// Initialize array of new use cases
		newUseCases = new String[numberOfUseCases];
		
		// Add additional use cases to array
		for (int k = 0; k < newUseCases.length; k ++)
		{
			System.out.println("Enter another use case: ");
			newUseCases[k] = inputMoreUseCases.nextLine();
		}
		
		// Close scanner object
		inputMoreUseCases.close();
	}
	
	/** Purpose: Get more use cases
	 * @param none
	 * @return new use cases
	 */
	public String[] getMoreUseCases()
	{
		return newUseCases;
	}
	
	/** Purpose: Gets the use cases in a String format
	 * @param none
	 * @return use cases
	 */
	public String moreUseCasesToString()
	{
		// If no use cases have been added, return null
		if (newUseCases == null)
		{
			return null;
		}
		// Initialize empty string
		String newUseCasesString = "";
		for (int k = 0; k < newUseCases.length; k++)
		{
			// Special case for last use case to make the string grammatically correct
			if (k == (useCases.length - 1))
			{
				newUseCasesString += "and ";
				newUseCasesString += newUseCases[k];
			}
			// Add use case to string
			else {
				newUseCasesString += newUseCases[k];
				newUseCasesString += ", ";
			}
		}
		return newUseCasesString;
	}
	
	/** Purpose: Describes binomial distribution given parameters or gives shortened description
	 * @param none
	 * @return Description of binomial distribution or shortened description
	 */
	public String toString()
	{
		try
		{
			// Parameters are invalid if n is not positive and p is not between 0 and 1
			if ((n <= 0) || (p < 0) || (p > 1))
			{
				throw new InvalidParameterException();
			}
			
			// If no additional cases are added, display default description
			if (moreUseCasesToString() == null)
			{
				return "The binomial distribution has parameters n = " + parameter[0] + " and p = " + parameter[1] + 
						".\nIt is a " + super.getType() + " distribution studied under " + super.getBranch() +  
						". \nThe mean is " + getMean() + ", The standard deviation is " + String.format("%.2f", getStandardDeviation()) + 
						". The variance is " + String.format("%.2f", getVariance()) + ". \nSome use cases are " + useCasesToString() + ".\n";
			}
			// If additional cases are added, display description with additional cases
			else
			{
				return "The binomial distribution has parameters n = " + parameter[0] + " and p = " + parameter[1] + 
						".\nIt is a " + super.getType() + " distribution studied under " + super.getBranch() + 
						". \nThe mean is " + getMean() + ", The standard deviation is " + String.format("%.2f", getStandardDeviation()) + 
						". The variance is " + String.format("%.2f", getVariance()) + ". \nSome use cases are " + useCasesToString() + 
						". \nSome additional use cases include " + moreUseCasesToString() + ".\n";
			}
		}
		catch (InvalidParameterException ex)
		{
			// If no additional cases are added, display default shortened description
			if (moreUseCasesToString() == null)
			{
				return "Displaying default error values: \n" + 
						"Error mean: " + getMean() + "\n" + 
						"Error standard deviation: " + getStandardDeviation() + "\n" + 
						"Error variance: " + getVariance() + "\n\n" +
						"Displaying shortened description: \n" + 
						"The binomial distribution is a " + super.getType() + " distribution studied under " + super.getBranch()
						+ ".\nSome use cases are " + useCasesToString() + ".\n";
			}
			// If additional cases are added, display shortened description with additional cases
			else
			{
				return "Displaying default error values: \n" + 
						"Error mean: " + getMean() + "\n" + 
						"Error standard deviation: " + getStandardDeviation() + "\n" + 
						"Error variance: " + getVariance() + "\n\n" +
						"Displaying shortened description: \n" +  
						"The binomial distribution is a " + super.getType() + " distribution studied under " + super.getBranch()
						+ ".\nSome use cases are " + useCasesToString() + 
						". \nSome additional use cases include " + moreUseCasesToString() + ".\n";
			}
		}

	}
}
