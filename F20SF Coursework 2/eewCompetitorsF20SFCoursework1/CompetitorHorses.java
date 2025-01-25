package eewCompetitorsF20SFCoursework1;
import java.util.Arrays;

//This class defines a competition between imaginary horses. 
//Their overall score is determined by their height in hands. Hands is a standard increment for 
//measuring the height of horses and ponies.

public class CompetitorHorses extends Competitor
{
		//instance variables
		private double competitorHands;
		private String competitorLocation;
		    
		    
	public CompetitorHorses(String fullName, Integer number, double hands, String location, int [] scoresc1)//  
	{
		super(fullName, number, scoresc1);
		this.competitorHands = hands;
		this.competitorLocation = location;
	}
	
	
	
//	public int getScore()//this is here for getMaxScore() but i have not done anything with it yet.
//	{
//		return score;
//	}
	public double getOverallScore()
	{
		int total = 0;
		for (int scoresh1Index = 0; scoresh1Index < scoresc1.length; scoresh1Index++)
		{
			total += scoresc1[scoresh1Index];
		}
		if (competitorHands <= 14.9)//Short horses be slow. 
		{
				return (double) (total*.5)/scoresc1.length;
		}
		else if (competitorHands <=15.9)//Average height horses have average speeds. 
			{
				
			return (double) (total*1)/scoresc1.length;
			}
		else 
		{
			return (double) (total*1.5)/scoresc1.length;// Horses 16 hands and over are fast as heck.
		}
	}
	
	public double getcompetitorHands() 
	{
		return competitorHands;
	}

	public void setcompetitorHands(double newCompetitorHands)
	{
		competitorHands = newCompetitorHands; 
	}
			
	public String getcompetitorLocation() 
	{
		return competitorLocation;
	}
	
	public void setcompetitorLocation(String newCompetitorLocation)
	{
		competitorLocation = newCompetitorLocation;
	}
	
	public String toString() 
	{
		return competitorName.getFullName()+ " is competitor number " + competitorNumber + ".";
	}
	
	public String getFullDetails()
	{
		String details =  "";
		details = "Horse's name is " + competitorName.getFullName() + ". Their competitor number is " 
		+ competitorNumber + " and they are " + competitorHands + " hands tall. \n" + competitorName.getFullName() 
		+ " lives in the " + competitorLocation + ". Their scores are " + Arrays.toString(scoresc1) 
		+ " with an overall score of " + getOverallScore() + "\n";
		return details;
			
	}
		
}//end public class competitorHorses


