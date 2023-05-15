package probabilitystatsproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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
 * Display the branch of a Statistic object
 * Read in the data (formatted such that the first entry is the number of data points and the remaining entries are doubles)
 * Store data into a double array
 * Get the sample size
 * Sort data using Bubble Sort
 * 
 */

// Statistic is-a MathematicsBranch
public abstract class Statistic_Old extends MathematicsBranch
{
	private String branch = "Statistic"; // A Statistic has-a branch
	private int sampleSize = 0; // A Statistic has-a sampleSize

	/** Purpose: Get the branch for Statistic object
	 * @param none
	 * @return String describing the object, including the branch
	 */	
	public String getBranch()
	{
		return this.branch;
	}
	
	/** Purpose: Read in file contents
	 * @param File name
	 * @return File contents in double array
	 */
	public double[] readData(String dataset) 
	{
		// Initialize Scanner object and double array
		Scanner fileScan = null;
		double[] data = null;

		// If the file exists, perform try
		try
		{
			// Open file
			File newFile = new File(dataset);
			// Open Scanner
			fileScan = new Scanner(newFile);
			// Create double array of appropriate sample size
			data = new double[getSampleSize()];
			
			// Enter data into data array
			for (int k = 0; k < getSampleSize(); k++)
			{
				data[k] = fileScan.nextDouble();
			}
			
		}
		/* If the file is missing, alert the user
		 Note: This catch block should not be reached as a missing file is already checked in setSampleSize()
		 This catch block is here since a File object is used
		*/
		catch (FileNotFoundException e)
		{
			System.out.println("The file is missing");
		}
		// Close Scanner object if the Scanner object was opened
		finally
		{
			if (fileScan != null)
			{
				fileScan.close();
			}
		}
		return data;
	}
	
	/** Purpose: Add data to file
	 * @param file to add data to and data to add
	 * @return none
	 */
	public void appendData(String dataset, String data)
	{

		// Initialize FileWriter object and PrintWriter object
		FileWriter outStream;
		PrintWriter appendedFile = null;
		
		// If the file exists, perform try
		try
		{
			// Create FileWriter object and make it able to append data
			// FileWriter creates an output stream to the file dataset (from Morelli pg. 508)
			outStream = new FileWriter(dataset, true);
			// Create PrintWriter object 
			appendedFile = new PrintWriter(outStream);
			// Append data to file
			appendedFile.append(data);
		}
		// If the file does not exist, return null
		catch (IOException e)
		{
			return;
		}
		// If the PrintWriter object was opened, close it
		finally
		{
			if (appendedFile != null)
			{
				appendedFile.close();
			}
		}
		return;
	}
	
	/** Purpose: Set the sample size
	 * @param File name
	 * @return none
	 */
	public void setSampleSize(Object dataset) 
	{
		// If a file name is given, determine number of data points by reading data
		if (dataset instanceof String)
		{
			// Typecast dataset into String
			String fileName = (String)dataset;
			
			// Initialize Scanner object and number of points counter
			Scanner fileScan = null;
			int numberPoints = 0;
			
			// If the file exists, perform try
			try
			{
				// Open file
				File newFile = new File(fileName);
				// Open Scanner
				fileScan = new Scanner(newFile);

				// If there is another data point, increase the number of points by 1
				while (fileScan.hasNext()) 
				{
					numberPoints++;
					fileScan.next();
				}

				// If the sample size is 0 (i.e. there is no data), return error message to user
				if (numberPoints == 0)
				{
					throw new MissingDataException();
				}
			}
			// If there is no data, print error message
			catch (MissingDataException e)
			{
				System.out.println(e.getMessage());
			}
			// If the file does not exist, return error message to user
			catch (FileNotFoundException e)
			{
				System.out.println("The file is missing.");
			}
			// Close Scanner object if the Scanner object was opened
			finally
			{
				if (fileScan != null)
				{
					fileScan.close();
				}
			}
			
			// Set the sample size to the number of points counted
			sampleSize = numberPoints;
		}
		
		// If user provided data in a double array, find sample size by taking length of array
		else if (dataset instanceof double[])
		{
			// Typecast dataset into double array
			double[] data = (double[])dataset;
			
			// Set the sample size to the length of the dataset provided
			sampleSize = data.length;
		}
		
	}
	
	/** Purpose: Gets the sample size
	 * @param none
	 * @return sample size
	 */
	public int getSampleSize()
	{
		return sampleSize;
	}
	
	/**
	 * Purpose: Determine if the elements of an array are in ascending order
	 * 
	 * @param array to determine if the elements are in ascending order
	 * @return true if elements are in ascending order, false if not
	 */
	public boolean inOrder(double[] array)
	{
		// This initializes the ordered variable to true since we assume elements are in ascending order unless found otherwise
		boolean ordered = true;
		
		/* This loops checks each element and the one after to see if the latter element is less than the former element. 
		 * If that is the case, then the elements are not in order and ordered is set to false
		 * Note that we only check up to array.length-1 since we need the kth and (k+1)th indices
		 */

		for (int k = 0; k < (array.length - 1); k++)
			if (array[k + 1] < array[k])
				ordered = false;
		return ordered;
	}
	
	/**
	 * Purpose: Swap two adjacent elements in an array 
	 * 
	 * @param array to swap elements in
	 * @param value to designate which indices to change, assuming the indices are valid
	 * @return array with swapped elements
	 */
	public double[] swap(double[] array, int value)
	{
		// This creates a temporary variable to store the element at index value + 1
		double temp = array[value + 1];
		
		// This swaps the element at index value with the element at index value + 1
		array[value + 1] = array[value];
		array[value] = temp;
		
		return array;
	}
	
	/**
	 * Purpose: Perform a single pass of swapping elements in an array. 
	 * For each element, if the next element is smaller than the current element, perform a swap 
	 * 
	 * @param array to swap elements in
	 * @return an array in which a single pass of swapping has been performed 
	 */
	public double[] bubbleUp(double[] array)
	{
		/* This for loop checks looks at all elements in the array
		 * Note that we only check up to array.length-1 since we need the kth and (k+1)th indices
		 */
		for (int k = 0; k < (array.length - 1); k++)
		{
			// This if statement checks if the next element is smaller than the current element. If so, perform a swap
			if (array[k + 1] < array[k])
				swap(array, k);
		}
		return array;
	}
	
	/**
	 * Purpose: Perform a bubble sort on a given array
	 * 
	 * @param array to swap elements in
	 * @return an array with sorted elements 
	 */
	public double[] bubbleSort(double[] array)
	{
		/* This while loop checks if the array is sorted. 
		 * If the array is not sorted, perform a single pass of sorting using bubbleUp
		 */
		while (inOrder(array) == false)
		{
			bubbleUp(array);
		}
		return array;
	}
}
