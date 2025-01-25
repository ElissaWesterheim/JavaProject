package eewJavaProject;
import java.util.Comparator;

public class NameComparator implements Comparator<Competitor>
{
	public int compare(Competitor s1, Competitor s2) 
	{
		return s1.getcompetitorName().compareTo(s2.getcompetitorName());
	}
}
