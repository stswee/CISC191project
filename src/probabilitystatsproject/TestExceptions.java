package probabilitystatsproject;

public class TestExceptions
{
	public static void main(String[] args) throws InvalidParameterException
	{
//		// Valid case (for comparison purposes)
//		Center centerTest = new Center("TestData.csv");
//		System.out.println(centerTest.toString());
//		
//		// What happens when exceptions are not handled?
//		// Invalid case (File not found); Should terminate program
//		Center centerException = new Center("MissingFile.csv");
//		System.out.println(centerException.toString());
		
		// Valid case (for comparison purposes)
		// A Valid binomial distribution has a positive integer n and a value of p between 0 and 1
		Binomial binomialValid = new Binomial(10, 0.4);
		System.out.println(binomialValid.toString());
		
		// Invalid case (negative n should raise exception)
		Binomial binomialException = new Binomial(-2, 0.5);
		System.out.println(binomialException.toString());
		
		// Invalid case (p greater than 1 should raise exception)
		Binomial binomialException2 = new Binomial(15, 1.5);
		System.out.println(binomialException2.toString());
		
		// Valid case (for comparison purposes)
		DescriptiveStatistics dsTest = new DescriptiveStatistics("TestData.csv");
		System.out.println(dsTest.toString());
		
		// Invalid case
		DescriptiveStatistics dsExc = new DescriptiveStatistics("MissingData.csv");
		System.out.println(dsExc.toString());	
		
		// Test empty array input
//		double realArr[] = {};
//		DescriptiveStatistics inputTest = new DescriptiveStatistics(realArr);
//		System.out.println(inputTest.toString());
	}
}
