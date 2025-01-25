package eewCompetitorsF20SFCoursework1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

//put GUIs in here
public class Manager extends JFrame  implements ActionListener
{	
	private CompetitorList allComps;
	//GUI components
    JTextField result;
    JTextField searchField;
    JButton search;
    JScrollPane scrollList;
    JButton showListByNumber, showListByName, showFilterBy, close;//showFilterBy is unused.
    JTextArea displayList;
 
    
	public Manager (CompetitorList c1)
	{
		allComps = c1;
		//System.out.println(allComps.getScoresFrequencyReport());
		//set up window title
        setTitle("Competitor List");
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setupSouthPanel();
		setupNorthPanel();
		setupCenterPanel();
		//pack and set visible
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
        
	}
			private void setupCenterPanel() 
			{
		        displayList = new JTextArea(15,20);
		        displayList.setFont(new Font (Font.DIALOG, Font.BOLD,14));
		        displayList.setBackground(new java.awt.Color(202, 184, 210));//pale lavender
		        displayList.setEditable(false);
		        scrollList = new JScrollPane(displayList);
		        this.add(scrollList,BorderLayout.CENTER);
		    }
		    
		    private void setupSouthPanel() 
		    {
		        //search panel contains label, text field and button
		        JPanel searchPanel = new JPanel();
		        searchPanel.setLayout(new GridLayout(1,3));
		        searchPanel.add(new JLabel(" Enter Competitor Number for full details"));
		        searchPanel.setBackground(new java.awt.Color(245, 230, 159));//pale yellow
		        searchField = new JTextField(5);
		        searchPanel.add(searchField);   
		        search = new JButton("Search");  
		        searchPanel.add(search);  
		        search.setBackground(new java.awt.Color(88, 56, 102));//plum
		        search.setForeground(new java.awt.Color(255, 255, 255));//white
		        //specify action when button is pressed
		        search.addActionListener(this) ;
		                
		        //Set up the area where the results will be displayed.
		        result= new JTextField(90);     
		        result.setEditable(false);
		        
		        //set up south panel containing 2 previous areas
		        JPanel southPanel = new JPanel();
		        southPanel.setLayout(new GridLayout(2,1));
		        southPanel.add(searchPanel);
		        southPanel.add(result);
		        
		        //add south panel to the content pane
		        this.add(southPanel, BorderLayout.SOUTH);   	
		    }
		    
		    private void setupNorthPanel() 
		    {
		        //add north panel containing some buttons
		        JPanel northPanel = new JPanel();
		        showListByNumber = new JButton("List By Number");
		        showListByNumber.addActionListener(this);
		        showListByNumber.setBackground(new java.awt.Color(88, 56, 102));//plum
		        showListByNumber.setForeground(new java.awt.Color(255, 255, 255));//white
		        showListByName = new JButton("List By Name");
		        showListByName.addActionListener(this);
		        showListByName.setBackground(new java.awt.Color(88, 56, 102));//plum
		        showListByName.setForeground(new java.awt.Color(255, 255, 255));//white
		        
		        close = new JButton("Close");
		        close.addActionListener(this);
		        close.setBackground(new java.awt.Color(88, 56, 102));//plum
		        close.setForeground(new java.awt.Color(255, 255, 255));//white
		        
		        northPanel.add (showListByNumber);
		        northPanel.add(showListByName);
		        northPanel.add(close);
		        northPanel.setBackground(new java.awt.Color(245, 230, 159));//pale yellow
		        this.add(northPanel, BorderLayout.NORTH);
		       
		    }
		    
		    public void actionPerformed(ActionEvent e) 
		    { 
		    	if (e.getSource() == search) 
		    	{
		    		search();
		    	}
		    	else if (e.getSource() == showListByNumber) 
		    	{
		    		displayList.setText(allComps.listByNumber());
		    		displayList.setBackground(new java.awt.Color(204, 166, 166));//dusty rose
		    	}
		    	else if (e.getSource() == showListByName ) 
		    	{
		    		displayList.setText(allComps.listByName());
		    		displayList.setBackground(new java.awt.Color(199, 129, 129));// darker dusty rose
		    	}
		    	else if (e.getSource() == close) 
		    	{
		    		JOptionPane.showMessageDialog(this, 
		    				 "Thanks for Stopping by!  See ya!");
		    		System.exit(0);
		    	}
		    }  
		  
		    private void search() 
		    {
		    	//get search text and search competitor list
		    	//setting result text 
		        String search = searchField.getText().trim();
		        int search1 = Integer.parseInt(search);
		        
		        //my attempt at fixing the error for if a letter is put in the search box.  Was unsuccessful.
		        /*if((search1 >='a' && search1<='z')|| (search1 >='A' && search1<='Z'))
		        {
		        	result.setText("Please enter a number instead");
		        }*/
		        
		        if(search.length() > 0) 
		        {
		        	Competitor entity = allComps.findByCompetitorNumber(search1);
		            if (entity != null ) 
		            {
		            	result.setText(entity.getFullDetails()); 
		            	JOptionPane.showMessageDialog(null, entity.getFullDetails());
		            }
		            else
		            	result.setText(" Sorry, competitor is not found");
		        }   
		        else
		        	result.setText("no text entered");//for some reason this result doesn't activate in the GUI or output. 
		    }  
		    
		    
		    //wasn't able to get this one to work, or even appear.  I must be missing something somewhere.
		      /*public void filterBy()
		        {
		                String[] filters = {"Zombies", "Horses", "Baseball Players"};

		                String getFilters = (String) JOptionPane.showInputDialog(
		                        null,
		                        "What fruit do you like the most?",
		                        "Choose Fruit",
		                        JOptionPane.QUESTION_MESSAGE,
		                        null,
		                        filters,
		                        filters[3]);
		        }
		                System.out.println("These are the competitors " + getFilters);*/
 		    
		    /*catch (Exception e) 
			{
				e.printStackTrace();
			}*/
	
}




// for future coding fun
//public void run()
	//{		
		/*boolean ok = false;
		int count = 0;
		while (!ok && count <3) 
		{
			String num = JOptionPane.showInputDialog(null, "Enter Competitor Number");
			int num1 = Integer.parseInt(num);
			Competitor justNum;//defines the varible
			try 
			{
				justNum = allComps.findByCompetitorNumber(num1);//finds the competitor that has the number and stores the competitor of that number
				count++;
			if (justNum != null) 
			{
				String firstName = justNum.getcompetitorName().getFirstName();
				System.out.println("The competitor with number " + num + " is called " + firstName);
				JOptionPane.showMessageDialog(null, "The competitor with number " + num + " is called " + firstName);
				ok = true;
			}
			else  
			{
				System.out.println("Incorrect number");
				JOptionPane.showMessageDialog(null,"Incorrect number");
				if (count <= 3) 
				{
					System.out.println("Please try again");
					JOptionPane.showMessageDialog(null,"Please try again");
				}
			}
		}*/
	//}	