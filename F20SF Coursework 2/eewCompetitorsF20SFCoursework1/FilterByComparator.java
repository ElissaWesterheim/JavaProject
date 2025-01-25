package eewCompetitorsF20SFCoursework1;

import java.util.Comparator;
//not currently in use. code is incomplete.
public class FilterByComparator implements Comparator <Competitor>
{

	@Override
	public int compare(Competitor s1, Competitor s2) 
	{
		return s1.getcompetitorName().compareTo(s2.getcompetitorName());
	}

}
