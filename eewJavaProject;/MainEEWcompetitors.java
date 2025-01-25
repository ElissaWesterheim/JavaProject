package eewJavaProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainEEWcompetitors 
{

	public static void main(String[] args) 
	{
		CompetitorList c1 = new CompetitorList();
		String[] competitorReports = {"EEWcompetitors.csv","Baseball Competitors.csv","Horse Competitors.csv"};//will only read these 3 files
		c1 = readFiles(competitorReports);
		String details = c1.getFullDetails();
		String shorts = c1.getShortDetails();
		//int score = c1.getCountOfScore();
		double highest = c1.getHighestOverallScore();
		c1.writeToFile("Output.txt", shorts,highest);
		//System.out.println(details);//used for testing code
		//System.out.println(shorts);
		//System.out.println(score);
		System.out.println(highest);
		Manager m = new Manager(c1);
				
	}//end main method
	
	
	public static CompetitorList readFiles(String [] competitorReports)// pulled from https://explainjava.com/java-read-file
	{
		CompetitorList c1 = new CompetitorList(); 
		
		for (String competitorReport : competitorReports)
		{
			try {// had a FileNotFound exception before I put this try/catch in
				
				File L = new File(competitorReport);
				Scanner scanner = new Scanner(L);
				//something that checks for first line; reads that line, will not process as a competitor; this ignores the title line in .csv files
				if (scanner.hasNextLine())
				{
					scanner.nextLine();
				}
				while (scanner.hasNextLine()) 
				{				
					String inputLine = scanner.nextLine();
					if (inputLine.length() != 0)
					{
						Competitor competitor = processLine(inputLine,competitorReport);
						c1.add(competitor);//these two lines we are setting competitor to whatever processLine processes and adding that competitor to our ComReport.
					}
				}
				scanner.close();
			} catch (FileNotFoundException oof) {
				System.out.println(oof + "oof, nothing there, buddy.");//this worked when I had the Baseball .csv file in the wrong folder! It was cool.
			}
		}
		return c1;
	}
	public static Competitor processLine(String line, String competitorReport)
	{
		Competitor competitor = null;
		try
		{
			String details [] = line.split(",");
						
			//find the name;
			String name = details[0];
								
			//find the number; 
			String numberCom = details[1]; 
			int number = Integer.parseInt(numberCom);
									
			//find the scores; 
			//generally there will always be 4 known data points, name, level, location, number, or other attributes before the scores.
			//will run into a problem if the data in the .csv is listed in a different order.
			int scoresc1Length = details.length - 4;//this snips the beginning of array, details, to allow the scores to be processed in a different way
			int scoresc1[] = new int[scoresc1Length];
			for (int s = 0; s < scoresc1.length; s++) 
			{
				String currentScore = details[4+s];//runs through the scores, can be scaled
				int current = Integer.parseInt(currentScore);
				scoresc1[0+s] = current;
			}
			
			if (competitorReport.equals("EEWcompetitors.csv"))
			{
				String level1 = details[2];
				int level = Integer.parseInt(level1);
				String location = details[3];
				competitor = new EEWCompetitor(name,number,level,location,scoresc1);}
			
			if (competitorReport.equals("Baseball Competitors.csv"))
			{
				String position = details[2];
				String team = details[3];
				competitor = new CompetitorBaseball(name,number,position,team,scoresc1);
			}
			
			if (competitorReport.equals("Horse Competitors.csv"))
			{
				String hands1 = details[2];
				double hands = Double.parseDouble(hands1);
				String location = details[3];
				competitor = new CompetitorHorses(name,number,hands,location,scoresc1);}
		} finally {}
		return competitor;
	}
}//end class

