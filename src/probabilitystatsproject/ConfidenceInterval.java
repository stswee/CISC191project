package probabilitystatsproject;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
 * Creates a GUI that displays instructions, text fields, sliders, and buttons
 * Listeners for sliders and buttons; allows text fields to change based on slider value and button pressed
 * Allows the users to calculate confidence intervals given a mean, standard deviation, sample size, and confidence level
 * 
 */

public class ConfidenceInterval extends JFrame
{
	// Set relevant instance variables
	private JLabel instruction; // A ConfidenceInterval has-a instruction
	private JLabel lowerBound; // A ConfidenceInterval has-a lower
	private JLabel upperBound; // A ConfidenceInterval has-a upper
	private JLabel mean; // A ConfidenceInterval has-a mean
	private JLabel standardDeviation; // A ConfidenceInterval has-a standardDeviation
	private JLabel sampleSize; // A ConfidenceInterval has-a sampleSize
	private JLabel confidence; // A ConfidenceInterval has-a confidence
	private JLabel confidenceLabel; // A ConfidenceInterval has-a confidenceLabel
	private JLabel meanSliderLabel; // A ConfidenceInterval has-a meanSliderLabel
	private JLabel standardDeviationSliderLabel; // A ConfidenceInterval has-a standardDeviationSliderLabel
	private JLabel sampleSizeSliderLabel; // A ConfidenceInterval has-a sampleSizeSliderLabel
	private JButton confidence90; // A ConfidenceInterval has-a confidence90
	private JButton confidence95; // A ConfidenceInterval has-a confidence95
	private JButton confidence99; // A ConfidenceInterval has-a confidence99
	private JTextField lowerBoundText; // A ConfidenceInterval has-a lowerBound
	private JTextField upperBoundText; // A ConfidenceInterval has-a upperBound
	private JTextField meanText; // A ConfidenceInterval has-a meanText
	private JTextField standardDeviationText; // A ConfidenceInterval has-a standardDeviationText
	private JTextField sampleSizeText; // A ConfidenceInterval has-a sampleSizeText
	private JTextField confidenceLevel; // A ConfidenceInterval has-a confidenceLevel
	private JSlider meanSlider; // A ConfidenceInterval has-a meanSlider
	private JSlider standardDeviationSlider; // A ConfidenceInterval has-a standardDeviationSlider
	private JSlider sampleSizeSlider; // A ConfidenceInterval has-a sampleSizeSlider
	
	
	ConfidenceInterval()
	{
		// Set title
		setTitle("Confidence Interval");
		
		// Create message labels
		instruction = new JLabel("Adjust the sliders and click on a button to create a confidence interval");
		lowerBound = new JLabel("Lower bound: ");
		upperBound = new JLabel("Upper bound: ");
		confidence = new JLabel("Confidence Level: ");
		mean = new JLabel("Mean: ");
		standardDeviation = new JLabel("Standard Deviation: ");
		sampleSize = new JLabel("n: ");
		confidenceLabel = new JLabel("Confidence Level");
								
		// Create text fields
		lowerBoundText = new JTextField("0.00", 10);
		upperBoundText = new JTextField("0.00", 10);
		confidenceLevel = new JTextField("95", 10);
		meanText = new JTextField("0.00", 10);
		standardDeviationText = new JTextField("5.00", 10);
		sampleSizeText = new JTextField("30", 10);
		
		// Make text fields read-only
		lowerBoundText.setEditable(false);
		upperBoundText.setEditable(false);
		confidenceLevel.setEditable(false);
		meanText.setEditable(false);
		standardDeviationText.setEditable(false);
		sampleSizeText.setEditable(false);
		
		// Create buttons
		confidence90 = new JButton("90%");
		confidence90.addActionListener(new ButtonListener90());
		confidence95 = new JButton("95%");
		confidence95.addActionListener(new ButtonListener95());
		confidence99 = new JButton("99%");
		confidence99.addActionListener(new ButtonListener99());
		
		// Create mean slider
		meanSlider = new JSlider(JSlider.VERTICAL, -20, 20, 0); 
		meanSlider.setMajorTickSpacing(10); 
		meanSlider.setPaintLabels(true); 
		meanSlider.addChangeListener(new SliderListener()); 
		meanSliderLabel = new JLabel("Mean");
		
		// Create standard deviation slider
		standardDeviationSlider = new JSlider(JSlider.VERTICAL, 1, 10, 5);
		standardDeviationSlider.setMajorTickSpacing(1);
		standardDeviationSlider.setPaintLabels(true);
		standardDeviationSlider.addChangeListener(new SliderListener());
		standardDeviationSliderLabel = new JLabel("Std. Dev.");
		
		// Create sample size slider
		sampleSizeSlider = new JSlider(JSlider.VERTICAL, 30, 50, 30);
		sampleSizeSlider.setMajorTickSpacing(5);
		sampleSizeSlider.setPaintLabels(true);
		sampleSizeSlider.addChangeListener(new SliderListener());
		sampleSizeSliderLabel = new JLabel("n");
		
		// Create panel to hold everything
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		// Create instruction panel
		JPanel instructionPanel = new JPanel();
		instructionPanel = new JPanel();
		instructionPanel.add(instruction);
		
		// Create interval panel
		JPanel intervalPanel = new JPanel();
		intervalPanel.setLayout(new GridLayout(3, 4));
		intervalPanel.add(lowerBound);
		intervalPanel.add(lowerBoundText);
		intervalPanel.add(upperBound);
		intervalPanel.add(upperBoundText);
		intervalPanel.add(mean);
		intervalPanel.add(meanText);
		intervalPanel.add(standardDeviation);
		intervalPanel.add(standardDeviationText);
		intervalPanel.add(sampleSize);
		intervalPanel.add(sampleSizeText);
		intervalPanel.add(confidence);
		intervalPanel.add(confidenceLevel);
		
		// Create slider panel
		JPanel sliderPanel = new JPanel();
		sliderPanel.setLayout(new GridLayout(1, 6));
		sliderPanel.add(meanSlider);
		sliderPanel.add(meanSliderLabel);
		sliderPanel.add(standardDeviationSlider);
		sliderPanel.add(standardDeviationSliderLabel);
		sliderPanel.add(sampleSizeSlider);
		sliderPanel.add(sampleSizeSliderLabel);
		
		// Create confidence panel
		JPanel confidencePanel = new JPanel();
		confidencePanel.setLayout(new GridLayout(1, 4));
		confidencePanel.add(confidence90);
		confidencePanel.add(confidence95);
		confidencePanel.add(confidence99);
		confidencePanel.add(confidenceLabel);
			
		// Add panels
		add(instructionPanel, BorderLayout.NORTH);
		add(intervalPanel, BorderLayout.WEST);
		add(confidencePanel, BorderLayout.EAST);
		add(sliderPanel, BorderLayout.CENTER);
		
		// Specify what happens when close buttons is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
		// Display window
		setVisible(true);
	}

	/** Purpose: Run the Confidence Interval GUI
	 * @param String array
	 * @return none
	 */
	public static void main(String[] args)
	{
		new ConfidenceInterval();
	}
	
	// Implement a listener for the sliders
	// Update the text fields as the sliders move
	private class SliderListener implements ChangeListener
	{
		public void stateChanged(ChangeEvent e) {
			// Initialize relevant variables
			double lower;
			double upper;
			double criticalValue = 0;
			double mean;
			double standardDeviation;
			String confidenceLevel = confidence.getText();
			int sampleSize;
			
			// Determine the critical value depending on the confidence level chosen
			if (confidenceLevel == "90") 
			{
				criticalValue = 1.645;
			}
			else if (confidenceLevel == "95")
			{
				criticalValue = 1.96;
			}
			else
			{
				criticalValue = 2.576;
			}
			
			// Get the values of the mean, standard deviation, and sample size from the slider
			mean = meanSlider.getValue();
			standardDeviation = standardDeviationSlider.getValue();
			sampleSize = sampleSizeSlider.getValue();
			
			// Calculate lower and upper bounds of the confidence interval
			lower = mean - criticalValue * standardDeviation / Math.sqrt(sampleSize);
			upper = mean + criticalValue * standardDeviation / Math.sqrt(sampleSize);;
			
			// Display values in the text fields
			lowerBoundText.setText(String.format("%.2f", lower));
			upperBoundText.setText(String.format("%.2f", upper));
			meanText.setText(Double.toString(mean));
			standardDeviationText.setText(Double.toString(standardDeviation));
			sampleSizeText.setText(Integer.toString(sampleSize));
		}
	}
	
	// Implement a listener for the 90% confidence button
	// Calculate the 90% confidence interval if the 90% confidence button is selected
	private class ButtonListener90 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			// Initialize relevant variables
			double lower;
			double upper;
			double criticalValue = 1.645;
			double mean;
			double standardDeviation;
			int sampleSize;
			
			// Get the values of the mean, standard deviation, and sample size from the slider
			mean = meanSlider.getValue();
			standardDeviation = standardDeviationSlider.getValue();
			sampleSize = sampleSizeSlider.getValue();
			
			// Calculate lower and upper bounds of the confidence interval
			lower = mean - criticalValue * standardDeviation / Math.sqrt(sampleSize);
			upper = mean + criticalValue * standardDeviation / Math.sqrt(sampleSize);;
			
			// Display values in the text fields
			confidenceLevel.setText("90");
			lowerBoundText.setText(String.format("%.2f", lower));
			upperBoundText.setText(String.format("%.2f", upper));
			meanText.setText(Double.toString(mean));
			standardDeviationText.setText(Double.toString(standardDeviation));
			sampleSizeText.setText(Integer.toString(sampleSize));
		}
	}
	
	// Implement a listener for the 95% confidence button
	// Calculate the 95% confidence interval if the 95% confidence button is selected
	private class ButtonListener95 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			// Initialize relevant variables
			double lower;
			double upper;
			double criticalValue = 1.96;
			double mean;
			double standardDeviation;
			int sampleSize;
			
			// Get the values of the mean, standard deviation, and sample size from the slider
			mean = meanSlider.getValue();
			standardDeviation = standardDeviationSlider.getValue();
			sampleSize = sampleSizeSlider.getValue();
			
			// Calculate lower and upper bounds of the confidence interval
			lower = mean - criticalValue * standardDeviation / Math.sqrt(sampleSize);
			upper = mean + criticalValue * standardDeviation / Math.sqrt(sampleSize);;
			
			// Display values in the text fields
			confidenceLevel.setText("95");
			lowerBoundText.setText(String.format("%.2f", lower));
			upperBoundText.setText(String.format("%.2f", upper));
			meanText.setText(Double.toString(mean));
			standardDeviationText.setText(Double.toString(standardDeviation));
			sampleSizeText.setText(Integer.toString(sampleSize));
		}
	}
	
	// Implement a listener for the 99% confidence button
	// Calculate the 99% confidence interval if the 99% confidence button is selected
	private class ButtonListener99 implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			// Initialize relevant variables
			double lower;
			double upper;
			double criticalValue = 2.576;
			double mean;
			double standardDeviation;
			int sampleSize;
			
			// Get the values of the mean, standard deviation, and sample size from the slider
			mean = meanSlider.getValue();
			standardDeviation = standardDeviationSlider.getValue();
			sampleSize = sampleSizeSlider.getValue();
			
			// Calculate lower and upper bounds of the confidence interval
			lower = mean - criticalValue * standardDeviation / Math.sqrt(sampleSize);
			upper = mean + criticalValue * standardDeviation / Math.sqrt(sampleSize);;
			
			// Display values in the text fields
			confidenceLevel.setText("90");
			lowerBoundText.setText(String.format("%.2f", lower));
			upperBoundText.setText(String.format("%.2f", upper));
			meanText.setText(Double.toString(mean));
			standardDeviationText.setText(Double.toString(standardDeviation));
			sampleSizeText.setText(Integer.toString(sampleSize));
		}
	}
}
