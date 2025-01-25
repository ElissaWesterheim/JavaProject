package eewJavaProject;
import java.util.Arrays;

abstract public class Competitor
{
	protected Name competitorName;
	protected int competitorNumber;
	protected int [] scoresc1;
		
	public Competitor(String fullName, Integer number, int [] scores)
	{
		this.competitorName = new Name(fullName);
		this.competitorNumber = number;
		this.scoresc1 = scores;
	}
	public Competitor() {}
	//how to get a constructor to use processline to read itself
	
	public Integer getcompetitorNumber() 
	{
			return competitorNumber;
	}
	public void setcompetitorNumber(Integer newCompetitorNumber)
	{
			competitorNumber = newCompetitorNumber;
	}
	public Name getcompetitorName() 
	{
			return competitorName;
	}
	public void setcompetitorName(Name name)
	{
		competitorName=name;
	}

	public String toString() {
    	return getFullDetails();
    }
	public int [] getScoreArray()
	{
			return scoresc1;
	}
	public void setScoreArray(int [] scores)
	{
			scoresc1=scores;
	}
	
	public abstract double getOverallScore();
	public abstract String getFullDetails();
	
	public String getShortDetails()
	{
		String shortsb = "";
		shortsb = "CN " + competitorNumber + " (" + competitorName.getInitials() + ") " + " has an overall score " + getOverallScore() + ".";
		return shortsb;
	}
	
}
