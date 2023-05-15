package probabilitystatsproject;

public class TestProject
{
	public static void main(String[] args) throws InvalidParameterException
	{
		// Part 1: Valid inputs for probability
		// Task 1: Test the binomial distribution with n = 30 and p = 0.5
		Binomial binomialtest = new Binomial(30, 0.5);
		System.out.println(binomialtest.toString());
		
		// Task 2: Test the binomial distribution with the additional use case of determining winning or losing a raffle and 
		// determining if someone passes or fails a class, and determining if a football team wins
		Binomial binomialtest1 = new Binomial(20, 0.5);
		binomialtest1.setMoreUseCases(3);
		System.out.println(binomialtest1.toString());
		
		// Task 3: Test the Poisson distribution with lambda = 5
		Poisson poissontest = new Poisson(5);
		System.out.println(poissontest.toString());
		
		// Task 4: Test the Exponential distribution with lambda = 4
		Exponential exponentialtest = new Exponential(4);
		System.out.println(exponentialtest.toString());
		
		// Task 5: Test the Normal distribution with mu = 3 and sigma = 4
		Normal normaltest = new Normal(3, 4);
		System.out.println(normaltest.toString());
		
		// Part 2: User input/output
		// Task 6: Test file input and determine descriptive statistics
		DescriptiveStatistics DSTest = new DescriptiveStatistics("TestData.csv");
		System.out.println(DSTest.toString());
		
		// Part 3: Exceptions
		// Task 7: Test each distribution with invalid parameters
		Binomial binomialexception = new Binomial(0, 0.5); // n = 0 is an invalid parameter
		System.out.println(binomialexception.toString());
		Poisson poissonexception = new Poisson(-4); // lambda = -4 is an invalid parameter
		System.out.println(poissonexception.toString());
		Exponential exponentialexception = new Exponential(-3); // lambda = -3 is an invalid parameter
		System.out.println(exponentialexception.toString());
		Normal normalexception = new Normal(-100, -2); // Sigma = -2 is an invalid parameter
		System.out.println(normalexception.toString());
		
		// Task 8: Test invalid file input
		DescriptiveStatistics DSInvalid = new DescriptiveStatistics("InvalidFile.csv");
		System.out.println(DSInvalid.toString());
		
		// Task 9: Confidence interval GUI
		new ConfidenceInterval();
		
	}
}
