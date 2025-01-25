package eewCompetitorsF20SFCoursework1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

/**
<p>
@author elissa westerheim (eew2000)
@version 22/10/2022
*/

public class CompetitorList 
{
	private ArrayList<Competitor> competitorList;

	public CompetitorList() 
	{
		competitorList = new ArrayList<Competitor>();
	}

	public void add(Competitor c1)  
	{
		competitorList.add(c1);
	}
	
	public String getFullDetails() 
	{
		String details = "";
		for (Competitor c1 : competitorList) //looping over each competitor
		{
			details += c1.getFullDetails() + "\n";
		}
		return details;
	}

	public String getShortDetails() 
	{
		String shorts = "";
		for (Competitor c1 : competitorList) //looping over each competitor
		{
			shorts += c1.getShortDetails() + "\n";
		}
		return shorts;
	}
	public Competitor processLine(String line, String competitorReport)//calls processLine in the Main for output in
    {
    	return MainEEWcompetitors.processLine(line, competitorReport);
    }
	public String getFullName(String result)
	{
		return getFullName(result);
	}
	public String listDetails()
    {
    	StringBuffer allData = new StringBuffer();
        for(Competitor details : competitorList) {
            allData.append(details);
            allData.append('\n');
        }
        return allData.toString();
    }
	
	public String listByName()
	{
    	Collections.sort(competitorList, new NameComparator());
    	return listDetails();
    }
	
	public String listByNumber()
    {
    	Collections.sort(competitorList, new NumberComparator());
    	return listDetails();
    }
	public Competitor findByCompetitorNumber(Integer CompetitorNumber) 
	{
		for (Competitor c1 : competitorList) 
		{
			if (c1.getcompetitorNumber().equals(CompetitorNumber)) 
			{
				return c1;
			}
		}
		return null;
	}
	//Statistical stuff here
	public double getHighestOverallScore()
	{
		double highScore = 0;
		for (Competitor c1 : competitorList)
		{
			double sc = c1.getOverallScore();
			if (sc> highScore)
			{
				highScore = sc;
			}			
		}
		//System.out.println("The Competitor(s) with the highest Overall score of " + highScore);
		return highScore;
		//don't forget to return stuff outside of the loop
	}
	/**
	 * Constructor writes to output file: "Output.txt"
	 * Short Details and Highest Overall Score
	 * @param CompetitorReport
	 * @param details
	 */
    public void writeToFile(String CompetitorReport, String shorts, Double highest) //String details, 
	{
		FileWriter cl;
		try 
		{
			cl = new FileWriter("Output.txt");
			//cl.write("The Full Details\n");
			//cl.write(details); //CW2 only wants short details and highest overall score in the text file.
			cl.write("The Short Details\n");
			cl.write(shorts);
			cl.write("The competitor with the highest overall score is ");
			cl.write(highest.toString());
			cl.close();// closes file writer
		} catch (IOException oof) 
			{
			System.out.println(CompetitorReport + "oof, nothing happened. Sorry, Friend.");
			}
	}
}// end of public class competitorList

//for future coding fun
/*public int getCountOfScore() //supposed to count the  number of scores of a particular value but it doesn't.
{
	int count1 = 5;  
	for (Competitor c1 : competitorList) 
	{		    		
			for (int s = 0; s < c1.getScoreArray().length; s++) 
			{
				if (count1 == c1.getScoreArray()[s])
				{
				count1++;
				}
			}	
	}
	return count1;
}

/*public int getMaxScore()
{
	int maxScore = 0;
	for (Competitor c1 : competitorList)
	{
		int sc = c1.getScore();//need to finish getScore to get this working.
		if (sc> maxScore) 
		{
			maxScore = sc;System.out.println("getmaxscore");
		}
	}
	return maxScore;
}
public String getScoresFrequencyReport() //call count score here
{
	//work out max score
	int maxScore = getMaxScore();
	//works out frequency of that score
	int [] freqScore = new int [maxScore];
	for (Competitor c1 : competitorList) {
		int s = c1.getScore();//to fix later
		freqScore[s-1]++;
		
	}
	//create a report
	String report = "Frequency of each score\n";
	for (int s = 0; s < freqScore.length; s++) {
		report += "Score " + (s+1) + " : " + freqScore[s] + "\n";
	}
	return report;
}*/