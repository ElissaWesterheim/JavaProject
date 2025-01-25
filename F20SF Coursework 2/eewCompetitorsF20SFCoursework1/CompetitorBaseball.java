package eewCompetitorsF20SFCoursework1;
import java.util.Arrays;

//This class defines imaginary baseball players.  It is a home run competition.  
//Their field position modifies their batting average aka OverallScore.

public class CompetitorBaseball extends Competitor
{
		//instance variables
		private String competitorPosition;
		private String competitorTeam;
				    
	public CompetitorBaseball(String fullName, Integer number, String position, String team, int [] scoresc1)  
	{
		super(fullName, number,scoresc1);
		this.competitorPosition = position;
		this.competitorTeam = team;
			
	}
	//public int getScore()//this is here for getMaxScore() but i have not done anything with it yet.
	//{
		//return scores;
	//}
	
	
	public String getcompetitorPosition() 
	{
		return competitorPosition;
	}

	public void setcompetitorPosition(String newCompetitorPosition)
	{
		competitorPosition = newCompetitorPosition; 
	}
	public double getOverallScore()
	{
		int total = 0;
		for (int scoresc1Index = 0; scoresc1Index < scoresc1.length; scoresc1Index++)
		{
			total += scoresc1[scoresc1Index];
		}
		if (competitorPosition.equals("Pitcher"))//Pitchers are historically bad at batting so they are penalized for it. 
		{
				return (double) (total*.5)/scoresc1.length;
		}
		else if (competitorPosition.equals("Infielder"))//Infielder have no advantage or disadvantage. 
			{
				
			return (double) (total*1)/scoresc1.length;
			}
		else 
		{
			return (double) (total*1.5)/scoresc1.length;// Outfielders are awesome at batting. they get an advantage.
		}
	
	}	
	public String getcompetitorTeam() 
	{
		return competitorTeam;
	}
	public void setcompetitorTeam(String newCompetitorTeam)
	{
		competitorTeam = newCompetitorTeam;
	}

	public String getFullDetails()
	{
		String details =  "";
		details = "Player's name is " + competitorName.getFullName() + ". "
				+ "Their competitor number is " + competitorNumber + " and they are a " + competitorPosition + ". \n" 
				+ competitorName.getFirstName() + " plays for the " + competitorTeam + ". Their scores are " 
				+ Arrays.toString(scoresc1) + " with a batting average of " + getOverallScore()+ "\n";
		return details;
	}
	
	public String toString() 
	{
		return competitorName.getFullName()+ " is competitor number " + competitorNumber + ".";
	}
}//end public class CompetitorBaseball


