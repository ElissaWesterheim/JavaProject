package eewCompetitorsF20SFCoursework1;
import java.util.Arrays;  


public class EEWCompetitor extends Competitor
{
	//instance variables
		private int competitorLevel;
		private String competitorLocation;
	 	    
public EEWCompetitor(String fullName, Integer number, Integer level, String location, int [] scoresc1)//  
{
		super(fullName,number,scoresc1);
		this.competitorLevel = level;
		this.competitorLocation = location;
	
}

public double getOverallScore()
{
		int total = 0;
		for (int scoresc1Index = 0; scoresc1Index < scoresc1.length; scoresc1Index++)
		{
			total += scoresc1[scoresc1Index];
		}
	return (double) (total*.25)/scoresc1.length;
}
public String toString() 
{
	return competitorName.getFullName()+ " is competitor number " + competitorNumber + ".";
}	

public Integer getcompetitorLevel() 
{
		return competitorLevel;
}

public void setcompetitorLevel(Integer newCompetitorLevel)
{
	competitorLevel = newCompetitorLevel; 
}
		
public String getcompetitorLocation() 
{
		return competitorLocation;
}
public void setcompetitorLocation(String newCompetitorLocation)
{
	competitorLocation = newCompetitorLocation;
}

public String getFullDetails()
{
		String details =  "";
		details = "Zombie's name is " + competitorName.getFullName() + ". Their competitor number is " 
		+ competitorNumber + " and they are level " + competitorLevel + ". \n" + competitorName.getFirstName() 
		+ " hunts in the " + competitorLocation + ". Their scores are " + Arrays.toString(scoresc1) 
		+ " with an overall score of " + getOverallScore()+ "\n";
		return details;
}


}//end public class EEWCompetitor


