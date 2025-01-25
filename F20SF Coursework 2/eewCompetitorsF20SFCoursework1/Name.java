package eewCompetitorsF20SFCoursework1;

public class Name 
{
	  private String firstName;
	  private String middleName;
	  private String lastName;
	  
	  public Name(String fName, String lName) 
	  {
			firstName = fName;
			middleName = "";
			lastName = lName;
	  }
	  
	  public Name(String fName, String mName, String lName) 
	  {
			firstName = fName;
			middleName = mName;
			lastName = lName;
	  }
	  
	  public Name (String fullName) 
	  {
		  int spacePos1 = fullName.indexOf(' ');
		  firstName = fullName.substring(0, spacePos1);
		  int spacePos2 = fullName.lastIndexOf(' ');
		  if (spacePos1 == spacePos2)
			  middleName = "";
		  else 
			  middleName = fullName.substring(spacePos1+1, spacePos2);
		  lastName = fullName.substring(spacePos2 + 1);
	  }
	  
	  public String getFirstName() {return firstName; }
	  public String getMiddleName() { return middleName; }
	  public String getLastName() {return lastName; }
	  
	  public void setFirstName(String fn) 
	  {
		  firstName = fn;
	  }
	  public void setMiddleName(String mn) 
	  {
		   middleName = mn;
	  }
	  public void setLastName(String ln) 
	  {
		  lastName = ln;
	  }
	  
	  public String getFirstAndLastName() 
	  {
			return firstName + " " + lastName;
	  }
	  
	  public String getLastCommaFirst() 
	  {
			return lastName + ", "+ firstName;
	  }
	  
	  public String getFullName() 
	  {
		  String result = firstName + " ";
		  if (!middleName.equals("")) 
		  {
			  result += middleName + " ";
		  }
		  result += lastName;
		  return result;	  
	  }
	  
	  public String getInitials()//Alex Hay helped me get this code correct.  I was missing the String.valueOf and if loop.  I thought it would just work with "return firstname.charAt(0) + lastname.charAt(0)".  it didn't.
	  {
		  String initials = String.valueOf(firstName.charAt(0));
		  	if (!middleName.equals(""))
		  	{
		  		initials += middleName.charAt(0);
		  	}
		  	initials += lastName.charAt(0);
	  		return initials;
	  }
	 
	  public int compareTo(Name other) 
	  {
		 String thisName=lastName + " " + firstName + " " + middleName;
		 String othername = other.lastName+ " " + other.firstName + other.middleName;
		 return thisName.compareTo(othername);
	  }

}

