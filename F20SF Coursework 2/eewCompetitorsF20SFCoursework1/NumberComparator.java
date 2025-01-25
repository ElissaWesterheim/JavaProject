package eewCompetitorsF20SFCoursework1;

import java.util.Comparator;

public class NumberComparator implements Comparator<Competitor> {

	public int compare(Competitor s1, Competitor s2) 
	{
		return s1.getcompetitorNumber().compareTo(s2.getcompetitorNumber());
	}

}
