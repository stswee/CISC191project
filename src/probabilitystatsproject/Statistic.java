package probabilitystatsproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public abstract class Statistic extends MathematicsBranch
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
	 * @return File contents in ArrayList with doubles
	 */
	public ArrayList<Double> readData(String dataset) 
	{
		// Initialize Scanner object and ArrayList with doubles
		Scanner fileScan = null;
		ArrayList<Double> data = new ArrayList<Double>();

		// If the file exists, perform try
		try
		{
			// Open file
			File newFile = new File(dataset);
			// Open Scanner
			fileScan = new Scanner(newFile);
			
			// Enter data into ArrayList with doubles
			while(fileScan.hasNext()) {
				data.add(fileScan.nextDouble());
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

	/** Purpose: Set the sample size
	 * @param File name
	 * @return none
	 */
	public void setSampleSize(String dataset) 
	{
		// Determine number of data points by first reading the data
		ArrayList<Double> data = readData(dataset);
		// Set the sample size to the number of points counted
		sampleSize = data.size();
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
	 * Purpose: Determine if the elements of an ArrayList are in ascending order
	 * 
	 * @param ArrayList to determine if the elements are in ascending order
	 * @return true if elements are in ascending order, false if not
	 */
	public boolean inOrder(ArrayList<Double> list)
	{
		// This initializes the ordered variable to true since we assume elements are in ascending order unless found otherwise
		boolean ordered = true;
		
		/* This loops checks each element and the one after to see if the latter element is less than the former element. 
		 * If that is the case, then the elements are not in order and ordered is set to false
		 * Note that we only check up to array.length-1 since we need the kth and (k+1)th indices
		 */

		for (int k = 0; k < (list.size() - 1); k++)
			if (list.get(k + 1) < list.get(k))
				ordered = false;
		return ordered;
	}
	
	/**
	 * Purpose: Swap two adjacent elements in an ArrayList 
	 * 
	 * @param ArrayList to swap elements in
	 * @param ArrayList to designate which indices to change, assuming the indices are valid
	 * @return ArrayList with swapped elements
	 */
	public ArrayList<Double> swap(ArrayList<Double> list, int value)
	{
		// This creates a temporary variable to store the element at index value + 1
		double temp = list.get(value + 1);
		
		// This swaps the element at index value with the element at index value + 1
		list.set(value + 1, list.get(value));  
		list.set(value,  temp);
		
		return list;
	}
	
	/**
	 * Purpose: Perform a single pass of swapping elements in an ArrayList. 
	 * For each element, if the next element is smaller than the current element, perform a swap 
	 * 
	 * @param ArrayList to swap elements in
	 * @return an ArrayList in which a single pass of swapping has been performed 
	 */
	public ArrayList<Double> bubbleUp(ArrayList<Double> list)
	{
		// This for loop checks looks at all elements in the ArrayList
		for (int k = 0; k < (list.size() - 1); k++)
		{
			// This if statement checks if the next element is smaller than the current element. If so, perform a swap
			if (list.get(k + 1) < list.get(k))
				swap(list, k);
		}
		return list;
	}
	
	/**
	 * Purpose: Perform a bubble sort on a given ArrayList
	 * 
	 * @param ArrayList to swap elements in
	 * @return an ArrayList with sorted elements 
	 */
	public ArrayList<Double> bubbleSort(ArrayList<Double> list)
	{
		/* This while loop checks if the ArrayList is sorted. 
		 * If the ArrayList is not sorted, perform a single pass of sorting using bubbleUp
		 */
		while (inOrder(list) == false)
		{
			bubbleUp(list);
		}
		return list;
	}
}
